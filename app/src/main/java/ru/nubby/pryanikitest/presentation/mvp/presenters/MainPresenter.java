package ru.nubby.pryanikitest.presentation.mvp.presenters;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import io.reactivex.disposables.CompositeDisposable;
import ru.nubby.pryanikitest.Injection;
import ru.nubby.pryanikitest.data.Repository;
import ru.nubby.pryanikitest.model.Data;
import ru.nubby.pryanikitest.model.Type;
import ru.nubby.pryanikitest.model.TypedElement;
import ru.nubby.pryanikitest.presentation.mvp.views.MainView;
import ru.nubby.pryanikitest.util.BaseSchedulerProvider;

@InjectViewState
public class MainPresenter extends MvpPresenter<MainView> {

    private Repository mRepository;
    private BaseSchedulerProvider mSchedulerProvider;
    private CompositeDisposable mTasks;

    /**
     * Please note, that this list differs from the one we get from response.
     * This will be displayed in our RecyclerView.
     * Each element holds not just its Type, but also its Data value.
     * This list will be reconstructed after each reload.
     */
    private List<TypedElement> mTypedElements = new ArrayList<>();


    public MainPresenter() {
        super();

        mRepository = Injection.provideRepository();
        mSchedulerProvider = Injection.provideSchedulerProvider();

        mTasks = new CompositeDisposable();
    }

    @Override
    protected void onFirstViewAttach() {
        getItems();
    }

    public void loadNewItems(){
        getItems();
    }

    private void getItems() {
        mTasks.add(mRepository.getData()
                .subscribeOn(mSchedulerProvider.io())
                .observeOn(mSchedulerProvider.ui())
                .doOnSubscribe(result -> {
                    mTypedElements = new ArrayList<>();
                    getViewState().showRefreshing();
                    //actually its better to show progressbar inside of recyclerview
                    //current implementation is cheap and might be rewritten
                })
                .subscribe(
                        result -> {
                            Map<Type, Data> mappedData = new HashMap<>();
                            for (TypedElement element: result.getData()) {
                                mappedData.put(element.getType(), element.getData());
                            }
                            for (Type type: result.getViewList()) {
                                TypedElement newElement = new TypedElement();
                                newElement.setData(new Data(mappedData.get(type)));
                                newElement.setType(type);
                                mTypedElements.add(newElement);
                            }
                            getViewState().setDisplayList(mTypedElements);
                            getViewState().hideRefreshing();
                        },
                        error -> {
                            getViewState().showMessage("Can't fetch data. Try again later please.");
                            getViewState().hideRefreshing();
                        }));
    }

    @Override
    public void onDestroy() {
        mTasks.dispose();
        super.onDestroy();
    }
}

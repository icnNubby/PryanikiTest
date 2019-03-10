package ru.nubby.pryanikitest.presentation.mvp;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;

import java.util.HashMap;
import java.util.Map;

import io.reactivex.disposables.CompositeDisposable;
import ru.nubby.pryanikitest.Injection;
import ru.nubby.pryanikitest.domain.Repository;
import ru.nubby.pryanikitest.model.Data;
import ru.nubby.pryanikitest.model.Type;
import ru.nubby.pryanikitest.model.TypedElement;
import ru.nubby.pryanikitest.util.BaseSchedulerProvider;

@InjectViewState
public class MainPresenter extends MvpPresenter<MainView> {

    private Repository mRepository;
    private BaseSchedulerProvider mSchedulerProvider;
    private CompositeDisposable mTasks;


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
                .doOnSubscribe(result -> getViewState().showRefreshing())
                .subscribe(
                        result -> {
                            Map<Type, Data> mappedData = new HashMap<>();
                            for (TypedElement element: result.getData()) {
                                mappedData.put(element.getName(), element.getData());
                            }
                            getViewState().setTypeList(mappedData);
                            getViewState().setDisplayList(result.getView());
                            getViewState().hideRefreshing();
                        },
                        error -> {
                            getViewState().showError("Error while loading");
                            getViewState().hideRefreshing();
                        }));
    }
}

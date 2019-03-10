package ru.nubby.pryanikitest.presentation.ui;

import android.os.Bundle;
import android.widget.Toast;

import com.arellomobile.mvp.presenter.InjectPresenter;

import java.util.List;
import java.util.Map;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import ru.nubby.pryanikitest.R;
import ru.nubby.pryanikitest.model.Data;
import ru.nubby.pryanikitest.model.Type;
import ru.nubby.pryanikitest.model.TypedElement;
import ru.nubby.pryanikitest.presentation.MvpAppCompatActivity;
import ru.nubby.pryanikitest.presentation.mvp.MainPresenter;
import ru.nubby.pryanikitest.presentation.mvp.MainView;

public class MainActivity extends MvpAppCompatActivity implements MainView {
    private final String TAG = MainActivity.class.getSimpleName();

    private RecyclerView mRecyclerView;
    private MainRecyclerViewAdapter mRecyclerViewAdapter;
    private SwipeRefreshLayout mSwipeRefreshLayout;

    @InjectPresenter
    MainPresenter mMainPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mRecyclerView = findViewById(R.id.item_list_recycler_view);
        mRecyclerViewAdapter = new MainRecyclerViewAdapter(this);
        mRecyclerView.setAdapter(mRecyclerViewAdapter);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        mSwipeRefreshLayout = findViewById(R.id.swipe_refresh_layout);
        mSwipeRefreshLayout.setOnRefreshListener(() -> mMainPresenter.loadNewItems());
    }

    @Override
    public void setTypeList(Map<Type, Data> typeList) {
        mRecyclerViewAdapter.setTypedElements(typeList);
    }

    @Override
    public void setDisplayList(List<Type> types) {
        mRecyclerViewAdapter.setList(types);
    }

    @Override
    public void showError(String message) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show();
    }

    @Override
    public void showRefreshing() {
        mSwipeRefreshLayout.setRefreshing(true);
    }

    @Override
    public void hideRefreshing() {
        mSwipeRefreshLayout.setRefreshing(false);
    }

}

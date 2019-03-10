package ru.nubby.pryanikitest.presentation.ui;

import android.os.Bundle;
import android.widget.Toast;

import com.arellomobile.mvp.presenter.InjectPresenter;

import java.util.List;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import ru.nubby.pryanikitest.R;
import ru.nubby.pryanikitest.model.TypedElement;
import ru.nubby.pryanikitest.presentation.MvpAppCompatActivity;
import ru.nubby.pryanikitest.presentation.mvp.MainPresenter;
import ru.nubby.pryanikitest.presentation.mvp.MainView;

public class MainActivity extends MvpAppCompatActivity implements MainView {

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
        mRecyclerViewAdapter = new MainRecyclerViewAdapter(this, getMvpDelegate());
        mRecyclerView.setAdapter(mRecyclerViewAdapter);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        mSwipeRefreshLayout = findViewById(R.id.swipe_refresh_layout);
        mSwipeRefreshLayout.setOnRefreshListener(() -> mMainPresenter.loadNewItems());
    }

    @Override
    public void setDisplayList(List<TypedElement> typedList) {
        mRecyclerViewAdapter.setList(typedList);
    }

    @Override
    public void showMessage(String message) {
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

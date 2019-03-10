package ru.nubby.pryanikitest.presentation.ui.viewholders;

import android.content.Context;
import android.view.View;
import android.widget.Toast;

import com.arellomobile.mvp.MvpDelegate;
import com.arellomobile.mvp.presenter.InjectPresenter;
import com.arellomobile.mvp.presenter.ProvidePresenter;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import ru.nubby.pryanikitest.model.Data;
import ru.nubby.pryanikitest.model.Type;
import ru.nubby.pryanikitest.model.TypedElement;
import ru.nubby.pryanikitest.presentation.mvp.ItemPresenter;
import ru.nubby.pryanikitest.presentation.mvp.ItemView;
import ru.nubby.pryanikitest.presentation.ui.MainRecyclerViewAdapter;

public abstract class BaseViewHolder extends RecyclerView.ViewHolder
        implements View.OnClickListener, ItemView {
    protected Data mData;
    protected Type mType;
    protected Context mContext;

    private MvpDelegate mMvpDelegate;

    private MainRecyclerViewAdapter mViewAdapter;

    @InjectPresenter
    ItemPresenter mItemPresenter;

    @ProvidePresenter
    ItemPresenter provideItemPresenter() {
        return new ItemPresenter();
    }

    BaseViewHolder(@NonNull View itemView, Context context, MainRecyclerViewAdapter adapter) {
        super(itemView);
        mContext = context;
        mViewAdapter = adapter;
        itemView.setOnClickListener(this);
    }

    public void bind(TypedElement element) {
        if (getMvpDelegate() != null) {
            getMvpDelegate().onSaveInstanceState();
            getMvpDelegate().onDetach();
            getMvpDelegate().onDestroyView();
            mMvpDelegate = null;
        }
        mData = element.getData();
        mType = element.getName();
        getMvpDelegate().onCreate();
        getMvpDelegate().onAttach();
    }

    @Override
    public void onClick(View v) {
        mItemPresenter.itemClicked(mType);
    }

    @Override
    public void showMessage(String message) {
        Toast.makeText(mContext, message, Toast.LENGTH_LONG).show();
    }

    MvpDelegate getMvpDelegate() {
        if (mData == null) {
            return null;
        }

        if (mMvpDelegate == null) {
            mMvpDelegate = new MvpDelegate<>(this);
            mMvpDelegate.setParentDelegate(mViewAdapter.getMvpDelegate(), String.valueOf(mData.hashCode()));

        }
        return mMvpDelegate;
    }
}

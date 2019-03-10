package ru.nubby.pryanikitest.presentation.ui.viewholders;

import android.view.View;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import ru.nubby.pryanikitest.model.Data;

public abstract class BaseViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
    protected Data mData;

    public BaseViewHolder(@NonNull View itemView) {
        super(itemView);
    }

    public void setData(Data data) {
        mData = data;
    };
}

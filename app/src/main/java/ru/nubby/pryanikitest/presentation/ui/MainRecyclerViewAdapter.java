package ru.nubby.pryanikitest.presentation.ui;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import ru.nubby.pryanikitest.R;
import ru.nubby.pryanikitest.model.TypedElement;
import ru.nubby.pryanikitest.presentation.ui.viewholders.BaseViewHolder;
import ru.nubby.pryanikitest.presentation.ui.viewholders.PictureElementViewHolder;
import ru.nubby.pryanikitest.presentation.ui.viewholders.RadioGroupElementViewHolder;
import ru.nubby.pryanikitest.presentation.ui.viewholders.TextElementViewHolder;

public class MainRecyclerViewAdapter extends RecyclerView.Adapter<BaseViewHolder> {

    private Context mContext;
    private List<TypedElement> mList = new ArrayList<>();

    MainRecyclerViewAdapter(Context context){
        mContext = context;
    }

    public void setList(List<TypedElement> typeList) {
        mList = typeList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public BaseViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view;
        BaseViewHolder newViewHolder;
        switch (viewType) {
            case 0: {
                view = LayoutInflater.from(mContext)
                        .inflate(R.layout.text_item, parent, false);
                newViewHolder = new TextElementViewHolder(view);
                break;
            }
            case 1: {
                view = LayoutInflater.from(mContext)
                        .inflate(R.layout.picture_item, parent, false);
                newViewHolder = new PictureElementViewHolder(view);
                break;
            }
            case 2: {
                view = LayoutInflater.from(mContext)
                        .inflate(R.layout.selection_item, parent, false);
                newViewHolder = new RadioGroupElementViewHolder(view, mContext);
                break;
            }
            default: {
                view = LayoutInflater.from(mContext)
                        .inflate(R.layout.text_item, parent, false);
                newViewHolder = new TextElementViewHolder(view);
                break;
            }
        }

        return newViewHolder;
    }

    @Override
    public int getItemViewType(int position) {
        return mList.get(position).getName().ordinal();
    }

    @Override
    public void onBindViewHolder(@NonNull BaseViewHolder holder, int position) {
        holder.setData(mList.get(position).getData());
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }


}

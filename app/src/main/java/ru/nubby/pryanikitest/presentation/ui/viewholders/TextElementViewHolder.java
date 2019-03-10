package ru.nubby.pryanikitest.presentation.ui.viewholders;

import android.content.Context;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import ru.nubby.pryanikitest.R;
import ru.nubby.pryanikitest.model.Data;
import ru.nubby.pryanikitest.model.TypedElement;
import ru.nubby.pryanikitest.presentation.ui.MainRecyclerViewAdapter;

public class TextElementViewHolder extends BaseViewHolder {

    private TextView mTextView;

    public TextElementViewHolder(@NonNull View itemView,
                                 Context context,
                                 MainRecyclerViewAdapter adapter) {
        super(itemView, context, adapter);
        mTextView = itemView.findViewById(R.id.text_view);
    }

    @Override
    public void bind(TypedElement element) {
        super.bind(element);
        mTextView.setText(element.getData().getText());
    }

}

package ru.nubby.pryanikitest.presentation.ui.viewholders;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import ru.nubby.pryanikitest.R;
import ru.nubby.pryanikitest.model.Data;
import ru.nubby.pryanikitest.presentation.ui.viewholders.BaseViewHolder;

public class TextElementViewHolder extends BaseViewHolder {
    private TextView mTextView;

    public TextElementViewHolder(@NonNull View itemView) {
        super(itemView);
        mTextView = itemView.findViewById(R.id.text_view);
    }

    @Override
    public void setData(Data data) {
        mTextView.setText(data.getText());
    }
}

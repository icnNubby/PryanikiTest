package ru.nubby.pryanikitest.presentation.ui.viewholders;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import androidx.annotation.NonNull;
import ru.nubby.pryanikitest.R;
import ru.nubby.pryanikitest.model.Data;

public class PictureElementViewHolder extends BaseViewHolder {

    private TextView mTextView;
    private ImageView mImageView;

    public PictureElementViewHolder(@NonNull View itemView) {
        super(itemView);
        mTextView = itemView.findViewById(R.id.text_view);
        mImageView = itemView.findViewById(R.id.image_view);
    }

    @Override
    public void setData(Data data) {
        super.setData(data);
        mTextView.setText(data.getText());
        Picasso.get()
                .load(data.getUrl())
                .into(mImageView);
    }

    @Override
    public void onClick(View v) {

    }
}

package ru.nubby.pryanikitest.presentation.ui.viewholders;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import androidx.annotation.NonNull;
import ru.nubby.pryanikitest.R;
import ru.nubby.pryanikitest.model.TypedElement;
import ru.nubby.pryanikitest.presentation.ui.MainRecyclerViewAdapter;

public class PictureElementViewHolder extends BaseViewHolder {

    private TextView mTextView;
    private ImageView mImageView;

    public PictureElementViewHolder(@NonNull View itemView,
                                    Context context,
                                    MainRecyclerViewAdapter adapter) {
        super(itemView, context, adapter);
        mTextView = itemView.findViewById(R.id.text_view);
        mImageView = itemView.findViewById(R.id.image_view);
    }

    @Override
    public void bind(TypedElement element) {
        super.bind(element);
        mTextView.setText(element.getData().getText());
        Picasso.get()
                .load(element.getData().getUrl())
                .into(mImageView);
    }

}

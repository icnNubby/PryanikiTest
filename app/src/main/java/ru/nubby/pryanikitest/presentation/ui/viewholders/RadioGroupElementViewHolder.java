package ru.nubby.pryanikitest.presentation.ui.viewholders;

import android.content.Context;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import androidx.annotation.NonNull;
import ru.nubby.pryanikitest.R;
import ru.nubby.pryanikitest.model.TypedElement;
import ru.nubby.pryanikitest.model.Variant;
import ru.nubby.pryanikitest.presentation.ui.MainRecyclerViewAdapter;

public class RadioGroupElementViewHolder extends BaseViewHolder {

    private RadioGroup mRadioGroup;
    private Context mContext;

    public RadioGroupElementViewHolder(@NonNull View itemView,
                                       Context context,
                                       MainRecyclerViewAdapter adapter) {
        super(itemView, context, adapter);
        mRadioGroup = itemView.findViewById(R.id.radio_group);
        mContext = context;
    }

    @Override
    public void bind(TypedElement element) {
        super.bind(element);
        //In case if incoming id's does not match natural order, or skips some indices, etc.
        Map<Integer, Integer> indicesMapping = new HashMap<>();
        List<Variant> variants = element.getData().getVariants();
        mRadioGroup.removeAllViews();
        int i = 0;
        for (Variant variant: variants) {
            RadioButton button = new RadioButton(mContext);
            indicesMapping.put(variant.getId(), i++);
            mRadioGroup.addView(button);
            button.setText(variant.getText());
            button.setOnClickListener(v -> {
                mData.setSelectedId(variant.getId());
                mItemPresenter.variantSelected(variant);
            });
        }
        int selectedId = element.getData().getSelectedId();
        Integer index = indicesMapping.get(selectedId);
        if (index != null) {
            ((RadioButton) mRadioGroup.getChildAt(index)).setChecked(true);
        }
    }

    @Override
    public void onClick(View v) {
        //should be empty, otherwise it will notify about clicking in radio group area
    }
}

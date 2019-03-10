package ru.nubby.pryanikitest.presentation.ui.viewholders;

import android.content.Context;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import androidx.annotation.NonNull;
import ru.nubby.pryanikitest.R;
import ru.nubby.pryanikitest.model.Data;
import ru.nubby.pryanikitest.model.Variant;
import ru.nubby.pryanikitest.presentation.ui.viewholders.BaseViewHolder;

public class RadioGroupElementViewHolder extends BaseViewHolder {

    private final List<RadioButton> mRadioButtons = new ArrayList<>();

    //In case if incoming id's does not match natural order, or skips some indices, etc.
    private Map<Integer, Integer> mIndicesMapping = new HashMap<>();
    private List<Variant> mVariants;

    private RadioGroup mRadioGroup;
    private Context mContext;

    public RadioGroupElementViewHolder(@NonNull View itemView, Context context) {
        super(itemView);
        mRadioGroup = itemView.findViewById(R.id.radio_group);
        mContext = context;
    }

    @Override
    public void setData(Data data) {
        mIndicesMapping = new HashMap<>();
        mVariants = data.getVariants();
        int i = 0;
        for (Variant variant: mVariants) {
            RadioButton button = new RadioButton(mContext);
            mIndicesMapping.put(variant.getId(), i++);
            mRadioButtons.add(button);
            mRadioGroup.addView(button);
            button.setText(variant.getText());
        }
        Integer index = mIndicesMapping.get(data.getSelectedId());
        if (index != null) {
            ((RadioButton) mRadioGroup.getChildAt(index)).setChecked(true);
        }
    }
}

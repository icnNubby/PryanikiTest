package ru.nubby.pryanikitest.presentation.mvp;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;

import ru.nubby.pryanikitest.model.Type;
import ru.nubby.pryanikitest.model.Variant;

@InjectViewState
public class ItemPresenter extends MvpPresenter<ItemView> {

    public void itemClicked(Type item) {
        getViewState().showMessage("Item " + item + " was clicked");
    }

    public void variantSelected(Variant variant) {
        getViewState().showMessage("In selector " + variant.getText() + " was selected");
    }
}

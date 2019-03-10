package ru.nubby.pryanikitest.presentation.mvp;

import com.arellomobile.mvp.MvpView;

public interface ItemView extends MvpView {
    void showMessage(String message);
}

package ru.nubby.pryanikitest.presentation.mvp.views;

import com.arellomobile.mvp.MvpView;
import com.arellomobile.mvp.viewstate.strategy.SkipStrategy;
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType;

public interface ItemView extends MvpView {

    @StateStrategyType(SkipStrategy.class)
    void showMessage(String message);
}

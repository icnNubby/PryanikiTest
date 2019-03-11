package ru.nubby.pryanikitest.presentation.mvp.views;

import com.arellomobile.mvp.MvpView;
import com.arellomobile.mvp.viewstate.strategy.AddToEndSingleStrategy;
import com.arellomobile.mvp.viewstate.strategy.SkipStrategy;
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType;

import java.util.List;

import ru.nubby.pryanikitest.model.TypedElement;

public interface MainView extends MvpView {

    @StateStrategyType(AddToEndSingleStrategy.class)
    void setDisplayList(List<TypedElement> typedList);

    @StateStrategyType(SkipStrategy.class)
    void showMessage(String message);

    void showRefreshing();

    void hideRefreshing();
}

package ru.nubby.pryanikitest.presentation.mvp;

import com.arellomobile.mvp.MvpView;
import com.arellomobile.mvp.viewstate.strategy.AddToEndSingleStrategy;
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType;

import java.util.List;
import java.util.Map;

import ru.nubby.pryanikitest.model.Data;
import ru.nubby.pryanikitest.model.Type;

public interface MainView extends MvpView {

    @StateStrategyType(AddToEndSingleStrategy.class)
    void setTypeList(Map<Type, Data> typeList);

    @StateStrategyType(AddToEndSingleStrategy.class)
    void setDisplayList(List<Type> types);

    void showError(String message);

    void showRefreshing();

    void hideRefreshing();
}

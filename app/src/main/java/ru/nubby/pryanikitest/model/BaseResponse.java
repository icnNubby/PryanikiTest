package ru.nubby.pryanikitest.model;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class BaseResponse {

    @SerializedName("data")
    private List<TypedElement> data = null;

    @SerializedName("view")
    private List<Type> viewList = null;

    public List<TypedElement> getData() {
        return data;
    }

    public void setData(List<TypedElement> data) {
        this.data = data;
    }

    public List<Type> getViewList() {
        return viewList;
    }

    public void setViewList(List<Type> viewList) {
        this.viewList = viewList;
    }

}

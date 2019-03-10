package ru.nubby.pryanikitest.model;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class ViewElementList {

    @SerializedName("data")
    private List<ViewType> data = null;

    @SerializedName("view")
    private List<String> view = null;

    public List<ViewType> getData() {
        return data;
    }

    public void setData(List<ViewType> data) {
        this.data = data;
    }

    public List<String> getView() {
        return view;
    }

    public void setView(List<String> view) {
        this.view = view;
    }

}

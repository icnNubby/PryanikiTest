package ru.nubby.pryanikitest.model;

import com.google.gson.annotations.SerializedName;

public class ViewType {

    @SerializedName("name")
    private String name;

    @SerializedName("data")
    private Data data;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }

}
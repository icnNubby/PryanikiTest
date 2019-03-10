package ru.nubby.pryanikitest.model;

import com.google.gson.annotations.SerializedName;

public class TypedElement {

    @SerializedName("name")
    private Type name = null;

    @SerializedName("data")
    private Data data;

    public Type getName() {
        return name;
    }

    public void setName(Type name) {
        this.name = name;
    }

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }

}
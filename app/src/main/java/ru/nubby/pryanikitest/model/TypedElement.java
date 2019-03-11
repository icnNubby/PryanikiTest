package ru.nubby.pryanikitest.model;

import com.google.gson.annotations.SerializedName;

public class TypedElement {

    @SerializedName("name")
    private Type type = null;

    @SerializedName("data")
    private Data data;

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }

}
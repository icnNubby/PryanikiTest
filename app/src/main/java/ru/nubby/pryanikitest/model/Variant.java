package ru.nubby.pryanikitest.model;

import com.google.gson.annotations.SerializedName;

public class Variant {

    @SerializedName("id")
    private Integer id;

    @SerializedName("text")
    private String text;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

}

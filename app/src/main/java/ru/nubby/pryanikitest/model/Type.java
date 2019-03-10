package ru.nubby.pryanikitest.model;

import com.google.gson.annotations.SerializedName;

public enum Type {
    @SerializedName("hz")
    TEXT,
    @SerializedName("picture")
    PICTURE,
    @SerializedName("selector")
    SELECTOR
}

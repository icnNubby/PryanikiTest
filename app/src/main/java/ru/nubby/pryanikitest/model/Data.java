
package ru.nubby.pryanikitest.model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class Data {

    @SerializedName("text")
    private String text;

    @SerializedName("url")
    private String url;

    @SerializedName("selectedId")
    private Integer selectedId;

    @SerializedName("variants")
    private List<Variant> variants = null;

    public Data(Data data) {
        if (data != null) {
            this.text = data.getText();
            this.url = data.getUrl();
            this.selectedId = data.getSelectedId();
            this.variants = new ArrayList<>();
            if (data.getVariants() != null) {
                for (Variant variant : data.getVariants()) {
                    this.variants.add(new Variant(variant));
                }
            }
        }
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Integer getSelectedId() {
        return selectedId;
    }

    public void setSelectedId(Integer selectedId) {
        this.selectedId = selectedId;
    }

    public List<Variant> getVariants() {
        return variants;
    }

    public void setVariants(List<Variant> variants) {
        this.variants = variants;
    }

}
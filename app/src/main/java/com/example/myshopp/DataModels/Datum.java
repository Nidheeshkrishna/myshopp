package com.example.myshopp.DataModels;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;
public class Datum extends SliderImages {
    @SerializedName("images")
    @Expose
    private String images;

    public String getImages() {
        return images;
    }

    public void setImages(String images) {
        this.images = images;
    }
}

package com.example.myshopp.DataModels;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class LogiData {

    @SerializedName("status")
    @Expose
    private Boolean status;
    @SerializedName("erorr_message")
    @Expose
    private String erorr_message;

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public String getMessage() {
        return erorr_message;
    }

    public void setMessage(String erorr_message) {
        this.erorr_message = erorr_message;
    }

}
package com.example.myshopp.DataModels;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Regidata {

    @SerializedName("mob")
    @Expose
    String Mob;
    @SerializedName("status")
    @Expose
    String status;

    public String getOtp() {
        return otp;
    }

    public void setOtp(String otp) {
        this.otp = otp;
    }

    @SerializedName("otp")
    @Expose
    String otp;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }



    public String getMob() {
        return Mob;
    }

    public void setMob(String mob) {
        Mob = mob;
    }
}

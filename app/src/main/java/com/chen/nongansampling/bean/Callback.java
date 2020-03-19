package com.chen.nongansampling.bean;

import com.google.gson.annotations.SerializedName;

public class Callback {
    @SerializedName("State")
    private int state;
    @SerializedName("AlertMessage")
    private String alertMessage;

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public String getAlertMessage() {
        return alertMessage;
    }

    public void setAlertMessage(String alertMessage) {
        this.alertMessage = alertMessage;
    }
}

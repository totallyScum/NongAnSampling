package com.chen.nongansampling.model;

import com.google.gson.annotations.SerializedName;

/**
 */

public class CallbackData<T> {
    @SerializedName("State")
    private int state;
    @SerializedName("AlertMessage")
    private String alertMessage;
   // @SerializedName(value = "Data", alternate = {"subjects", "result"})
   @SerializedName(value = "Account",alternate = {"Data","TypeList"})
    private T data;


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
        alertMessage = alertMessage;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "Result{" +
                "state=" + state +
                ", AlertMessage='" + alertMessage + '\'' +
                ", data=" + data +
                '}';
    }
}

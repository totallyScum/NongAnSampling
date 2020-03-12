package com.chen.nongansampling.bean;

import com.google.gson.annotations.SerializedName;

public class TodayResponseBean {
    @SerializedName("SamplingCount")
    private String samplingCount;
    @SerializedName("DetectionCount")
    private String detectionCount;
    @SerializedName("TrueDetectionCount")
    private String trueDetectionCount;
    @SerializedName("AlertMessage")
    private String alertMessage;
    @SerializedName("State")
    private String state;



    public String getSamplingCount() {
        return samplingCount;
    }

    public void setSamplingCount(String samplingCount) {
        this.samplingCount = samplingCount;
    }

    public String getDetectionCount() {
        return detectionCount;
    }

    public void setDetectionCount(String detectionCount) {
        this.detectionCount = detectionCount;
    }

    public String getTrueDetectionCount() {
        return trueDetectionCount;
    }

    public void setTrueDetectionCount(String trueDetectionCount) {
        this.trueDetectionCount = trueDetectionCount;
    }

    public String getAlertMessage() {
        return alertMessage;
    }

    public void setAlertMessage(String alertMessage) {
        this.alertMessage = alertMessage;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}

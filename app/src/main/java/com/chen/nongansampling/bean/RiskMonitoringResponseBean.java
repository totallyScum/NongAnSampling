package com.chen.nongansampling.bean;

import com.google.gson.annotations.SerializedName;

public class RiskMonitoringResponseBean {
    @SerializedName("SamplingTime")
    String samplingTime;
    @SerializedName("SampleNumber")
    String sampleNumber;
    @SerializedName("SampleName")
    String sampleName;
    @SerializedName("BoothNumber")
    String boothNumber;
    @SerializedName("OperatingHouseholds")
    String operatingHouseholds;
    @SerializedName("Type")
    String type;
    @SerializedName("Result")
    String result;

    public String getSamplingTime() {
        return samplingTime;
    }

    public void setSamplingTime(String samplingTime) {
        this.samplingTime = samplingTime;
    }

    public String getSampleNumber() {
        return sampleNumber;
    }

    public void setSampleNumber(String sampleNumber) {
        this.sampleNumber = sampleNumber;
    }

    public String getSampleName() {
        return sampleName;
    }

    public void setSampleName(String sampleName) {
        this.sampleName = sampleName;
    }

    public String getBoothNumber() {
        return boothNumber;
    }

    public void setBoothNumber(String boothNumber) {
        this.boothNumber = boothNumber;
    }

    public String getOperatingHouseholds() {
        return operatingHouseholds;
    }

    public void setOperatingHouseholds(String operatingHouseholds) {
        this.operatingHouseholds = operatingHouseholds;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }
}

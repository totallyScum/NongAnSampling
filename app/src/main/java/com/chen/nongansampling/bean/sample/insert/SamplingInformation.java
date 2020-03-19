package com.chen.nongansampling.bean.sample.insert;

import com.google.gson.annotations.SerializedName;

public class SamplingInformation {
    @SerializedName("SampleNumber")
private String sampleNumber;
    @SerializedName("SamplingTime")

    private String samplingTime;
    @SerializedName("SampleName")

    private String sampleName;
    @SerializedName("SampleType")

    private String sampleType;
    @SerializedName("OperatingHouseholdId")

    private String operatingHouseholdId;
    @SerializedName("SampleAccountId")

    private String sampleAccountId;
    @SerializedName("SamplePhoto")

    private String samplePhoto;



    @SerializedName("Autograph")

    private String autograph;


    public String getAutograph() {
        return autograph;
    }

    public void setAutograph(String autograph) {
        this.autograph = autograph;
    }

    public String getSampleNumber() {
        return sampleNumber;
    }

    public void setSampleNumber(String sampleNumber) {
        this.sampleNumber = sampleNumber;
    }

    public String getSamplingTime() {
        return samplingTime;
    }

    public void setSamplingTime(String samplingTime) {
        this.samplingTime = samplingTime;
    }

    public String getSampleName() {
        return sampleName;
    }

    public void setSampleName(String sampleName) {
        this.sampleName = sampleName;
    }

    public String getSampleType() {
        return sampleType;
    }

    public void setSampleType(String sampleType) {
        this.sampleType = sampleType;
    }

    public String getOperatingHouseholdId() {
        return operatingHouseholdId;
    }

    public void setOperatingHouseholdId(String operatingHouseholdId) {
        this.operatingHouseholdId = operatingHouseholdId;
    }

    public String getSampleAccountId() {
        return sampleAccountId;
    }

    public void setSampleAccountId(String sampleAccountId) {
        this.sampleAccountId = sampleAccountId;
    }

    public String getSamplePhoto() {
        return samplePhoto;
    }

    public void setSamplePhoto(String samplePhoto) {
        this.samplePhoto = samplePhoto;
    }
}

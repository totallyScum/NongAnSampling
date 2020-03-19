package com.chen.nongansampling.bean.sample.insert;

import com.google.gson.annotations.SerializedName;

public class SamplingRequset {

    @SerializedName("AccountPkId")
    private String accountPkId;
    @SerializedName("SamplingInformation")
    private SamplingInformation samplingInformation;
    @SerializedName("DeTypeId")
    private String deTypeId;
    @SerializedName("DeMethoodPkID")
    private String deMethoodPkID;

    public String getAccountPkId() {
        return accountPkId;
    }

    public void setAccountPkId(String accountPkId) {
        this.accountPkId = accountPkId;
    }

    public SamplingInformation getSamplingInformation() {
        return samplingInformation;
    }

    public void setSamplingInformation(SamplingInformation samplingInformation) {
        this.samplingInformation = samplingInformation;
    }

    public String getDeTypeId() {
        return deTypeId;
    }

    public void setDeTypeId(String deTypeId) {
        this.deTypeId = deTypeId;
    }

    public String getDeMethoodPkID() {
        return deMethoodPkID;
    }

    public void setDeMethoodPkID(String deMethoodPkID) {
        this.deMethoodPkID = deMethoodPkID;
    }
}

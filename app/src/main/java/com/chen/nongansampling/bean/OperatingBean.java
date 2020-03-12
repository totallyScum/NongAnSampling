package com.chen.nongansampling.bean;

import com.google.gson.annotations.SerializedName;

public class OperatingBean {
    @SerializedName("PkId")
    String pkId;

    @SerializedName("MarketId")
    String marketId;

    @SerializedName("BoothNumber")
    String boothNumber;

    @SerializedName("OperatingHouseholds")
    String operatingHouseholds;

    @SerializedName("Phone")
    String phone;

    @SerializedName("Name")
    String name;

    @SerializedName("CreditScoring")
    String creditScoring;

    public String getPkId() {
        return pkId;
    }

    public void setPkId(String pkId) {
        this.pkId = pkId;
    }

    public String getMarketId() {
        return marketId;
    }

    public void setMarketId(String marketId) {
        this.marketId = marketId;
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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCreditScoring() {
        return creditScoring;
    }

    public void setCreditScoring(String creditScoring) {
        this.creditScoring = creditScoring;
    }
}

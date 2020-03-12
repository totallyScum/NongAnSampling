package com.chen.nongansampling.model;

import com.google.gson.annotations.SerializedName;

public class Market {
    @SerializedName("PkId")
    private String PkId;
    @SerializedName("DataIndex")
    private String DataIndex;
    @SerializedName("CreatedDateTime")
    private String CreatedDateTime;
    @SerializedName("Name")
    private String Name;
    @SerializedName("Type")
    private String Type;
    @SerializedName("Size")
    private String Size;
    @SerializedName("StallsNumber")
    private String StallsNumber;
    @SerializedName("Address")
    private String Address;

    public String getPkId() {
        return PkId;
    }

    public void setPkId(String pkId) {
        PkId = pkId;
    }

    public String getDataIndex() {
        return DataIndex;
    }

    public void setDataIndex(String dataIndex) {
        DataIndex = dataIndex;
    }

    public String getCreatedDateTime() {
        return CreatedDateTime;
    }

    public void setCreatedDateTime(String createdDateTime) {
        CreatedDateTime = createdDateTime;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getType() {
        return Type;
    }

    public void setType(String type) {
        Type = type;
    }

    public String getSize() {
        return Size;
    }

    public void setSize(String size) {
        Size = size;
    }

    public String getStallsNumber() {
        return StallsNumber;
    }

    public void setStallsNumber(String stallsNumber) {
        StallsNumber = stallsNumber;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }
}

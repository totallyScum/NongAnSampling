package com.chen.nongansampling.bean.sample;

import com.google.gson.annotations.SerializedName;

public class TypeListItem {

    @SerializedName("NameId")
    private String nameId;



    @SerializedName("Name")
    private String name;


    public String getNameId() {
        return nameId;
    }

    public void setNameId(String nameId) {
        this.nameId = nameId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

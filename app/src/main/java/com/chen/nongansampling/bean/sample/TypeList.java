package com.chen.nongansampling.bean.sample;

import androidx.annotation.NonNull;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class TypeList {
    @SerializedName("TypeId")

    private String typeId;

    @SerializedName("TypeName")

    private String TypeName;

    @SerializedName("list")

    private List<TypeListItem> list=new ArrayList<>();

    public String getTypeId() {
        return typeId;
    }

    public void setTypeId(String typeId) {
        this.typeId = typeId;
    }

    public String getTypeName() {
        return TypeName;
    }

    public void setTypeName(String typeName) {
        TypeName = typeName;
    }

    public List<TypeListItem> getList() {
        return list;
    }

    public void setList(List<TypeListItem> list) {
        this.list = list;
    }

}

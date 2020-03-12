package com.chen.nongansampling.bean;

import com.google.gson.annotations.SerializedName;

public class SimpleRequest {
    @SerializedName("AccountPkId")
    private String accountPkId;

    public String getAccountPkId() {
        return accountPkId;
    }

    public void setAccountPkId(String accountPkId) {
        this.accountPkId = accountPkId;
    }
}

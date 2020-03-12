package com.chen.nongansampling.model;

import com.google.gson.annotations.SerializedName;

public class Account {
    @SerializedName("LoginName")
    private String loginName;

    @SerializedName("Number")
    String number;

    @SerializedName("LoginPassword")
    String loginPassword;

    @SerializedName("RealName")
    String realName;

    @SerializedName("DepartmentName")
    String departmentName;

    @SerializedName("StepName")
    String stepName;

    @SerializedName("Role")
    String role;

    @SerializedName("PkId")
    String pkId;

    @SerializedName("DataIndex")
    String dataIndex;

    @SerializedName("CreatedDateTime")
    String createdDateTime;


    @SerializedName("CreatedBy")
    String createdBy;

    @SerializedName("ModifiedDateTime")
    String modifiedDateTime;

    @SerializedName("ModifiedBy")
    String modifiedBy;

    @SerializedName("IsDeleted")
    String isDeleted;


    @SerializedName("IsEnabled")
    String isEnabled;



    @SerializedName("Remark")
    String remark;


    public String getCreatedDateTime() {
        return createdDateTime;
    }

    public void setCreatedDateTime(String createdDateTime) {
        this.createdDateTime = createdDateTime;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public String getModifiedDateTime() {
        return modifiedDateTime;
    }

    public void setModifiedDateTime(String modifiedDateTime) {
        this.modifiedDateTime = modifiedDateTime;
    }

    public String getModifiedBy() {
        return modifiedBy;
    }

    public void setModifiedBy(String modifiedBy) {
        this.modifiedBy = modifiedBy;
    }

    public String getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(String isDeleted) {
        this.isDeleted = isDeleted;
    }

    public String getIsEnabled() {
        return isEnabled;
    }

    public void setIsEnabled(String isEnabled) {
        this.isEnabled = isEnabled;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getLoginPassword() {
        return loginPassword;
    }

    public void setLoginPassword(String loginPassword) {
        this.loginPassword = loginPassword;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public String getStepName() {
        return stepName;
    }

    public void setStepName(String stepName) {
        this.stepName = stepName;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getPkId() {
        return pkId;
    }

    public void setPkId(String pkId) {
        this.pkId = pkId;
    }

    public String getDataIndex() {
        return dataIndex;
    }

    public void setDataIndex(String dataIndex) {
        this.dataIndex = dataIndex;
    }
}

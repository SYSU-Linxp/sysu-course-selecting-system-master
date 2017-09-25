package com.sysu.course.entity;

import java.io.Serializable;

public class QueryDrvierDto implements Serializable {

    private static final long serialVersionUID = -7726421850126740662L;

    private String stationCode;
    private String code;
    private String name;
    private String gender;
    private String telephone;
    private String idCard;
    private String drivingLicence;
    private String drivingCarType;
    private String qualificationNo;
    private String companyCode;
    private String companyName;
    private String status;
    private String createdAt;
    private String updatedAt;
    private String remark;

    public String getStationCode() {
        return stationCode;
    }
    public void setStationCode(String stationCode) {
        this.stationCode = stationCode;
    }
    public String getCode() {
        return code;
    }
    public void setCode(String code) {
        this.code = code;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getGender() {
        return gender;
    }
    public void setGender(String gender) {
        this.gender = gender;
    }
    public String getTelephone() {
        return telephone;
    }
    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }
    public String getIdCard() {
        return idCard;
    }
    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }
    public String getDrivingLicence() {
        return drivingLicence;
    }
    public void setDrivingLicence(String drivingLicence) {
        this.drivingLicence = drivingLicence;
    }
    public String getDrivingCarType() {
        return drivingCarType;
    }
    public void setDrivingCarType(String drivingCarType) {
        this.drivingCarType = drivingCarType;
    }
    public String getQualificationNo() {
        return qualificationNo;
    }
    public void setQualificationNo(String qualificationNo) {
        this.qualificationNo = qualificationNo;
    }
    public String getCompanyCode() {
        return companyCode;
    }
    public void setCompanyCode(String companyCode) {
        this.companyCode = companyCode;
    }
    public String getCompanyName() {
        return companyName;
    }
    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }
    public String getCreatedAt() {
        return createdAt;
    }
    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }
    public String getUpdatedAt() {
        return updatedAt;
    }
    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }
    public String getRemark() {
        return remark;
    }
    public void setRemark(String remark) {
        this.remark = remark;
    }


}

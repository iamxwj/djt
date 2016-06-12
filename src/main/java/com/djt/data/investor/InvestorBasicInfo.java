/*
 * @(#)InvestorBasicInfoForm.java, 2015/11/27.
 *
 * Copyright 2015 Alibaodu, Inc. All rights reserved.
 * ALIBAODU PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package com.djt.data.investor;

import java.util.List;

/**
 * InvestorBasicInfo
 *
 * @author chenbin
 * @date 2015/11/27
 */
public class InvestorBasicInfo {
    private Long investorId;
    private String investorName;
    private String birthYear;
    private String nativeProvince; // 籍贯省
    private String nativeDistrict; // 籍贯市
    private Integer age;
    private String gender;
    private Double fundNumber;
    private String fundUnit;
    private String education;

    private String institutionName;
    private String investorPosition;

    private String investType;  // 投资类型
    private List<String> investPhaseList;
    private String mainPhase; // 主要投资阶段
    private List<String> tag;  // 阿里系，北大系投资
    private List<String> firstFieldList;
    private String secondField;
    private String mobilePortraitUrl; // 移动端头像
    private List<String> webPortraitUrl; // web端头像

    private String province;
    private String city;
    private String address;

    public Long getInvestorId() {
        return investorId;
    }

    public void setInvestorId(Long investorId) {
        this.investorId = investorId;
    }

    public String getInvestorName() {
        return investorName;
    }

    public void setInvestorName(String investorName) {
        this.investorName = investorName;
    }

    public String getBirthYear() {
        return birthYear;
    }

    public void setBirthYear(String birthYear) {
        this.birthYear = birthYear;
    }

    public String getNativeProvince() {
        return nativeProvince;
    }

    public void setNativeProvince(String nativeProvince) {
        this.nativeProvince = nativeProvince;
    }

    public String getNativeDistrict() {
        return nativeDistrict;
    }

    public void setNativeDistrict(String nativeDistrict) {
        this.nativeDistrict = nativeDistrict;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Double getFundNumber() {
        return fundNumber;
    }

    public void setFundNumber(Double fundNumber) {
        this.fundNumber = fundNumber;
    }

    public String getFundUnit() {
        return fundUnit;
    }

    public void setFundUnit(String fundUnit) {
        this.fundUnit = fundUnit;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public String getInstitutionName() {
        return institutionName;
    }

    public void setInstitutionName(String institutionName) {
        this.institutionName = institutionName;
    }

    public String getInvestorPosition() {
        return investorPosition;
    }

    public void setInvestorPosition(String investorPosition) {
        this.investorPosition = investorPosition;
    }


    public String getInvestType() {
        return investType;
    }

    public void setInvestType(String investType) {
        this.investType = investType;
    }

    public String getMainPhase() {
        return mainPhase;
    }

    public void setMainPhase(String mainPhase) {
        this.mainPhase = mainPhase;
    }

    public List<String> getTag() {
        return tag;
    }

    public void setTag(List<String >tag) {
        this.tag = tag;
    }



    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getMobilePortraitUrl() {
        return mobilePortraitUrl;
    }

    public void setMobilePortraitUrl(String mobilePortraitUrl) {
        this.mobilePortraitUrl = mobilePortraitUrl;
    }

    public List<String> getWebPortraitUrl() {
        return webPortraitUrl;
    }

    public void setWebPortraitUrl(List<String> webPortraitUrl) {
        this.webPortraitUrl = webPortraitUrl;
    }

    public List<String> getInvestPhaseList() {
        return investPhaseList;
    }

    public void setInvestPhaseList(List<String> investPhaseList) {
        this.investPhaseList = investPhaseList;
    }

    public List<String> getFirstFieldList() {
        return firstFieldList;
    }

    public void setFirstFieldList(List<String> firstFieldList) {
        this.firstFieldList = firstFieldList;
    }

    public String getSecondField() {
        return secondField;
    }

    public void setSecondField(String secondField) {
        this.secondField = secondField;
    }

    @Override
    public String toString() {
        return "InvestorBasicInfo{" +
                "investorId=" + investorId +
                ", investorName='" + investorName + '\'' +
                ", birthYear='" + birthYear + '\'' +
                ", nativeProvince='" + nativeProvince + '\'' +
                ", nativeDistrict='" + nativeDistrict + '\'' +
                ", age=" + age +
                ", gender='" + gender + '\'' +
                ", fundNumber=" + fundNumber +
                ", fundUnit='" + fundUnit + '\'' +
                ", education='" + education + '\'' +
                ", institutionName='" + institutionName + '\'' +
                ", investorPosition='" + investorPosition + '\'' +
                ", investType='" + investType + '\'' +
                ", investPhaseList=" + investPhaseList +
                ", mainPhase='" + mainPhase + '\'' +
                ", tag='" + tag + '\'' +
                ", firstFieldList=" + firstFieldList +
                ", secondField='" + secondField + '\'' +
                ", mobilePortraitUrl='" + mobilePortraitUrl + '\'' +
                ", webPortraitUrl=" + webPortraitUrl +
                ", province='" + province + '\'' +
                ", city='" + city + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}

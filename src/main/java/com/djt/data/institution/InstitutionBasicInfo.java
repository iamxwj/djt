/*
 * @(#)InstitutionBasicInfoForm.java, 2015/11/28.
 *
 * Copyright 2015 Alibaodu, Inc. All rights reserved.
 * ALIBAODU PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package com.djt.data.institution;

import com.djt.data.ValidResult;

import java.util.List;

/**
 * InstitutionBasicInfo
 *
 * @author chenbin
 * @date 2015/11/28
 */
public class InstitutionBasicInfo {
    private Long institutionId;
    private String institutionName;
    private String foundYear;
    private Double fundNumber;
    private String fundUnit;
    private String staffSize;

    private String investType;
    private List<String> investPhase;
    private String mainPhase;
    private List<String >tag;

    private List<String> firstFields;
    private String secondFields;

    private String province;
    private String city;
    private String address;
    private List<String >locateProvinces;

    private String achievement;
    private String intro;
    private String webLogo;
    private String mobileLogo;

    public ValidResult validateAllFields() {
        if(institutionName == null || institutionName.length() == 0)
            return new ValidResult(false, "institutionName == "+institutionName);
        if(foundYear == null || foundYear.length() == 0)
            return new ValidResult(false, "foundYear == " + foundYear);
        if(fundNumber == 0)
            return new ValidResult(false, "fundNumber == " + fundNumber);
        if(fundUnit == null || fundUnit.length() == 0)
            return new ValidResult(false, "fundUnit == " + fundUnit);
        if(staffSize == null || staffSize.length() == 0 || staffSize.equalsIgnoreCase("0"))
            return new ValidResult(false, "staffSize == " + staffSize);
        if(province == null || province.length() == 0)
            return new ValidResult(false, "province == " + province);
        if(city == null || city.length() == 0)
            return new ValidResult(false, "city == " + city);
        if(address == null || address.length() == 0)
            return new ValidResult(false, "address == " + address);
        if(locateProvinces == null || locateProvinces.size() == 0)
            return new ValidResult(false, "locateProvinces == " + locateProvinces);
//        if(achievement == null || achievement.length() == 0)
//            return new ValidResult(false, "achievement == " + achievement);
        if(intro == null || intro.length() == 0)
            return new ValidResult(false, "intro == " + intro);
//        if(webLogo == null || webLogo.length() == 0)
//            return new ValidResult(false, "webLogo == " + webLogo);
//        if(mobileLogo == null || mobileLogo.length() == 0)
//            return new ValidResult(false, "mobileLogo == " + mobileLogo);
        return new ValidResult(true, "all fields valid");
    }


    public Long getInstitutionId() {
        return institutionId;
    }

    public void setInstitutionId(Long institutionId) {
        this.institutionId = institutionId;
    }

    public String getInstitutionName() {
        return institutionName;
    }

    public void setInstitutionName(String institutionName) {
        this.institutionName = institutionName;
    }

    public String getFoundYear() {
        return foundYear;
    }

    public void setFoundYear(String foundYear) {
        this.foundYear = foundYear;
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

    public String getInvestType() {
        return investType;
    }

    public void setInvestType(String investType) {
        this.investType = investType;
    }

    public List<String> getInvestPhase() {
        return investPhase;
    }

    public void setInvestPhase(List<String> investPhase) {
        this.investPhase = investPhase;
    }

    public String getMainPhase() {
        return mainPhase;
    }

    public void setMainPhase(String mainPhase) {
        this.mainPhase = mainPhase;
    }

    public List<String >getTag() {
        return tag;
    }

    public void setTag(List<String >tag) {
        this.tag = tag;
    }

    public List<String> getFirstFields() {
        return firstFields;
    }

    public void setFirstFields(List<String> firstFields) {
        this.firstFields = firstFields;
    }

    public String getSecondFields() {
        return secondFields;
    }

    public void setSecondFields(String secondFields) {
        this.secondFields = secondFields;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getStaffSize() {
        return staffSize;
    }

    public void setStaffSize(String staffSize) {
        this.staffSize = staffSize;
    }

    public List<String >getLocateProvinces() {
        return locateProvinces;
    }

    public void setLocateProvinces(List<String >locateProvinces) {
        this.locateProvinces = locateProvinces;
    }

    public String getAchievement() {
        return achievement;
    }

    public void setAchievement(String achievement) {
        this.achievement = achievement;
    }

    public String getIntro() {
        return intro;
    }

    public void setIntro(String intro) {
        this.intro = intro;
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

    public String getWebLogo() {
        return webLogo;
    }

    public void setWebLogo(String webLogo) {
        this.webLogo = webLogo;
    }

    public String getMobileLogo() {
        return mobileLogo;
    }

    public void setMobileLogo(String mobileLogo) {
        this.mobileLogo = mobileLogo;
    }

    @Override
    public String toString() {
        return "InstitutionBasicInfo{" +
                "institutionId=" + institutionId +
                ", institutionName='" + institutionName + '\'' +
                ", foundYear='" + foundYear + '\'' +
                ", fundNumber=" + fundNumber +
                ", fundUnit='" + fundUnit + '\'' +
                ", staffSize='" + staffSize + '\'' +
                ", investType='" + investType + '\'' +
                ", investPhase=" + investPhase +
                ", mainPhase=" + mainPhase +
                ", tag='" + tag + '\'' +
                ", firstFields=" + firstFields +
                ", secondFields=" + secondFields +
                ", province='" + province + '\'' +
                ", city='" + city + '\'' +
                ", address='" + address + '\'' +
                ", locateProvinces='" + locateProvinces + '\'' +
                ", achievement='" + achievement + '\'' +
                ", intro='" + intro + '\'' +
                ", webLogo='" + webLogo + '\'' +
                ", mobileLogo='" + mobileLogo + '\'' +
                '}';
    }
}

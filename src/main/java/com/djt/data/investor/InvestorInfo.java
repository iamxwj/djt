/*
 * @(#)InvestorInfo.java, 2015/11/16.
 *
 * Copyright 2015 Alibaodu, Inc. All rights reserved.
 * ALIBAODU PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package com.djt.data.investor;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;

/**
 * InvestorInfo
 *
 * @author chenbin
 * @date 2015/11/16
 */
public class InvestorInfo implements Serializable {
    private Long investorId;
    private String investorName;
    private int investorLevel;
    private String birthYear;
    private String nativeProvince;  //籍贯
    private String nativeDistrict;
    private Integer age;
    private String gender;

    private String investType;
    private List<String> investPhaseList;
    private String mainPhase;
    private List<String> tag;

    private List<String> firstFieldList;
    private String secondField;

    private String achievement;
    private String investorIntro;
    private String education;
    private String eduExp;
    private String workExp;
    private String philosophy;
    private Double fundNumber;
    private String fundUnit;
    private String others;

    private String institutionName;
    private String investorPosition;  // 投资人职位

    private byte successIndicator;
    private byte activeIndicator;
    private byte brandIndicator;
    private byte rateIndicator;

    private int overallRank;
    private int annualRank;
    private int activeRank;

    private long fansNumber;
    private int talkNumber;
    private int investNumber;

    private String province;
    private String city;
    private String address;

    private byte authenticated;

    private String mobilePortraitUrl;
    private List<String> webPortraitUrlList;
    private List<String> investorPhotoUrlList;

    private Timestamp createTime;
    private Timestamp lastUpdate;

    private Long userId;

    public InvestorInfo(Long investorId, String investorName, String investType, String mainPhase, List<String> tag, String investorPosition, int investorLevel,
                        String birthYear, String nativeProvince, String nativeDistrict, String education, Integer age,
                        String gender, String institutionName, Double fundNumber, String fundUnit,
                        byte successIndicator, byte activeIndicator, byte brandIndicator,
                        byte rateIndicator, int overallRank, int annualRank, int activeRank, long fansNumber,
                        int talkNumber, int investNumber, String province, String city, String address,
                        String achievement, String investorIntro, byte authenticated,
                        List<String> investPhaseList, List<String> firstFieldList, String secondField, String philosophy,
                        String eduExp, String workExp, String others, String mobilePortraitUrl, List<String> webPortraitUrlList,
                        List<String> investorPhotoUrlList, Timestamp createTime, Timestamp lastUpdate,Long userId) {
        this.investorId = investorId;
        this.investorName = investorName;
        this.investType = investType;
        this.mainPhase = mainPhase;
        this.tag = tag;
        this.investorPosition = investorPosition;
        this.investorLevel = investorLevel;
        this.birthYear = birthYear;
        this.nativeProvince = nativeProvince;
        this.nativeDistrict = nativeDistrict;
        this.education = education;
        this.age = age;
        this.gender = gender;

        this.institutionName = institutionName;
        this.fundNumber = fundNumber;
        this.fundUnit = fundUnit;

        this.successIndicator = successIndicator;
        this.activeIndicator = activeIndicator;
        this.brandIndicator = brandIndicator;
        this.rateIndicator = rateIndicator;

        this.overallRank = overallRank;
        this.annualRank = annualRank;
        this.activeRank = activeRank;

        this.fansNumber = fansNumber;
        this.talkNumber = talkNumber;
        this.investNumber = investNumber;
        this.province = province;
        this.city = city;
        this.address = address;
        this.achievement = achievement;
        this.philosophy = philosophy;

        this.investorIntro = investorIntro;
        this.authenticated = authenticated;
        this.investorPhotoUrlList = investorPhotoUrlList;
        this.investPhaseList = investPhaseList;
        this.firstFieldList = firstFieldList;
        this.secondField = secondField;

        this.eduExp = eduExp;
        this.workExp = workExp;
        this.others = others;

        this.mobilePortraitUrl = mobilePortraitUrl;
        this.webPortraitUrlList = webPortraitUrlList;
        this.investorPhotoUrlList = investorPhotoUrlList;

        this.createTime = createTime;
        this.lastUpdate = lastUpdate;
        this.userId = userId;
    }

    public InvestorInfo(Long investorId, String investorName, String investType, String mainPhase, List<String> tag, String investorPosition, int investorLevel,
                        String birthYear, String nativeProvince, String nativeDistrict, String education, Integer age,
                        String gender, String institutionName, Double fundNumber, String fundUnit,
                        byte successIndicator, byte activeIndicator, byte brandIndicator,
                        byte rateIndicator, int overallRank, int annualRank, int activeRank, long fansNumber,
                        int talkNumber, int investNumber, String province, String city, String address,
                        String achievement, String investorIntro, byte authenticated,
                        List<String> investPhaseList, List<String> firstFieldList, String secondField, String philosophy,
                        String eduExp, String workExp, String others, String mobilePortraitUrl, List<String> webPortraitUrlList,
                        List<String> investorPhotoUrlList, Timestamp createTime, Timestamp lastUpdate) {
        this.investorId = investorId;
        this.investorName = investorName;
        this.investType = investType;
        this.mainPhase = mainPhase;
        this.tag = tag;
        this.investorPosition = investorPosition;
        this.investorLevel = investorLevel;
        this.birthYear = birthYear;
        this.nativeProvince = nativeProvince;
        this.nativeDistrict = nativeDistrict;
        this.education = education;
        this.age = age;
        this.gender = gender;

        this.institutionName = institutionName;
        this.fundNumber = fundNumber;
        this.fundUnit = fundUnit;

        this.successIndicator = successIndicator;
        this.activeIndicator = activeIndicator;
        this.brandIndicator = brandIndicator;
        this.rateIndicator = rateIndicator;

        this.overallRank = overallRank;
        this.annualRank = annualRank;
        this.activeRank = activeRank;

        this.fansNumber = fansNumber;
        this.talkNumber = talkNumber;
        this.investNumber = investNumber;
        this.province = province;
        this.city = city;
        this.address = address;
        this.achievement = achievement;
        this.philosophy = philosophy;

        this.investorIntro = investorIntro;
        this.authenticated = authenticated;
        this.investorPhotoUrlList = investorPhotoUrlList;
        this.investPhaseList = investPhaseList;
        this.firstFieldList = firstFieldList;
        this.secondField = secondField;

        this.eduExp = eduExp;
        this.workExp = workExp;
        this.others = others;

        this.mobilePortraitUrl = mobilePortraitUrl;
        this.webPortraitUrlList = webPortraitUrlList;
        this.investorPhotoUrlList = investorPhotoUrlList;

        this.createTime = createTime;
        this.lastUpdate = lastUpdate;
    }


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

    public List<String>getTag() {
        return tag;
    }

    public void setTag(List<String> tag) {
        this.tag = tag;
    }

    public String getInvestorPosition() {
        return investorPosition;
    }

    public void setInvestorPosition(String investorPosition) {
        this.investorPosition = investorPosition;
    }

    public int getInvestorLevel() {
        return investorLevel;
    }

    public void setInvestorLevel(int investorLevel) {
        this.investorLevel = investorLevel;
    }

    public String getBirthYear() {
        return birthYear;
    }

    public void setBirthYear(String birthYear) {
        this.birthYear = birthYear;
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

    public byte getSuccessIndicator() {
        return successIndicator;
    }

    public void setSuccessIndicator(byte successIndicator) {
        this.successIndicator = successIndicator;
    }

    public byte getActiveIndicator() {
        return activeIndicator;
    }

    public void setActiveIndicator(byte activeIndicator) {
        this.activeIndicator = activeIndicator;
    }

    public byte getBrandIndicator() {
        return brandIndicator;
    }

    public void setBrandIndicator(byte brandIndicator) {
        this.brandIndicator = brandIndicator;
    }

    public byte getRateIndicator() {
        return rateIndicator;
    }

    public void setRateIndicator(byte rateIndicator) {
        this.rateIndicator = rateIndicator;
    }

    public int getOverallRank() {
        return overallRank;
    }

    public void setOverallRank(int overallRank) {
        this.overallRank = overallRank;
    }

    public int getAnnualRank() {
        return annualRank;
    }

    public void setAnnualRank(int annualRank) {
        this.annualRank = annualRank;
    }

    public int getActiveRank() {
        return activeRank;
    }

    public void setActiveRank(int activeRank) {
        this.activeRank = activeRank;
    }

    public long getFansNumber() {
        return fansNumber;
    }

    public void setFansNumber(long fansNumber) {
        this.fansNumber = fansNumber;
    }

    public int getTalkNumber() {
        return talkNumber;
    }

    public void setTalkNumber(int talkNumber) {
        this.talkNumber = talkNumber;
    }

    public int getInvestNumber() {
        return investNumber;
    }

    public void setInvestNumber(int investNumber) {
        this.investNumber = investNumber;
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

    public String getAchievement() {
        return achievement;
    }

    public void setAchievement(String achievement) {
        this.achievement = achievement;
    }

    public String getInvestorIntro() {
        return investorIntro;
    }

    public void setInvestorIntro(String investorIntro) {
        this.investorIntro = investorIntro;
    }

    public byte getAuthenticated() {
        return authenticated;
    }

    public void setAuthenticated(byte authenticated) {
        this.authenticated = authenticated;
    }

    public List<String> getInvestorPhotoUrlList() {
        return investorPhotoUrlList;
    }

    public void setInvestorPhotoUrlList(List<String> investorPhotoUrlList) {
        this.investorPhotoUrlList = investorPhotoUrlList;
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

    public String getPhilosophy() {
        return philosophy;
    }

    public void setPhilosophy(String philosophy) {
        this.philosophy = philosophy;
    }

    public String getEduExp() {
        return eduExp;
    }

    public void setEduExp(String eduExp) {
        this.eduExp = eduExp;
    }

    public String getWorkExp() {
        return workExp;
    }

    public void setWorkExp(String workExp) {
        this.workExp = workExp;
    }

    public String getOthers() {
        return others;
    }

    public void setOthers(String others) {
        this.others = others;
    }

    public String getMobilePortraitUrl() {
        return mobilePortraitUrl;
    }

    public void setMobilePortraitUrl(String mobilePortraitUrl) {
        this.mobilePortraitUrl = mobilePortraitUrl;
    }

    public List<String> getWebPortraitUrlList() {
        return webPortraitUrlList;
    }

    public void setWebPortraitUrlList(List<String> webPortraitUrlList) {
        this.webPortraitUrlList = webPortraitUrlList;
    }

    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }

    public Timestamp getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(Timestamp lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "InvestorInfo{" +
                "investorId=" + investorId +
                ", investorName='" + investorName + '\'' +
                ", investorLevel=" + investorLevel +
                ", birthYear='" + birthYear + '\'' +
                ", nativeProvince='" + nativeProvince + '\'' +
                ", nativeDistrict='" + nativeDistrict + '\'' +
                ", age=" + age +
                ", gender='" + gender + '\'' +
                ", investType='" + investType + '\'' +
                ", investPhaseList=" + investPhaseList +
                ", mainPhase='" + mainPhase + '\'' +
                ", tag=" + tag +
                ", firstFieldList=" + firstFieldList +
                ", secondField='" + secondField + '\'' +
                ", achievement='" + achievement + '\'' +
                ", investorIntro='" + investorIntro + '\'' +
                ", education='" + education + '\'' +
                ", eduExp='" + eduExp + '\'' +
                ", workExp='" + workExp + '\'' +
                ", philosophy='" + philosophy + '\'' +
                ", fundNumber=" + fundNumber +
                ", fundUnit='" + fundUnit + '\'' +
                ", others='" + others + '\'' +
                ", institutionName='" + institutionName + '\'' +
                ", investorPosition='" + investorPosition + '\'' +
                ", successIndicator=" + successIndicator +
                ", activeIndicator=" + activeIndicator +
                ", brandIndicator=" + brandIndicator +
                ", rateIndicator=" + rateIndicator +
                ", overallRank=" + overallRank +
                ", annualRank=" + annualRank +
                ", activeRank=" + activeRank +
                ", fansNumber=" + fansNumber +
                ", talkNumber=" + talkNumber +
                ", investNumber=" + investNumber +
                ", province='" + province + '\'' +
                ", city='" + city + '\'' +
                ", address='" + address + '\'' +
                ", authenticated=" + authenticated +
                ", mobilePortraitUrl='" + mobilePortraitUrl + '\'' +
                ", webPortraitUrlList=" + webPortraitUrlList +
                ", investorPhotoUrlList=" + investorPhotoUrlList +
                ", createTime=" + createTime +
                ", lastUpdate=" + lastUpdate +
                ", userId=" + userId +
                '}';
    }
}

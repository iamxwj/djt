/*
 * @(#)InstitutionInfo.java, 2015/11/16.
 *
 * Copyright 2015 Alibaodu, Inc. All rights reserved.
 * ALIBAODU PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package com.djt.data.institution;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;

/**
 * InstitutionInfo
 *
 * @author chenbin
 * @date 2015/11/16
 */
public class InstitutionInfo implements Serializable {
    private Long institutionId;
    private String institutionName;
    private String institutionIntro;
    private String achievement;
    private int institutionLevel;
    private String foundYear;
    private Double fundNumber;
    private String fundUnit;
    private String staffSize;

    private String investType;
    private List<String> investPhase;
    private String mainPhase;
    private List<String> tag;

    private List<String> firstFields;
    private String secondFields;

    private byte investSuccessIndicator;
    private byte investActiveIndicator;
    private byte brandIndicator;
    private byte investRateIndicator;
    private int overallRank;
    private int annualRank;
    private int activeRank;
    private long fansNumber;
    private int talkNumber;
    private int investNumber;

    private String province;
    private List<String> locateProvices;
    private String city;
    private String address;

    private byte authenticated;

    private String webLogo;
    private String mobileLogo;
    private String institutionPhoto;


    private Timestamp createTime;
    private Timestamp updateTime;


    public InstitutionInfo() {
    }

    public InstitutionInfo(Long institutionId, String institutionName, String institutionIntro, String achievement,
                           int institutionLevel, String foundYear, Double fundNumber, String fundUnit, String staffSize,
                           String investType, List<String> investPhase, String mainPhase, List<String> tag, List<String> firstFields,
                           String secondFields, byte investSuccessIndicator, byte investActiveIndicator,
                           byte brandIndicator, byte investRateIndicator, int overallRank, int annualRank, int activeRank,
                           long fansNumber, int talkNumber, int investNumber, String province, List<String> locateProvices,
                           String city, String address, byte authenticated, String webLogo, String mobileLogo,
                           String institutionPhoto, Timestamp createTime, Timestamp updateTime) {
        this.institutionId = institutionId;
        this.institutionName = institutionName;
        this.institutionIntro = institutionIntro;
        this.achievement = achievement;
        this.institutionLevel = institutionLevel;
        this.foundYear = foundYear;
        this.fundNumber = fundNumber;
        this.fundUnit = fundUnit;
        this.staffSize = staffSize;
        this.investType = investType;
        this.investPhase = investPhase;
        this.mainPhase = mainPhase;
        this.tag = tag;
        this.firstFields = firstFields;
        this.secondFields = secondFields;
        this.investSuccessIndicator = investSuccessIndicator;
        this.investActiveIndicator = investActiveIndicator;
        this.brandIndicator = brandIndicator;
        this.investRateIndicator = investRateIndicator;
        this.overallRank = overallRank;
        this.annualRank = annualRank;
        this.activeRank = activeRank;
        this.fansNumber = fansNumber;
        this.talkNumber = talkNumber;
        this.investNumber = investNumber;
        this.province = province;
        this.locateProvices = locateProvices;
        this.city = city;
        this.address = address;
        this.authenticated = authenticated;
        this.webLogo = webLogo;
        this.mobileLogo = mobileLogo;
        this.institutionPhoto = institutionPhoto;
        this.createTime = createTime;
        this.updateTime = updateTime;
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

    public String getInstitutionIntro() {
        return institutionIntro;
    }

    public void setInstitutionIntro(String institutionIntro) {
        this.institutionIntro = institutionIntro;
    }

    public String getAchievement() {
        return achievement;
    }

    public void setAchievement(String achievement) {
        this.achievement = achievement;
    }

    public int getInstitutionLevel() {
        return institutionLevel;
    }

    public void setInstitutionLevel(int institutionLevel) {
        this.institutionLevel = institutionLevel;
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

    public List<String> getTag() {
        return tag;
    }

    public void setTag(List<String> tag) {
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

    public byte getInvestSuccessIndicator() {
        return investSuccessIndicator;
    }

    public void setInvestSuccessIndicator(byte investSuccessIndicator) {
        this.investSuccessIndicator = investSuccessIndicator;
    }

    public byte getInvestActiveIndicator() {
        return investActiveIndicator;
    }

    public void setInvestActiveIndicator(byte investActiveIndicator) {
        this.investActiveIndicator = investActiveIndicator;
    }

    public byte getBrandIndicator() {
        return brandIndicator;
    }

    public void setBrandIndicator(byte brandIndicator) {
        this.brandIndicator = brandIndicator;
    }

    public byte getInvestRateIndicator() {
        return investRateIndicator;
    }

    public void setInvestRateIndicator(byte investRateIndicator) {
        this.investRateIndicator = investRateIndicator;
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

    public List<String> getLocateProvices() {
        return locateProvices;
    }

    public void setLocateProvices(List<String> locateProvices) {
        this.locateProvices = locateProvices;
    }

    public byte getAuthenticated() {
        return authenticated;
    }

    public void setAuthenticated(byte authenticated) {
        this.authenticated = authenticated;
    }

    public String getStaffSize() {
        return staffSize;
    }

    public void setStaffSize(String staffSize) {
        this.staffSize = staffSize;
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

    public String getInstitutionPhoto() {
        return institutionPhoto;
    }

    public void setInstitutionPhoto(String institutionPhoto) {
        this.institutionPhoto = institutionPhoto;
    }

    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }

    public Timestamp getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Timestamp updateTime) {
        this.updateTime = updateTime;
    }

    public InstitutionInfo(Long institutionId, String institutionName, String institutionIntro, String achievement,
                           int institutionLevel, String foundYear, Double fundNumber, String fundUnit, String staffSize,
                           String investType, List<String> investPhase, String mainPhase, List<String> tag,
                           List<String> firstFields, String secondFields, byte investSuccessIndicator,
                           byte investActiveIndicator, byte brandIndicator, byte investRateIndicator, int overallRank,
                           int annualRank, int activeRank, long fansNumber, int talkNumber, int investNumber,
                           String province, List<String> locateProvices, String city, String address, byte authenticated,
                           String webLogo, String mobileLogo, String institutionPhoto, List<InstitutionCase> investCaseList,
                           List<InstitutionMember> institutionMemberList, Timestamp createTime, Timestamp updateTime) {
        this.institutionId = institutionId;
        this.institutionName = institutionName;
        this.institutionIntro = institutionIntro;
        this.achievement = achievement;
        this.institutionLevel = institutionLevel;
        this.foundYear = foundYear;
        this.fundNumber = fundNumber;
        this.fundUnit = fundUnit;
        this.staffSize = staffSize;
        this.investType = investType;
        this.investPhase = investPhase;
        this.mainPhase = mainPhase;
        this.tag = tag;
        this.firstFields = firstFields;
        this.secondFields = secondFields;
        this.investSuccessIndicator = investSuccessIndicator;
        this.investActiveIndicator = investActiveIndicator;
        this.brandIndicator = brandIndicator;
        this.investRateIndicator = investRateIndicator;
        this.overallRank = overallRank;
        this.annualRank = annualRank;
        this.activeRank = activeRank;
        this.fansNumber = fansNumber;
        this.talkNumber = talkNumber;
        this.investNumber = investNumber;
        this.province = province;
        this.locateProvices = locateProvices;
        this.city = city;
        this.address = address;
        this.authenticated = authenticated;
        this.webLogo = webLogo;
        this.mobileLogo = mobileLogo;
        this.institutionPhoto = institutionPhoto;
        this.createTime = createTime;
        this.updateTime = updateTime;
    }

}

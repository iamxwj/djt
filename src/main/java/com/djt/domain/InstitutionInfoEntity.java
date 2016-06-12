/*
 * @(#)InstitutionInfoEntity.java, 2015/12/2.
 *
 * Copyright 2015 Alibaodu, Inc. All rights reserved.
 * ALIBAODU PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package com.djt.domain;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;

/**
 * InstitutionInfoEntity
 *
 * @author chenbin
 * @date 2015/12/2
 */
@Entity
@Table(name = "institution_info", schema = "", catalog = "djt")
public class InstitutionInfoEntity {
    private Long institutionId;

    @Id
    @Column(name = "institution_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getInstitutionId() {
        return institutionId;
    }

    public void setInstitutionId(Long institutionId) {
        this.institutionId = institutionId;
    }

    public InstitutionInfoEntity() {
        institutionName = "";
        institutionLevel = 0;
        foundYear = "";
        fundNumber = 0.0;
        fundUnit = "";
        staffSize = "";

        investType = "";
        investPhase = "";
        mainPhase = "";
        tag = "";

        firstFields = "";
        secondFields = "";

        webLogo = "";
        mobileLogo = "";
        institutionPhoto = "";

        investSuccessIndicator = 0;
        investActiveIndicator = 0;
        brandIndicator = 0;
        investRateIndicator = 0;

        province = "";
        city = "";
        locateProvinces = "";
        address = "";

        overallRank = 0;
        annualRank = 0;
        activeRank = 0;
        fansNumber = 0;
        talkNumber = 0;
        investNumber = 0;

        achievement = "";
        institutionIntro = "";
        authenticated = 0;
    }


    private String institutionName;

    @Basic
    @Column(name = "institution_name")
    public String getInstitutionName() {
        return institutionName;
    }

    public void setInstitutionName(String institutionName) {
        this.institutionName = institutionName;
    }

    private Byte institutionLevel;

    @Basic
    @Column(name = "institution_level")
    public Byte getInstitutionLevel() {
        return institutionLevel;
    }

    public void setInstitutionLevel(Byte institutionLevel) {
        this.institutionLevel = institutionLevel;
    }

    private String foundYear;

    @Basic
    @Column(name = "found_year")
    public String getFoundYear() {
        return foundYear;
    }

    public void setFoundYear(String foundYear) {
        this.foundYear = foundYear;
    }

    private Double fundNumber;

    @Basic
    @Column(name = "fund_number")
    public Double getFundNumber() {
        return fundNumber;
    }

    public void setFundNumber(Double fundNumber) {
        this.fundNumber = fundNumber;
    }

    private String fundUnit;

    @Basic
    @Column(name = "fund_unit")
    public String getFundUnit() {
        return fundUnit;
    }

    public void setFundUnit(String fundUnit) {
        this.fundUnit = fundUnit;
    }

    private String staffSize;

    @Basic
    @Column(name = "staff_size")
    public String getStaffSize() {
        return staffSize;
    }

    public void setStaffSize(String staffSize) {
        this.staffSize = staffSize;
    }

    private String investType;
    private String investPhase;
    private String mainPhase;
    private String tag;

    @Column(name = "invest_type")
    public String getInvestType() {
        return investType;
    }

    public void setInvestType(String investType) {
        this.investType = investType;
    }

    @Column(name = "invest_phase")
    public String getInvestPhase() {
        return investPhase;
    }

    public void setInvestPhase(String investPhase) {
        this.investPhase = investPhase;
    }

    @Column(name = "main_phase")
    public String getMainPhase() {
        return mainPhase;
    }

    public void setMainPhase(String mainPhase) {
        this.mainPhase = mainPhase;
    }

    @Column(name = "tag")
    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }


    private String firstFields;
    private String secondFields;

    @Column(name = "first_fields")
    public String getFirstFields() {
        return firstFields;
    }

    public void setFirstFields(String firstFields) {
        this.firstFields = firstFields;
    }

    @Column(name = "second_fields")
    public String getSecondFields() {
        return secondFields;
    }

    public void setSecondFields(String secondFields) {
        this.secondFields = secondFields;
    }

    private String webLogo;
    private String mobileLogo;
    private String institutionPhoto;

    @Column(name = "web_logo")
    public String getWebLogo() {
        return webLogo;
    }

    public void setWebLogo(String webLogo) {
        this.webLogo = webLogo;
    }

    @Column(name = "mobile_logo")
    public String getMobileLogo() {
        return mobileLogo;
    }

    public void setMobileLogo(String mobileLogo) {
        this.mobileLogo = mobileLogo;
    }

    @Column(name = "institution_photo")
    public String getInstitutionPhoto() {
        return institutionPhoto;
    }

    public void setInstitutionPhoto(String institutionPhoto) {
        this.institutionPhoto = institutionPhoto;
    }

    private Byte investSuccessIndicator;

    @Basic
    @Column(name = "invest_success_indicator")
    public Byte getInvestSuccessIndicator() {
        return investSuccessIndicator;
    }

    public void setInvestSuccessIndicator(Byte investSuccessIndicator) {
        this.investSuccessIndicator = investSuccessIndicator;
    }

    private Byte investActiveIndicator;

    @Basic
    @Column(name = "invest_active_indicator")
    public Byte getInvestActiveIndicator() {
        return investActiveIndicator;
    }

    public void setInvestActiveIndicator(Byte investActiveIndicator) {
        this.investActiveIndicator = investActiveIndicator;
    }

    private Byte brandIndicator;

    @Basic
    @Column(name = "brand_indicator")
    public Byte getBrandIndicator() {
        return brandIndicator;
    }

    public void setBrandIndicator(Byte brandIndicator) {
        this.brandIndicator = brandIndicator;
    }

    private Byte investRateIndicator;

    @Basic
    @Column(name = "invest_rate_indicator")
    public Byte getInvestRateIndicator() {
        return investRateIndicator;
    }

    public void setInvestRateIndicator(Byte investRateIndicator) {
        this.investRateIndicator = investRateIndicator;
    }

    // 机构所在省份
    private String province;

    @Basic
    @Column(name = "province")
    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    private String city;

    @Column(name = "city")
    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    private String locateProvinces;

    @Basic
    @Column(name = "locate_provinces")
    public String getLocateProvinces() {
        return locateProvinces;
    }

    public void setLocateProvinces(String locateProvinces) {
        this.locateProvinces = locateProvinces;
    }

    private String address;

    @Basic
    @Column(name = "address")
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    private Integer overallRank;

    @Basic
    @Column(name = "overall_rank")
    public Integer getOverallRank() {
        return overallRank;
    }

    public void setOverallRank(Integer overallRank) {
        this.overallRank = overallRank;
    }

    private Integer annualRank;

    @Basic
    @Column(name = "annual_rank")
    public Integer getAnnualRank() {
        return annualRank;
    }

    public void setAnnualRank(Integer annualRank) {
        this.annualRank = annualRank;
    }

    private Integer activeRank;

    @Basic
    @Column(name = "active_rank")
    public Integer getActiveRank() {
        return activeRank;
    }

    public void setActiveRank(Integer activeRank) {
        this.activeRank = activeRank;
    }

    private Integer fansNumber;

    @Basic
    @Column(name = "fans_number")
    public Integer getFansNumber() {
        return fansNumber;
    }

    public void setFansNumber(Integer fansNumber) {
        this.fansNumber = fansNumber;
    }

    private Integer talkNumber;

    @Basic
    @Column(name = "talk_number")
    public Integer getTalkNumber() {
        return talkNumber;
    }

    public void setTalkNumber(Integer talkNumber) {
        this.talkNumber = talkNumber;
    }

    private Integer investNumber;

    @Basic
    @Column(name = "invest_number")
    public Integer getInvestNumber() {
        return investNumber;
    }

    public void setInvestNumber(Integer investNumber) {
        this.investNumber = investNumber;
    }


    private String achievement;

    @Basic
    @Column(name = "achievement")
    public String getAchievement() {
        return achievement;
    }

    public void setAchievement(String achievement) {
        this.achievement = achievement;
    }

    private String institutionIntro;

    @Basic
    @Column(name = "institution_intro")
    public String getInstitutionIntro() {
        return institutionIntro;
    }

    public void setInstitutionIntro(String institutionIntro) {
        this.institutionIntro = institutionIntro;
    }

    private Byte authenticated;

    @Basic
    @Column(name = "authenticated")
    public Byte getAuthenticated() {
        return authenticated;
    }

    public void setAuthenticated(Byte authenticated) {
        this.authenticated = authenticated;
    }


    /**
     * 单向OneToMany, FetchType.LAZY
     * @return
     */

    // 投资项目列表
    /**
     * 单向ManyToMany, FetchType.LAZY
     * @return
     */

    private Timestamp createTime;

    @Basic
    @Column(name = "create_time", insertable = false, updatable = false)
    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }

    private Timestamp updateTime;

    @Basic
    @Column(name = "update_time", insertable = false, updatable = false)
    public Timestamp getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Timestamp updateTime) {
        this.updateTime = updateTime;
    }
}

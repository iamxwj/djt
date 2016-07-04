/*
 * @(#)InstitutionInfo.java, 2015/11/16.
 *
 * Copyright 2015 Alibaodu, Inc. All rights reserved.
 * ALIBAODU PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package com.djt.data.institution;

import com.djt.data.investor.InvestorShortList;
import com.djt.domain.InvestorInfoEntity;

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
    private String status; //身份
    private String business; // 业务

    private List<String> firstFields;

    private String province;
    private String city;
    private String address;
    private String webLogo;
    private String mobileLogo;

    private Timestamp createTime;
    private Timestamp updateTime;
    private Long userId;
    private List<String> investorName;
    private List<InvestorShortList> investorShortLists;

    public InstitutionInfo() {
    }


    public InstitutionInfo(Long institutionId, String name, String institutionIntro, String achievements, int level,
                           String year, Double fundNumber, String fundUnit, String staffSize,
                           List<String> firstFields, String province,  String city,
                           String address,  String webLogo, String mobileLogo, Timestamp createTime,
                           Timestamp updateTime, Long userId, List<String> investorName, List<InvestorShortList> investorShortLists) {
        this.institutionId = institutionId;
        this.institutionIntro = institutionIntro;
        this.fundNumber = fundNumber;
        this.fundUnit = fundUnit;
        this.staffSize = staffSize;
        this.firstFields = firstFields;
        this.province = province;
        this.city = city;
        this.address = address;
        this.webLogo = webLogo;
        this.mobileLogo = mobileLogo;
        this.createTime = createTime;
        this.updateTime = updateTime;
        this.userId = userId;
        this.investorName = investorName;
        this.investorShortLists = investorShortLists;
    }


    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
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

    public List<String> getFirstFields() {
        return firstFields;
    }

    public void setFirstFields(List<String> firstFields) {
        this.firstFields = firstFields;
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

                           List<String> firstFields, String province,  String city, String address,
                           String webLogo, String mobileLogo,
                           List<InstitutionMember> institutionMemberList, Timestamp createTime, Timestamp updateTime, Long userId) {
        this.institutionId = institutionId;
        this.institutionName = institutionName;
        this.institutionIntro = institutionIntro;
        this.achievement = achievement;
        this.institutionLevel = institutionLevel;
        this.foundYear = foundYear;
        this.fundNumber = fundNumber;
        this.fundUnit = fundUnit;
        this.staffSize = staffSize;
        this.firstFields = firstFields;
        this.province = province;
        this.city = city;
        this.address = address;
        this.webLogo = webLogo;
        this.mobileLogo = mobileLogo;
        this.createTime = createTime;
        this.updateTime = updateTime;
        this.userId = userId;
    }

}

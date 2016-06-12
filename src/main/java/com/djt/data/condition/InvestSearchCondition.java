/*
 * @(#)InstitutionSearchCondition.java, 2015/11/11.
 *
 * Copyright 2015 Alibaodu, Inc. All rights reserved.
 * ALIBAODU PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package com.djt.data.condition;

import java.util.List;

/**
 * InvestSearchCondition
 *
 * @author chenbin
 * @date 2015/11/11
 */
public class InvestSearchCondition {
    private Byte userType; // 1 ==> investor;2 ==>institution
    private Byte level; //1==>正科;2==>副处;3==>正处;...;7==>正部
    private Byte investType; // 1==>天使投资;2==>风险投资;3==>私募股权投资;4==>大公司投资部
    private Byte phaseId; // 1==>种子投资;2==>天使投资;3==>风险投资;4==>私募股权投资
    private List<Integer> investFieldList; // 投资领域
    private String location; // 总部位置
    private String orderBy; // 排序方式
    private int pageNumber; // 页码，第一页为0

    public Byte getUserType() {
        return userType;
    }

    public void setUserType(Byte userType) {
        this.userType = userType;
    }

    public Byte getLevel() {
        return level;
    }

    public void setLevel(Byte level) {
        this.level = level;
    }

    public Byte getInvestType() {
        return investType;
    }

    public void setInvestType(Byte investType) {
        this.investType = investType;
    }

    public Byte getPhaseId() {
        return phaseId;
    }

    public void setPhaseId(Byte phaseId) {
        this.phaseId = phaseId;
    }

    public List<Integer> getInvestFieldList() {
        return investFieldList;
    }

    public void setInvestFieldList(List<Integer> investFieldList) {
        this.investFieldList = investFieldList;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getOrderBy() {
        return orderBy;
    }

    public void setOrderBy(String orderBy) {
        this.orderBy = orderBy;
    }

    public int getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(int pageNumber) {
        this.pageNumber = pageNumber;
    }

    @Override
    public String toString() {
        return "InvestSearchCondition{" +
                "userType=" + userType +
                ", level=" + level +
                ", investType=" + investType +
                ", phaseId=" + phaseId +
                ", investFieldList=" + investFieldList +
                ", location=" + location +
                ", orderBy='" + orderBy + '\'' +
                ", pageNumber=" + pageNumber +
                '}';
    }
}

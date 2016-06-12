/*
 * @(#)ProjectSearchCondition.java, 2015/11/13.
 *
 * Copyright 2015 Alibaodu, Inc. All rights reserved.
 * ALIBAODU PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package com.djt.data.condition;

import java.util.List;

/**
 * ProjectSearchCondition
 *
 * @author chenbin
 * @date 2015/11/13
 */
public class ProjectSearchCondition {

    private String name;

    // 发展阶段
    private String phase;

    // 投资类型
    private String investType;
    // 行业领域
    private List<String> fields;

    // 所在省份
    private String location;

    private String orderBy;

    private int pageNumber;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhase() {
        return phase;
    }

    public void setPhase(String phase) {
        this.phase = phase;
    }

    public String getInvestType() {
        return investType;
    }

    public void setInvestType(String investType) {
        this.investType = investType;
    }

    public List<String> getFields() {
        return fields;
    }

    public void setFields(List<String> fields) {
        this.fields = fields;
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
        return "ProjectSearchCondition{" +
                "name='" + name + '\'' +
                ", phase='" + phase + '\'' +
                ", investType='" + investType + '\'' +
                ", fields=" + fields +
                ", location='" + location + '\'' +
                ", orderBy='" + orderBy + '\'' +
                ", pageNumber=" + pageNumber +
                '}';
    }
}

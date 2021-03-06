/*
 * @(#)InvestorService.java, 2015/11/4.
 *
 * Copyright 2015 Alibaodu, Inc. All rights reserved.
 * ALIBAODU PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package com.djt.service;

import com.djt.data.*;
import com.djt.data.condition.InvestSearchCondition;
import com.djt.data.investor.InvestorBasicInfo;
import com.djt.data.investor.InvestorIntro;

import java.util.List;

/**
 * InvestorService
 *
 * @author HOU Zhipeng
 * @date 2016/06/12
 */
public interface InvestorService {
    /**
     * 根据投资人ID获取投资人详情
     * @param investorId：投资人ID
     */
    public ResponseData getInvestorById(Long investorId);

    /**
     * 根据条件查询或筛选投资人列表
     * @param condition
     * @return
     */
    public ResponseData getInvestorList(InvestSearchCondition condition);

    /**
     * 上传投资者基本信息
     * @param investorBasicInfo
     * @return
     */
    public ResponseData uploadInvestorBasicInfo(InvestorBasicInfo investorBasicInfo);



    /**
     * 上传投资者介绍信息
     * @param investorIntro
     * @return
     */
    public ResponseData uploadInvestorIntro(InvestorIntro investorIntro);

    /**
     * 上传投资人照片
     * @param investorId
     * @param url
     * @return
     */
    public ResponseData uploadInvestorPhoto(Long investorId, List<String> url);

    /**
     *
     */
    public ResponseData getAllInvestorList();




    /**
     * 通过姓名搜索
     * @param name
     * @return
     */
    public ResponseData getListByName(String name);

    /**
     * 全文搜索
     * @param institutionName
     * @param institutionMember
     * @param position
     * @param page
     * @param size
     * @return
     */
    public ResponseData getFullSearch(String institutionName, String institutionMember, String position, int page, int size);

    /**
     * 通过行业和职位 查询
     * @param firstField
     * @param position
     * @param page
     * @param size
     * @return
     */
    public ResponseData getByFirstField(String firstField, Byte position, int page, int size);

    public ResponseData getInvestorLevel(Long investorId);
}

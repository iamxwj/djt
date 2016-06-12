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
import com.djt.data.investor.InvestorCase;
import com.djt.data.investor.InvestorIntro;

import java.util.List;

/**
 * InvestorService
 *
 * @author chenbin
 * @date 2015/11/4
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

    public ResponseData getInvestorListByTypeAndPhase(String investType, String phase);

    public ResponseData getInvestorListByType(String investType);

    public ResponseData getInvestorListByTag(String tag);

    public ResponseData getAdvertisment();

    public ResponseData getRecommonderList(List<String> firstField);

    public ResponseData getListByName(String name);
}

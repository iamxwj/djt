/*
 * @(#)InstitutionService.java, 2015/11/4.
 *
 * Copyright 2015 Alibaodu, Inc. All rights reserved.
 * ALIBAODU PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package com.djt.service;

import com.djt.data.*;
import com.djt.data.condition.InvestSearchCondition;
import com.djt.data.institution.InstitutionBasicInfo;

import java.util.List;

/**
 * InstitutionService
 *
 * @author HOU Zhipeng
 * @date 2016/06/12
 */
public interface InstitutionService {
    /**
     * 通过机构ID获取机构信息
     * @param institutionId
     * @return
     */
    public ResponseData getInstitutionById(Long institutionId);

    /**
     * 通过筛选条件获取机构列表
     * @param condition
     * @return
     */
    public ResponseData getInstitutionList(InvestSearchCondition condition);


    public ResponseData getInstitutionIdNameList(String nameLike);

    /**
     * 上传机构基本信息
     * @param form
     * @return
     */
    public ResponseData uploadInstitutionBasicInfo(InstitutionBasicInfo form);



//    public ResponseData uploadInsitutionPhoto(Long institutionId, List<String> url);


    public ResponseData getAllInstitutionList();

//    public ResponseData getInstitutionListByTypeAndPhase(String investType, String phase);
//
//    public ResponseData getInstitutionListByType(String investType);
//
//    public ResponseData getInstitutionListByTag(String tag);

    public ResponseData getListByNameList(String name);

    public ResponseData getFullSearch(String institutionName, String institutionMember, int page, int size);

    public ResponseData getFirstField(String firstField, int page, int size);

    public ResponseData getInstitutionLevel(Long institutionId);
}

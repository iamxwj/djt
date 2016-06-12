/*
 * @(#)InstitutionController.java, 2015/11/4.
 *
 * Copyright 2015 Alibaodu, Inc. All rights reserved.
 * ALIBAODU PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package com.djt.controller;

import com.djt.data.ResponseData;
import com.djt.data.condition.InvestSearchCondition;
import com.djt.data.institution.InstitutionBasicInfo;
import com.djt.data.institution.InstitutionCase;
import com.djt.data.institution.InstitutionMember;
import com.djt.service.InstitutionService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * InstitutionController
 *
 * @author chenbin
 * @date 2015/11/4
 */
@Controller
@RequestMapping("/web/institution")
public class InstitutionController {
    Logger logger = Logger.getLogger(InstitutionController.class);

    @Autowired
    private InstitutionService institutionService;

    /**
     * 机构列表展示
     * @param condition
     */
    @RequestMapping(value = "/institution_list", method = RequestMethod.POST)
    @ResponseBody
    public ResponseData getInstitutionList(@RequestBody InvestSearchCondition condition) {
        logger.debug("InvestSearchCondition: " + condition);
        return institutionService.getInstitutionList(condition);
    }

    @RequestMapping(value = "/institution_list", method = RequestMethod.GET)
    @ResponseBody
    public ResponseData getInstitutionList() {
        logger.debug("method begin");
        InvestSearchCondition condition = new InvestSearchCondition();
        return institutionService.getInstitutionList(condition);
    }


    /**
     * 机构详细信息
     * @param institutionId
     */
    @RequestMapping(value = "/institution_info", method = RequestMethod.GET)
    @ResponseBody
    public ResponseData getInstitutionInfo(@RequestParam("id") Long institutionId) {
        logger.debug(" institutionId = " + institutionId);

        return institutionService.getInstitutionById(institutionId);
    }

    /**
     *  机构个人中心
     */
    @RequestMapping(value = "/institution_center", method = RequestMethod.GET)
    @ResponseBody
    public ResponseData institutionCenter(HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        // 用户尚未登录
        if(session == null)
            return null;

        Long institutionId = (Long) session.getAttribute("institutionId");
        return institutionService.getInstitutionById(institutionId);
    }

    /**
     * 上传基本信息
     * @param info
     */
    @RequestMapping(value = "/institution_basic_info", method = RequestMethod.POST)
    @ResponseBody
    public ResponseData uploadInstitutionBasicInfo(@RequestBody InstitutionBasicInfo info) {
        logger.error("basic info = " + info);
//        HttpSession session = request.getSession(false);
//        if(session == null) {
//            logger.error("user not login");
//            return new ResponseData(false, ResponseData.NOT_LOGIN, null);
//        }

        return institutionService.uploadInstitutionBasicInfo(info);
    }


    @RequestMapping(value = "/institution_name_like", method = RequestMethod.GET)
    @ResponseBody
    public ResponseData getInstitutionIdNameList(String nameLike) {
        logger.debug(" method begin");
        return institutionService.getInstitutionIdNameList(nameLike);
    }
    /**
     * 获取全部列表
     */
    @RequestMapping(value = "/list_all", method = RequestMethod.GET)
    @ResponseBody
    public ResponseData investorListAll() {
        logger.debug("method begin");
        return institutionService.getAllInstitutionList();

    }

    /**
     * 获取列表通过类型和阶段
     * @param investType
     * @param phase
     * @return
     */
    @RequestMapping(value = "/list_by_type_phase", method = RequestMethod.GET)
    @ResponseBody
    public ResponseData getInvestorListByTypeAndPhase(@RequestParam("investType")String investType, @RequestParam("phase")String phase){
        return institutionService.getInstitutionListByTypeAndPhase(investType, phase);
    }

    @RequestMapping(value = "/list_by_type", method = RequestMethod.GET)
    @ResponseBody
    public ResponseData getInvestorListByType(@RequestParam("investType")String investType){
        return institutionService.getInstitutionListByType(investType);
    }
    @RequestMapping(value = "/list_by_tag", method = RequestMethod.GET)
    @ResponseBody
    public ResponseData getInvestorListByTag(@RequestParam("tag")String tag){
        return institutionService.getInstitutionListByTag(tag);
    }
    @RequestMapping(value = "/search_by_name", method = RequestMethod.GET)
    @ResponseBody
    public ResponseData getListByNameList(@RequestParam("name")String name){
        return institutionService.getListByNameList(name);
    }
}

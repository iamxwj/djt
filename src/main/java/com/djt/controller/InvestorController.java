/*
 * @(#)InvestorController.java, 2015/11/4.
 *
 * Copyright 2015 Alibaodu, Inc. All rights reserved.
 * ALIBAODU PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package com.djt.controller;

import com.djt.data.ResponseData;
import com.djt.data.condition.InvestSearchCondition;
import com.djt.data.investor.InvestorBasicInfo;
import com.djt.data.investor.InvestorCase;
import com.djt.data.investor.InvestorIntro;
import com.djt.service.InvestorService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * InvestorController
 *
 * @author chenbin
 * @date 2015/11/4
 */
@Controller
@RequestMapping("/web/investor")
public class InvestorController {
    Logger logger = Logger.getLogger(InvestorController.class);

    @Autowired
    private InvestorService investorService;

    /**
     * 获取全部列表
     */
    @RequestMapping(value = "/list_all", method = RequestMethod.GET)
    @ResponseBody
    public ResponseData investorListAll() {
        logger.debug("method begin");
        return investorService.getAllInvestorList();
    }

    /**
     * 投资者列表
     *
     * @param condition
     * @return
     */
    @RequestMapping(value = "/investor_list", method = RequestMethod.POST)
    @ResponseBody
    public ResponseData investorList(@RequestBody InvestSearchCondition condition) {
        logger.info("method begin condition: " + condition);

        return investorService.getInvestorList(condition);
    }

    @RequestMapping(value = "/investor_list", method = RequestMethod.GET)
    @ResponseBody
    public ResponseData investorList() {
        logger.debug("method begin");
        InvestSearchCondition condition = new InvestSearchCondition();
        return investorService.getInvestorList(condition);
    }

    /**
     * 投资者信息
     *
     * @param investorId
     * @return
     */
    @RequestMapping(value = "/investor_info", method = RequestMethod.GET)
    @ResponseBody
    public ResponseData investorInfo(Long investorId) {
        logger.debug("investorId = " + investorId);
        return investorService.getInvestorById(investorId);
    }

    /**
     * 投资者个人中心
     *
     * @param investorId
     * @return
     */
    @RequestMapping(value = "investor_center", method = RequestMethod.GET)
    @ResponseBody
    public ResponseData investorCenter(@RequestParam("investorId") Long investorId, HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        if (session == null)
            return new ResponseData(false, "No Session", null);
        return investorService.getInvestorById(investorId);
    }

    /**
     * 上传投资者基本信息
     *
     * @param investorBasicInfo
     */
    @RequestMapping(value = "/investor_basic_info", method = RequestMethod.POST)
    @ResponseBody
    public ResponseData uploadInvestorBasicInfo(@RequestBody InvestorBasicInfo investorBasicInfo) {
        logger.debug(" investorBasicInfo: " + investorBasicInfo);
        // session验证
        return investorService.uploadInvestorBasicInfo(investorBasicInfo);
    }

    /**
     * 上传投资人介绍信息
     *
     * @param investorIntro
     * @return
     */
    @RequestMapping(value = "/investor_intro", method = RequestMethod.POST)
    @ResponseBody
    public ResponseData uploadInvestorIntro(@RequestBody InvestorIntro investorIntro) {
        logger.info("investorIntro: " + investorIntro);
        return investorService.uploadInvestorIntro(investorIntro);
    }



    /**
     * 获取列表通过类型和
     *
     * @param investType
     * @param phase
     * @return
     */
    @RequestMapping(value = "/list_by_type_phase", method = RequestMethod.GET)
    @ResponseBody
    public ResponseData getInvestorListByTypeAndPhase(@RequestParam("investType") String investType, @RequestParam("phase") String phase) {
        return investorService.getInvestorListByTypeAndPhase(investType, phase);
    }

    @RequestMapping(value = "/list_by_type", method = RequestMethod.GET)
    @ResponseBody
    public ResponseData getInvestorListByType(@RequestParam("investType") String investType) {
        return investorService.getInvestorListByType(investType);
    }

    @RequestMapping(value = "/list_by_tag", method = RequestMethod.GET)
    @ResponseBody
    public ResponseData getInvestorListByTag(@RequestParam("tag") String tag) {
        return investorService.getInvestorListByTag(tag);
    }

    @RequestMapping(value = "/get_ad", method = RequestMethod.GET)
    @ResponseBody
    public ResponseData getInvestorListByTag() {
        return investorService.getAdvertisment();
    }


    @RequestMapping(value = "/get_recommander", method = RequestMethod.POST)
    @ResponseBody
    public ResponseData getInvestorListByTag(@RequestBody List<String> investType) {
        return investorService.getRecommonderList(investType);
    }

    @RequestMapping(value = "/search_by_name", method = RequestMethod.GET)
    @ResponseBody
    public ResponseData getInvestorListByName(@RequestParam("name") String name) {
        return investorService.getListByName(name);
    }
}
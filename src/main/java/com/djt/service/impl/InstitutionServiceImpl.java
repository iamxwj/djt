/*
 * @(#)InstitutionServiceImpl.java, 2015/11/11.
 *
 * Copyright 2015 Alibaodu, Inc. All rights reserved.
 * ALIBAODU PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package com.djt.service.impl;

import com.djt.dao.*;
import com.djt.data.*;
import com.djt.data.condition.InvestSearchCondition;
import com.djt.data.institution.*;
import com.djt.domain.*;
import com.djt.service.InstitutionService;
import com.djt.utils.*;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.util.*;

/**
 * InstitutionServiceImpl
 *
 * @author zhipeng
 * @date 2016/06/10
 */
@Service
public class InstitutionServiceImpl implements InstitutionService {

    private Logger logger = Logger.getLogger(InstitutionServiceImpl.class);

    @Autowired
    private InstitutionInfoDao institutionInfoDao;

    /**
     * 透过机构ID获取投资机构信息
     * @param institutionId
     * @return
     */
    @Override
    public ResponseData getInstitutionById(Long institutionId) {
        if(institutionId == null) {
            logger.error("method parameter institutionId is null");
            return new ResponseData(false, "institutionId is null", null);
        }
        if(institutionId == 0) {
            logger.error("method parameter institutionId == 0");
            return new ResponseData(false, "institutionId == 0", null);
        }
        logger.info("institutionId == " + institutionId);


        InstitutionInfoEntity entity = institutionInfoDao.findByInstitutionId(institutionId);
        if(entity == null)
            return new ResponseData(false, "get institution info fail", null);

        InstitutionInfo info = parseInstitutionEntity(entity);
        return new ResponseData(true, "get institution info success", info);
    }

    /**
     * 解析机构Entity
     * @param entity
     * @return
     */
    private InstitutionInfo parseInstitutionEntity(InstitutionInfoEntity entity) {
        Long institutionId = entity.getInstitutionId();
        String name = entity.getInstitutionName();
        String institutionIntro = entity.getInstitutionIntro();
        String achievements = entity.getAchievement();
        int level = entity.getInstitutionLevel();
        String year = entity.getFoundYear();
        Double fundNumber = entity.getFundNumber();
        String fundUnit = entity.getFundUnit();
        String staffSize = entity.getStaffSize();

        String investType = entity.getInvestType();

        String[] phaseArray = entity.getInvestPhase().split("\\|");
        List<String> investPhase;
        if(phaseArray[0].length() == 0)
            investPhase = new ArrayList<>();
        else
            investPhase = Arrays.asList(phaseArray);

        String mainPhase =entity.getMainPhase();

        String tag = entity.getTag();

        List<String> tags = StringUtil.renderStringToList(tag,"\\|");

        String[] firstFieldArray = entity.getFirstFields().split("\\|");
        List<String> firstFields;
        if(firstFieldArray[0].length() == 0)
            firstFields = new ArrayList<>();
        else
            firstFields = Arrays.asList(firstFieldArray);

        String secondFields= entity.getSecondFields();

        byte successIndicator = entity.getInvestSuccessIndicator();
        byte activeIndicator = entity.getInvestActiveIndicator();
        byte brandIndicator = entity.getBrandIndicator();
        byte rateIndicator = entity.getInvestRateIndicator();

        int overallRank = entity.getOverallRank();
        int annualRank = entity.getAnnualRank();
        int activeRank = entity.getActiveRank();

        long fansNumber = entity.getFansNumber();
        int talkNumber = entity.getTalkNumber();
        int investNumber = entity.getInvestNumber();


        String province = entity.getProvince();
        List<String >locateProvinces = StringUtil.renderStringToList(entity.getLocateProvinces(),"\\|");
        String city = entity.getCity();
        String address = entity.getAddress();

        Byte authenticated = entity.getAuthenticated();

        String webLogo = entity.getWebLogo();
        String mobileLogo = entity.getMobileLogo();
        String institutionPhoto = entity.getInstitutionPhoto();

        Timestamp createTime = entity.getCreateTime();
        Timestamp updateTime = entity.getUpdateTime();

        InstitutionInfo info = new InstitutionInfo(institutionId, name, institutionIntro, achievements,
                level, year, fundNumber, fundUnit, staffSize,
                investType, investPhase, mainPhase, tags, firstFields, secondFields,
                successIndicator, activeIndicator, brandIndicator, rateIndicator,
                overallRank, annualRank, activeRank,
                fansNumber, talkNumber, investNumber,
                province, locateProvinces, city, address,
                authenticated, webLogo, mobileLogo, institutionPhoto,
                 createTime, updateTime);

        return info;
    }


    @Override
    @Transactional
    public ResponseData getInstitutionList(InvestSearchCondition condition) {
        // condition验证
        int pageSize = Integer.parseInt(ConfigUtils.getProperty("institution.page_size"));

        String property = "fansNumber";
        if(condition.getOrderBy() != null && condition.getOrderBy().length() != 0) {
            property = condition.getOrderBy();
        }
        Pageable page = PageAndSortUtils.pageDescSortRequest(property, condition.getPageNumber(), pageSize);
        //Specification<InstitutionInfoEntity> spec = SpecUtils.institutionListSpec(condition);
        //Iterable<InstitutionInfoEntity> institutionInfoEntityList = institutionInfoDao.findAll(spec, page);
        Iterable<InstitutionInfoEntity> institutionInfoEntityList = institutionInfoDao.findAll();
        if(institutionInfoEntityList == null) {
            return null;
        }

        List<InstitutionInfo> institutionList = new ArrayList<>();
        Set<Long> institutionIdSet = new HashSet<>();
        for(InstitutionInfoEntity entity : institutionInfoEntityList) {
            Long id = entity.getInstitutionId();

            if(institutionIdSet.contains(id)) continue;

            institutionIdSet.add(id);

            InstitutionInfo info = parseInstitutionEntity(entity);
            institutionList.add(info);
        }

        return new ResponseData(true, "get list success", institutionList);
    }

    @Override
    public ResponseData getInstitutionIdNameList(String nameLike) {
        if(nameLike == null || nameLike.length() == 0) {
            String logStr = "method parameter nameLike == " + nameLike;
            logger.error(logStr);
            return new ResponseData(false, logStr, null);
        }

        List<InstitutionInfoEntity> institutionInfoEntityList = institutionInfoDao.findByInstitutionNameLike(nameLike);

        List<InstitutionIdName> institutionIdNameList = new ArrayList<>();
        if(institutionInfoEntityList == null || institutionInfoEntityList.size() == 0) {
            return new ResponseData(true, "result is empty", institutionIdNameList);
        }

        for(InstitutionInfoEntity entity : institutionInfoEntityList) {
            long institutionId = entity.getInstitutionId();
            String institutionName = entity.getInstitutionName();

            InstitutionIdName institutionIdName = new InstitutionIdName(institutionId, institutionName);
            institutionIdNameList.add(institutionIdName);
        }
        return new ResponseData(true, "get list success", institutionIdNameList);
    }

    @Override
    @Transactional
    public ResponseData uploadInstitutionBasicInfo(InstitutionBasicInfo info) {
        if(info == null) {
            String logInfo = "method parameter info == " + info;
            logger.error(logInfo);
            return new ResponseData(false, logInfo, null);
        }
        ValidResult valid = info.validateAllFields();
        logger.debug("field validate result : " + valid.getMsg());
        if(!valid.isValid()) {
            String msg = valid.getMsg();
            return new ResponseData(false, msg, null);
        }

        long institutionId = info.getInstitutionId();
        try {
            InstitutionInfoEntity entity = institutionInfoDao.findByInstitutionId(institutionId);

            entity.setInstitutionName(info.getInstitutionName());
            entity.setFoundYear(info.getFoundYear());
            entity.setFundNumber(info.getFundNumber());
            entity.setFundUnit(info.getFundUnit());
            entity.setStaffSize(info.getStaffSize());
            entity.setInvestType(info.getInvestType());

            StringBuilder sb = new StringBuilder();
            for(int i = 0; i < info.getInvestPhase().size(); i++) {
                if(i == 0)
                    sb.append(info.getInvestPhase().get(i));
                else
                    sb.append("|" + info.getInvestPhase().get(i));
            }
            entity.setInvestPhase(sb.toString());

            entity.setMainPhase(info.getMainPhase());
            entity.setTag(StringUtil.renderListToString(info.getTag()));

            StringBuilder sb2 = new StringBuilder();
            for(int i = 0; i < info.getFirstFields().size(); i++) {
                if(i == 0)
                    sb2.append(info.getFirstFields().get(i));
                else
                    sb2.append("|" + info.getFirstFields().get(i));
            }
            entity.setFirstFields(sb2.toString());
            entity.setSecondFields(info.getSecondFields());

            entity.setProvince(info.getProvince());
            entity.setCity(info.getCity());
            entity.setAddress(info.getAddress());
            entity.setLocateProvinces(StringUtil.renderListToString(info.getLocateProvinces()));

            entity.setAchievement(info.getAchievement());
            entity.setInstitutionIntro(info.getIntro());
            entity.setWebLogo(info.getWebLogo());
            entity.setMobileLogo(info.getMobileLogo());

            institutionInfoDao.save(entity);

            logger.info("upload institution basic info success, institutionId = " + institutionId);
            return new ResponseData(true, "upload institution basic info success", null);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseData(false, "upload institution basic info fail", null);
        }
    }

    @Override
    public ResponseData uploadInsitutionPhoto(Long institutionId, List<String> url) {
        InstitutionInfoEntity entity = institutionInfoDao.findOne(institutionId);

        if(entity != null) {
            StringBuilder sb = new StringBuilder();
            for(int i = 0; i < url.size(); i++) {
                if(i == 0)
                    sb.append(url.get(i));
                else
                    sb.append("|" + url.get(i));
            }
            entity.setInstitutionPhoto(sb.toString());

            institutionInfoDao.save(entity);
            return new ResponseData(true, "success", null);
        }
        return new ResponseData(false, "fail", null);
    }

    @Override
    public ResponseData getAllInstitutionList() {
        try {
            Iterable<InstitutionInfoEntity> institutionInfoEntities = institutionInfoDao.findAll();
            List<InstitutionInfo> investorInfos= parseInvestorEntities(institutionInfoEntities);

            return new ResponseData(true, "get investor info List success", investorInfos);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseData(false, "get investor info List exists", null);
        }
    }

    private List<InstitutionInfo> parseInvestorEntities(Iterable<InstitutionInfoEntity> institutionInfoEntities) {
        List<InstitutionInfo> institutionInfos = new ArrayList<>();
        InstitutionInfo institutionInfo;
        for(InstitutionInfoEntity in : institutionInfoEntities){
            institutionInfo = parseInstitutionEntity(in);
            institutionInfos.add(institutionInfo);
        }
        return institutionInfos;
    }

    @Override
    public ResponseData getInstitutionListByTypeAndPhase(String investType, String phase) {
        try {
            phase = "%" + phase + "%";
            Iterable<InstitutionInfoEntity> institutionInfoEntities = institutionInfoDao.findByInvestTypeAndInvestPhaseLike(investType, phase);
            List<InstitutionInfo> investorInfos= parseInvestorEntities(institutionInfoEntities);

            return new ResponseData(true, "get investor info List success", investorInfos);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseData(false, "get investor info List exists", null);
        }
    }

    @Override
    public ResponseData getInstitutionListByType(String investType) {
        try {
            Iterable<InstitutionInfoEntity> institutionInfoEntities = institutionInfoDao.findByInvestType(investType);
            List<InstitutionInfo> investorInfos= parseInvestorEntities(institutionInfoEntities);

            return new ResponseData(true, "get investor info List success", investorInfos);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseData(false, "get investor info List exists", null);
        }
    }

    @Override
    public ResponseData getInstitutionListByTag(String tag) {
        try {
            tag = "%" +tag +"%";
            Iterable<InstitutionInfoEntity> institutionInfoEntities = institutionInfoDao.findByTagLike(tag);
            List<InstitutionInfo> investorInfos= parseInvestorEntities(institutionInfoEntities);

            return new ResponseData(true, "get investor info List success", investorInfos);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseData(false, "get investor info List exists", null);
        }
    }

    @Override
    public ResponseData getListByNameList(String name) {
        try {
            name = "%" +name +"%";
            Iterable<InstitutionInfoEntity> institutionInfoEntities = institutionInfoDao.findByInstitutionNameLike(name);
            List<InstitutionInfo> investorInfos= parseInvestorEntities(institutionInfoEntities);

            return new ResponseData(true, "get investor info List success", investorInfos);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseData(false, "get investor info List exists", null);
        }
    }

}

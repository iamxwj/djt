/*
 * @(#)InvestorServiceImpl.java, 2015/11/18.
 *
 * Copyright 2015 Alibaodu, Inc. All rights reserved.
 * ALIBAODU PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package com.djt.service.impl;

import com.djt.common.UserType;
import com.djt.dao.*;
import com.djt.data.*;
import com.djt.data.condition.InvestSearchCondition;
import com.djt.data.investor.*;
import com.djt.domain.*;
import com.djt.service.InvestorService;
import com.djt.utils.*;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.util.*;

/**
 * InvestorServiceImpl
 *
 * @author HOU Zhipeng
 * @date 2016/06/12
 */
@Service
public class InvestorServiceImpl implements InvestorService {
    Logger logger = Logger.getLogger(InvestorServiceImpl.class);

    private int CACHE_INVESTOR_ACCESS_EXPIRE = Integer.parseInt(ConfigUtils.getProperty("cache.investor.expire_after_access"));
    private int CACHE_INVESTOR_WRITE_EXPIRE = Integer.parseInt(ConfigUtils.getProperty("cache.investor.expire_after_write"));
    private int CACHE_INVESTOR_MAX_SIZE = Integer.parseInt(ConfigUtils.getProperty("cache.investor.maxsize"));

    @Autowired
    private InvestorInfoDao investorInfoDao;
    @Autowired
    private InstitutionInfoDao institutionInfoDao;


    @Override
    public ResponseData getInvestorList(InvestSearchCondition condition) {
        int pageSize = Integer.parseInt(ConfigUtils.getProperty("investor.page_size"));

        String property = "fansNumber";
        if(condition.getOrderBy() != null && condition.getOrderBy().trim().length() != 0) {
            property = condition.getOrderBy();
        }
        Pageable page = PageAndSortUtils.pageDescSortRequest(property, condition.getPageNumber(), pageSize);

        logger.info("pageNumber = " + page.getPageNumber() + "; pageSize = " + page.getPageSize());


        //Specification<InvestorInfoEntity> spec = SpecUtils.investorListSpec(condition);
        Iterable<InvestorInfoEntity> investorInfoEntityList = investorInfoDao.findAll();
        if(investorInfoEntityList == null)
            return null;

        List<InvestorInfo> investorList = new ArrayList<>();
        Set<Long> investorIdList = new HashSet<>();

        for(InvestorInfoEntity entity : investorInfoEntityList) {
            Long investorId = entity.getInvestorId();

            if(investorIdList.contains(investorId)) continue;

            investorIdList.add(investorId);

            InvestorInfo info = parseInvestorEntity(entity);
            investorList.add(info);
        }

        return new ResponseData(true, "success", investorList);
    }

    @Override
    public ResponseData getInvestorById(Long investorId) {
        if(investorId == null) {
            logger.error(" method parameter investorId is null");
            return new ResponseData(false, "investorId is null", null);

        }else if(investorId == 0) {
            logger.error("method parameter investorId == 0");
            return new ResponseData(false, "investorId == 0", null);
        }

        try {
            InvestorInfoEntity entity = investorInfoDao.findByInvestorId(investorId);
            InvestorInfo info = parseInvestorEntity(entity);

            return new ResponseData(true, "get investor info success", info);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseData(false, "investor with id: " + investorId + " not exists", null);
        }
    }

    /**
     * 解析Investor Entity
     * @param entity
     * @return
     */
    private InvestorInfo parseInvestorEntity(InvestorInfoEntity entity) {
        Long investorId = entity.getInvestorId();
        String investorName = entity.getInvestorName();
        String investType = entity.getInvestType();
        List<String> tag = StringUtil.renderStringToList(entity.getTag(), "\\|");
        String investorPosition = entity.getInvestorPosition();
        String birthYear = entity.getBirthYear();
        String nativeProvince = entity.getNativeProvince();
        String nativeDistrict = entity.getNativeDistrict();
        String education = entity.getEducation();
        Integer age = entity.getAge();
        String gender = entity.getGender();
        Double fundNumber = entity.getFundNumber();
        String fundUnit = entity.getFundUnit();

        String institutionName = entity.getInstitutionName();
        int investorLevel = entity.getInvestorLevel();

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
        String city = entity.getCity();
        String address = entity.getAddress();

        String achievement = entity.getAchievement();
        String investorIntro = entity.getInvestorIntro();
        Byte authenticated = entity.getAuthenticated();
        String philosophy = entity.getInvestPhilosophy();

        String eduExp = entity.getEduExp();
        String workExp = entity.getWorkExp();
        String others = entity.getOthers();

        String mobilePortraitUrl = entity.getMobilePortrait();
        List<String> webPortraitUrl = getPhotoUrlList(entity.getWebPortrait());
        List<String> investorPhotoUrlList = getPhotoUrlList(entity.getInvestorPhoto());

        String investPhase = entity.getInvestPhase();
        String[] phaseArray = investPhase.split("\\|");
        List<String> phaseList;
        if(phaseArray[0].length() == 0)
            phaseList = new ArrayList<>();
        else
            phaseList = Arrays.asList(phaseArray);

        String mainPhase = entity.getMainPhase();

        String firstFields = entity.getFirstFields();
        String[] firstFieldArray = firstFields.split("\\|");
        List<String> fieldList;
        if(firstFieldArray[0].length() == 0)
            fieldList = new ArrayList<>();
        else
            fieldList = Arrays.asList(firstFieldArray);

        String secondFields = entity.getSecondFields();

        Timestamp createTime = entity.getCreateTime();
        Timestamp lastUpdate = entity.getUpdateTime();

        InvestorInfo investorInfo = new InvestorInfo(investorId, investorName, investType, mainPhase, tag, investorPosition, investorLevel, birthYear,
                nativeProvince,nativeDistrict, education, age, gender, institutionName, fundNumber, fundUnit, successIndicator, activeIndicator, brandIndicator,
                rateIndicator, overallRank, annualRank, activeRank, fansNumber, talkNumber, investNumber, province, city, address,
                achievement,investorIntro, authenticated,  phaseList, fieldList, secondFields, philosophy, eduExp,
                workExp, others, mobilePortraitUrl, webPortraitUrl, investorPhotoUrlList, createTime, lastUpdate);

        return investorInfo;
    }

    @Override
    @Transactional
    public ResponseData uploadInvestorBasicInfo(InvestorBasicInfo info) {
        logger.info(info);
        long investorId = info.getInvestorId();

        try {
            InvestorInfoEntity entity = investorInfoDao.findByInvestorId(investorId);

            entity.setInvestorName(info.getInvestorName());
            entity.setBirthYear(info.getBirthYear());
            entity.setNativeProvince(info.getNativeProvince());
            entity.setNativeDistrict(info.getNativeDistrict());
            entity.setAge(info.getAge());
            entity.setGender(info.getGender());
            entity.setFundNumber(info.getFundNumber());
            entity.setFundUnit(info.getFundUnit());
            entity.setEducation(info.getEducation());
            entity.setInstitutionName(info.getInstitutionName());
            entity.setInvestorPosition(info.getInvestorPosition());
            entity.setInvestType(info.getInvestType());
            entity.setMainPhase(info.getMainPhase());

            entity.setTag(StringUtil.renderListToString(info.getTag()));
            entity.setProvince(info.getProvince());
            entity.setCity(info.getCity());
            entity.setAddress(info.getAddress());
            entity.setMobilePortrait(info.getMobilePortraitUrl());

            List<String> webPortraitUrlList = info.getWebPortraitUrl();
            StringBuilder sb = new StringBuilder();
            for(int i = 0; i < webPortraitUrlList.size(); i++) {
                if(i == 0)
                    sb.append(webPortraitUrlList.get(0));
                else
                    sb.append("|" + webPortraitUrlList.get(1));
            }
            entity.setWebPortrait(sb.toString());

            sb = new StringBuilder();
            for(int i = 0; i < info.getInvestPhaseList().size(); i++) {
                if (i == 0)
                    sb.append(info.getInvestPhaseList().get(i));
                else
                    sb.append("|" + info.getInvestPhaseList().get(i));
            }
            entity.setInvestPhase(sb.toString());


            sb = new StringBuilder();
            for(int i = 0; i < info.getFirstFieldList().size(); i++) {
                if (i == 0)
                    sb.append(info.getFirstFieldList().get(i));
                else
                    sb.append("|" + info.getFirstFieldList().get(i));
            }
            entity.setFirstFields(sb.toString());

            entity.setSecondFields(info.getSecondField());

            // 上传基本信息、投资人照片、投资阶段、投资领域
            investorInfoDao.save(entity);
            logger.info("save basic info success, investorId = " + investorId);
            return new ResponseData(true, "success", null);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseData(false, "fail", null);
        }
    }

    @Override
    @Transactional
    public ResponseData uploadInvestorIntro(InvestorIntro intro) {
        long investorId = intro.getInvestorId();
        logger.info("upload investor intro begin, investorId = " + investorId);
        try {
            InvestorInfoEntity entity = investorInfoDao.findByInvestorId(investorId);

            entity.setInvestorIntro(intro.getInvestorIntro());
            entity.setAchievement(intro.getAchievement());
            entity.setEduExp(intro.getEduExp());
            entity.setWorkExp(intro.getWorkExp());
            entity.setInvestPhilosophy(intro.getInvestPhilosophy());
            entity.setOthers(intro.getOthers());

            // 上传投资人介绍信息
            investorInfoDao.save(entity);
            logger.info("save investor intro success, investorId = " + investorId);
            return new ResponseData(true, "success", null);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseData(false, "fail", null);
        }
    }


    @Override
    public ResponseData uploadInvestorPhoto(Long investorId, List<String> urlList) {
        if(investorId == null || investorId <=0 || urlList == null || urlList.size() == 0) {
            String msg = "investorId = " + investorId + "; url = " + urlList;
            logger.error(msg);
            return new ResponseData(false, msg, null);
        }

        try {
            InvestorInfoEntity entity = investorInfoDao.findByInvestorId(investorId);

            StringBuilder sb = new StringBuilder();
            for(int i = 0; i < urlList.size(); i++) {
                if(i == 0)
                    sb.append(urlList.get(i));
                else
                    sb.append("|" + urlList.get(i));
            }
            entity.setInvestorPhoto(sb.toString());
            investorInfoDao.save(entity);

            return new ResponseData(true, "upload investor photo success", null);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseData(false, "upload investor photo fail", null);
        }
    }

    /**
     *
     */
    @Override
    public ResponseData getAllInvestorList() {
        try {
            List<InvestorInfoEntity> investorInfoEntities = investorInfoDao.findAll();
            List<InvestorInfo> investorInfos= parseInvestorEntities(investorInfoEntities);

            return new ResponseData(true, "get investor info List success", investorInfos);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseData(false, "get investor info List exists", null);
        }
    }

    @Override
    public ResponseData getInvestorListByTypeAndPhase(String investType, String phase) {
        try {
            phase = "%" + phase + "%";
            List<InvestorInfoEntity> investorInfoEntities = investorInfoDao.findByInvestTypeAndInvestPhaseLike(investType, phase);
            List<InvestorInfo> investorInfos= parseInvestorEntities(investorInfoEntities);

            return new ResponseData(true, "get investor info List success", investorInfos);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseData(false, "get investor info List exists", null);
        }
    }

    @Override
    public ResponseData getInvestorListByType(String investType) {
        try {
            List<InvestorInfoEntity> investorInfoEntities = investorInfoDao.findByInvestType(investType);
            List<InvestorInfo> investorInfos= parseInvestorEntities(investorInfoEntities);

            return new ResponseData(true, "get investor info List success", investorInfos);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseData(false, "get investor info List exists", null);
        }
    }

    @Override
    public ResponseData getInvestorListByTag(String tag) {
        try {
            tag = "%" +tag +"%";
            List<InvestorInfoEntity> investorInfoEntities = investorInfoDao.findByTagLike(tag);
            List<InvestorInfo> investorInfos= parseInvestorEntities(investorInfoEntities);

            return new ResponseData(true, "get investor info List success", investorInfos);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseData(false, "get investor info List exists", null);
        }
    }

    @Override
    public ResponseData getAdvertisment() {
        try {
            String tag = "%" +"VIP" +"%";
            List<InvestorInfoEntity> investorInfoEntities = investorInfoDao.findByTagLike(tag);
            List<AdvertismentInfo> investorInfos= parseInvestorEntitiesToAdInfo(investorInfoEntities);
            
            List <InstitutionInfoEntity> instituionList = institutionInfoDao.findByTagLike(tag);
            List<AdvertismentInfo> investorInfos2 = parseInstitutionToAdInfo(instituionList);
            List<AdvertismentInfo> all = new ArrayList<>();
            all.addAll(investorInfos);
            all.addAll(investorInfos2);
            return new ResponseData(true, "get investor info List success", all);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseData(false, "get investor info List exists", null);
        }
    }

    @Override
    public ResponseData getRecommonderList( List<String> phase) {
        try {

            String tag = "%" +"VIP" +"%";
            List<InvestorInfo> investorInfos = new ArrayList<>();
            List<InvestorInfoEntity> investorInfoEntities1 = investorInfoDao.findByTagLike(tag);
            Set<InvestorInfoEntity> investorInfoEntitySet = new HashSet<>();
            investorInfoEntitySet.addAll(investorInfoEntities1);
            investorInfos.addAll(parseInvestorEntities(investorInfoEntities1));
            for(String p : phase) {
                System.out.println(p);
                String firstFields = "%" + p + "%";
                List<InvestorInfoEntity> investorInfoEntities = investorInfoDao.findByFirstFieldsLike(firstFields);
                investorInfoEntitySet.addAll(investorInfoEntities);
            }
            investorInfos = parseInvestorEntities(investorInfoEntitySet);
            return new ResponseData(true, "get Recommonder List success", investorInfos);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseData(false, "get Recommonder List exists", null);
        }
    }

    @Override
    public ResponseData getListByName(String name) {
        try {

             name = "%" +name +"%";
            List<InvestorInfoEntity> investorInfoEntities1 = investorInfoDao.findByInvestorNameLike(name);
            List <InvestorInfo> investorInfos = parseInvestorEntities(investorInfoEntities1);
            return new ResponseData(true, "get search List success", investorInfos);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseData(false, "get search List fail", null);
        }
    }

    private List<AdvertismentInfo> parseInstitutionToAdInfo(List<InstitutionInfoEntity> instituionList) {
        List<AdvertismentInfo> infos= new ArrayList<>();
        Long id;
        String name;
        String img;
        for(InstitutionInfoEntity e: instituionList){
            id = e.getInstitutionId();
            name = e.getInstitutionName();
            img = e.getMobileLogo();
            infos.add(new AdvertismentInfo(id,name, UserType.INSTITUTION,img));

        }
        return infos;
    }

    private List<AdvertismentInfo> parseInvestorEntitiesToAdInfo(List<InvestorInfoEntity> investorInfoEntities) {
        List<AdvertismentInfo> infos= new ArrayList<>();
        Long id;
        String name;
        String img;
        for(InvestorInfoEntity e: investorInfoEntities){
            id = e.getInvestorId();
            name = e.getInvestorName();
            img = e.getMobilePortrait();
            infos.add(new AdvertismentInfo(id,name, UserType.INVESTOR,img));

        }
        return infos;

    }

    private List<InvestorInfo> parseInvestorEntities(Collection<InvestorInfoEntity> investorInfoEntities) {
        List<InvestorInfo> investorInfos = new ArrayList<>();
        InvestorInfo investorInfo;
        for(InvestorInfoEntity investorInfoEntity: investorInfoEntities){
            investorInfo = parseInvestorEntity(investorInfoEntity);
            investorInfos.add(investorInfo);
        }
        return investorInfos;
    }

    /**
     * 获取投资人照片
     * @param urlStr
     * @return
     */
    private List<String> getPhotoUrlList(String urlStr) {
        if(urlStr == null || urlStr.length() == 0) {
            logger.error("gwo et investor photo url list error, method parameter entity is null");
            return null;
        }
        String[] urlArray = urlStr.split("\\|");

        List<String> urlList;
        if(urlArray.length == 1 && urlArray[0].length() == 0)
            urlList = new ArrayList<>();
        else
            urlList = Arrays.asList(urlArray);

        return urlList;
    }

}

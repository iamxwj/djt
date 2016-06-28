package com.djt.service.impl;

import com.djt.common.UserType;
import com.djt.dao.*;
import com.djt.data.ResponseData;
import com.djt.data.follow.FollowFansCountInfo;
import com.djt.data.follow.FollowInfo;
import com.djt.data.follow.FollowedOrNotInfo;
import com.djt.domain.FollowEntity;
import com.djt.domain.InstitutionInfoEntity;
import com.djt.domain.InvestorInfoEntity;
import com.djt.service.FollowService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Zhipeng on 2016/4/7.
 */
@Service
public class FollowServiceImpl implements FollowService {
    Logger logger = Logger.getLogger(FollowService.class);
    @Autowired
    private FollowDao followDao;


    @Autowired
    private UserInfoDao userDao;

    @Autowired
    private InvestorInfoDao investorInfoDao;

    @Autowired
    private InstitutionInfoDao institutionInfoDao;



    @Override
    public ResponseData countFollows(Long userId) {

        try {
            int follows = followDao.countFollow(userId);
            return new ResponseData(true, "count follows success", follows);
        } catch (Exception e) {
            return new ResponseData(false, "Follow new user fail", 0);
        }
    }

    /**
     * 获取粉丝数
     *
     * @param userId
     */
    @Override
    public ResponseData countFans(Long userId) {
        try {
            int follows = followDao.countFans(userId);

            return new ResponseData(true, "count follows success", new FollowFansCountInfo(userId,follows));
        } catch (Exception e) {
            return new ResponseData(false, "Follow new user fail", 0);
        }
    }

    @Override
    public ResponseData addFollow(Long userId, Byte userType, Long followId, Byte followType) {

        try {
            FollowEntity followEntity = new FollowEntity(userId, followId, userType, followType);
            followDao.save(followEntity);
            return new ResponseData(true, "Follow new user success", null);
        } catch (Exception e) {
            return new ResponseData(false, "Follow new user fail", null);
        }

    }

    @Override
    public ResponseData deleteFollow(Long userId, Long followId) {
        try {
            List<FollowEntity> followEntity = followDao.findByNoticeListAndFansList(userId, followId);
            followDao.delete(followEntity);
            return new ResponseData(true, "Delete Follower success", null);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseData(false, "Delete Follower fail", null);
        }
    }

    @Override
    public ResponseData getAllFollowPerson(Long userId) {
        try {
            List<FollowEntity> entities = followDao.findByNoticeListAndFansType(userId, (byte) 1);
            List<FollowInfo> followInfos = renderFollowPersons(entities);
            return new ResponseData(true, "get Follow Person success", followInfos);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseData(false, "get Follow Person fail", null);
        }
    }

    private List<FollowInfo> renderFollowPersons(List<FollowEntity> entities) {
        List<FollowInfo> followInfos = new ArrayList<>();

        for (FollowEntity followEntity : entities) {


            followInfos.add(renderFollowPerson(followEntity));
        }
        return followInfos;
    }

    private FollowInfo renderFollowPerson(FollowEntity followEntity) {
        InvestorInfoEntity investorInfo;
        String investorName = null;
        Long userId, id;
        Byte level = null;
        FollowInfo followInfo;
        id = followEntity.getId();
        userId = followEntity.getFansList();
        investorInfo = investorInfoDao.findByUserId(userId);
        if (investorInfo == null) {
            return null;
        }
        String mobilePhoto;
        String investPosition;
        String investInstiName;
        mobilePhoto = investorInfo.getMobilePortrait();
        investPosition = investorInfo.getInvestorPosition();
        investInstiName = investorInfo.getInstitutionName();
        level = investorInfo.getInvestorLevel();
        investorName = investorInfo.getInvestorName();
        followInfo = new FollowInfo(userId, investorName, (byte) 1, level, id,mobilePhoto,investPosition,"",investInstiName);
        return followInfo;
    }


    @Override
    public ResponseData getAllFollowInstitution(Long userId) {
        try {
            List<FollowEntity> entities = followDao.findByNoticeListAndFansType(userId, (byte) 2);
            List<FollowInfo> followInfos = renderInstitutions(entities);
            return new ResponseData(true, "get Follow Person success", followInfos);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseData(false, "get Follow Person fail", null);
        }
    }

    private List<FollowInfo> renderInstitutions(List<FollowEntity> entities) {
        List<FollowInfo> followInfos = new ArrayList<FollowInfo>();
        for (FollowEntity followEntity : entities) {
            followInfos.add(renderInstitution(followEntity));
        }
        return followInfos;
    }

    private FollowInfo renderInstitution(FollowEntity followEntity) {
        InstitutionInfoEntity investorInfo;
        String investorName = null;
        Long userId, id;
        Byte level = null;
        String mobilePhote;
        FollowInfo followInfo;
        id = followEntity.getId();
        userId = followEntity.getFansList();
        investorInfo = institutionInfoDao.findByUserId(userId);

        if (investorInfo == null) {
            return null;
        }
        level = investorInfo.getInstitutionLevel();
        investorName = investorInfo.getInstitutionName();
        mobilePhote = investorInfo.getMobileLogo();
        followInfo = new FollowInfo(userId, investorName, (byte) UserType.INSTITUTION, level, id,mobilePhote,"","","" );
        return followInfo;
    }

    @Override
    public ResponseData getAllFansPerson(Long userId) {
        try {
            List<FollowEntity> entities = followDao.findByFansListAndNoticeType(userId, (byte) UserType.INVESTOR);
            List<FollowInfo> followInfos = renderFansPersons(entities);
            return new ResponseData(true, "get Follow Person success", followInfos);
        } catch (Exception e) {
            return new ResponseData(false, "get Follow Person fail", null);
        }
    }

    private List<FollowInfo> renderFansPersons(List<FollowEntity> entities) {
        List<FollowInfo> followInfos = new ArrayList<>();

        for (FollowEntity followEntity : entities) {


            followInfos.add(renderFansPerson(followEntity));
        }
        return followInfos;
    }

    private FollowInfo renderFansPerson(FollowEntity followEntity) {
        InvestorInfoEntity investorInfo;
        String investorName = null;
        Long userId, id;
        Byte level = null;
        FollowInfo followInfo;
        id = followEntity.getId();
        userId = followEntity.getNoticeList();

        investorInfo = investorInfoDao.findByUserId(userId);
        if (investorInfo == null) {
            return null;
        }
        String mobilePhoto;
        String investPosition;
        String investInstiName;
        mobilePhoto = investorInfo.getMobilePortrait();
        investPosition = investorInfo.getInvestorPosition();
        investInstiName = investorInfo.getInstitutionName();
        level = investorInfo.getInvestorLevel();
        investorName = investorInfo.getInvestorName();
        followInfo = new FollowInfo(userId, investorName, (byte) 1, level, id,mobilePhoto,investPosition,"",investInstiName);
        return followInfo;
    }


    @Override
    public ResponseData getAllFansInstitution(Long userId) {
        try {
            List<FollowEntity> entities = followDao.findByFansListAndNoticeType(userId, (byte) 2);
            List<FollowInfo> followInfos = renderFansInstitutions(entities);
            return new ResponseData(true, "get Follow Person success", followInfos);
        } catch (Exception e) {
            return new ResponseData(false, "get Follow Person fail", null);
        }
    }

    private List<FollowInfo> renderFansInstitutions(List<FollowEntity> entities) {
        List<FollowInfo> followInfos = new ArrayList<FollowInfo>();
        for (FollowEntity followEntity : entities) {
            followInfos.add(renderFansInstitution(followEntity));
        }
        return followInfos;
    }

    private FollowInfo renderFansInstitution(FollowEntity followEntity) {
        InstitutionInfoEntity investorInfo;
        String investorName = null;
        Long userId, id;
        Byte level = null;
        FollowInfo followInfo;
        String mobilePhoto;
        id = followEntity.getId();
        userId = followEntity.getNoticeList();
        investorInfo = institutionInfoDao.findByUserId(userId);
        if (investorInfo == null) {
            return null;
        }
        level = investorInfo.getInstitutionLevel();
        investorName = investorInfo.getInstitutionName();
        mobilePhoto = investorInfo.getMobileLogo();
        followInfo = new FollowInfo(userId, investorName, (byte) UserType.INSTITUTION, level, id, mobilePhoto,"","","");
        return followInfo;
    }

    @Override
    public ResponseData modifyFollowGroup(Long id, Long groupId) {
        try {
            FollowEntity followEntity = followDao.findOne(id);
            followEntity.setGroupId(groupId);
            followDao.save(followEntity);
            return new ResponseData(true, "modify Follow Group success", null);
        } catch (Exception e) {
            return new ResponseData(false, "modify Follow Group fail", null);
        }
    }

    /**
     * 不同类型的数量
     *
     * @param userId
     * @param userType
     */
    @Override
    public ResponseData countFollowGroupByUserType(Long userId, Byte userType) {

        try {
            int number = followDao.countFollow(userId, userType);
            return new ResponseData(true, "get Follow Person success", number);
        } catch (Exception e) {
            return new ResponseData(false, "get Follow Person fail", 0);
        }
    }

    /**
     * 不同分组的数量
     *
     * @param userId
     * @param groupId
     */
    @Override
    public ResponseData countFollowGroupByGroupId(Long userId, Long groupId) {
        try {
            int number = followDao.countFollowByGroupAndUseId(userId, groupId);
            return new ResponseData(true, "get Follow Person success", number);
        } catch (Exception e) {
            return new ResponseData(false, "get Follow Person fail", 0);
        }
    }

    /**
     * 获取不同分组的关注
     *
     * @param userId
     * @param groupId
     * @return
     */
    @Override
    public ResponseData getAll(Long userId, Long groupId) {

        try {
            List<FollowEntity> followEntities = followDao.findByNoticeListAndGroupId(userId, groupId);
            List<FollowInfo> followInfos = renderMixedList(followEntities);
            return new ResponseData(true, "get Follow  success", followInfos);
        } catch (Exception e) {
            return new ResponseData(false, "get Follow  fail", 0);
        }
    }

    /**
     * 是否已经关注
     *
     * @param userId
     * @param followId
     * @return
     */
    @Override
    public ResponseData isFollow(Long userId, Long followId) {
        try {
            boolean flag = false;
            List<FollowEntity> followInfos = followDao.findByNoticeListAndFansList(userId, followId);
            if (followInfos.size() >0)
                flag = true;
            FollowedOrNotInfo followedOrNotInfo = new FollowedOrNotInfo(followId,flag);
            return new ResponseData(true, "get Follow  success", followedOrNotInfo);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseData(false, "get Follow  fail", 0);
        }
    }

    private List<FollowInfo> renderMixedList(List<FollowEntity> followEntities) {
        List<FollowInfo> follows = new ArrayList<>();
        for (FollowEntity followEntity : followEntities) {
            follows.add(renderMixed(followEntity));
        }
        return follows;
    }

    private FollowInfo renderMixed(FollowEntity followEntity) {
        Byte type = followEntity.getFansType();
        if (type == 2)
            return renderInstitution(followEntity);
        else
            return renderFollowPerson(followEntity);


    }


}

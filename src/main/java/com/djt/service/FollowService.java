package com.djt.service;

import com.djt.data.ResponseData;

/**
 * Created by Zhipeng on 2016/4/7.
 */
public interface FollowService {

    /**
     * 获取关注数量
     * @param userId
     * @param followType
     * @return
     */
    ResponseData countFollows(Long userId, Byte followType);
    /**
     * 获取粉丝数
     */
    ResponseData countFans(Long userId, Byte followType);

    /**
     * 添加关注
     * @param userId
     * @param followId
     * @return
     */
    ResponseData addFollow(Long userId, Byte userType, Long followPersonId, Byte followPersonType, Byte followType);
    /**
     * 删除关注
     * @param userId
     * @param followId
     * @param followType
     * @return
     */
    ResponseData deleteFollow(Long userId, Long followId, Byte followType);
    /**
     *
     * 获取关注的人
     * @param userId
     * @param followType
     * @return
     */
    ResponseData getAllFollowPerson(Long userId, Byte followType);
//    /**
//     * 获取关注的项目
//     * @param userId
//     * @return
//     */
//    ResponseData getAllFollowProject(Long userId);


    /**
     * 获取关注的机构
     * @param userId
     * @param followType
     * @return
     */
    ResponseData getAllFollowInstitution(Long userId, Byte followType);
    /**
     * 获取粉丝投资人
     * @param userId
     * @param followType
     * @return
     */
    ResponseData getAllFansPerson(Long userId, Byte followType);
//    /**
//     * 获取粉丝项目
//     * @param userId
//     * @return
//     */
//    ResponseData getAllFansProject(Long userId);
    /**
     * 获取粉丝机构
     * @param userId
     * @param followType
     * @return
     */
    ResponseData getAllFansInstitution(Long userId, Byte followType);

    /**
     * 修改关注组
     * @param id, groupId
     */
    ResponseData modifyFollowGroup(Long id, Long groupId);

    /**
     * 不同类型的数量
     */
    ResponseData countFollowGroupByUserType(Long userId, Byte userType);
    /**
     * 不同分组的数量
     */
    ResponseData countFollowGroupByGroupId(Long userId, Long groupId);

    /**
     * 获取不同分组的关注
     * @param userId
     * @param groupId
     * @return
     */
    ResponseData getAll(Long userId, Long groupId);

    /**
     * 是否已经关注
     * @param userId
     * @param followId
     * @param followType
     * @return
     */
    ResponseData isFollow(Long userId, Long followId, Byte followType);
}

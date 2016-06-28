package com.djt.service;

import com.djt.data.ResponseData;

/**
 * Created by Zhipeng on 2016/4/7.
 */
public interface FollowService {

    /**
     * 获取关注数量
     * @param userId
     * @return
     */
    ResponseData countFollows(Long userId);
    /**
     * 获取粉丝数
     */
    ResponseData countFans(Long userId);

    /**
     * 添加关注
     * @param userId
     * @param followId
     * @return
     */
    ResponseData addFollow(Long userId, Byte userType, Long followId, Byte followType);
    /**
     * 删除关注
     * @param userId
     * @param followId
     * @return
     */
    ResponseData deleteFollow(Long userId, Long followId);
    /**
     *
     * 获取关注的人
     * @param userId
     * @return
     */
    ResponseData getAllFollowPerson(Long userId);
//    /**
//     * 获取关注的项目
//     * @param userId
//     * @return
//     */
//    ResponseData getAllFollowProject(Long userId);


    /**
     * 获取关注的机构
     * @param userId
     * @return
     */
    ResponseData getAllFollowInstitution(Long userId);
    /**
     * 获取粉丝投资人
     * @param userId
     * @return
     */
    ResponseData getAllFansPerson(Long userId);
//    /**
//     * 获取粉丝项目
//     * @param userId
//     * @return
//     */
//    ResponseData getAllFansProject(Long userId);
    /**
     * 获取粉丝机构
     * @param userId
     * @return
     */
    ResponseData getAllFansInstitution(Long userId);

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
     * @return
     */
    ResponseData isFollow(Long userId, Long followId);
}

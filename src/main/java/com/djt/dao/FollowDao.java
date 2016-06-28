package com.djt.dao;


import com.djt.domain.FollowEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

/**
 * Created by Zhipeng on 2016/4/7.
 */
public interface FollowDao extends
        PagingAndSortingRepository<FollowEntity, Long> {

    @Query("select  count(f)  from FollowEntity f where f.fansList = ?1")
    Integer countFans(Long user_id);

    @Query("select  count(f)  from FollowEntity f where f.noticeList = ?1")
    Integer countFollow(Long user_id);

    @Query("select  count (f) from FollowEntity f where f.groupId = ?1 and f.noticeList = ?2")
    Integer countFollowByGroupAndUseId(Long groupId, Long userId);

    @Query("select  count(f)  from FollowEntity f where f.noticeList = ?1 and  f.fansType = ?2")
    Integer countFollow(Long user_id, Byte userType);

    /**
     * 获取关注列表
     * @param userId, userType
     * @return
     */
    List<FollowEntity> findByNoticeListAndFansType(Long userId, Byte userType);
    /**
     * 获取粉丝列表
     * @param userId, userType
     * @return
     */
    List<FollowEntity> findByFansListAndNoticeType(Long userId, Byte userType);

    List<FollowEntity> findByNoticeListAndFansList(Long userId, Long followId);

    /**
     * 通过分组获取
     */
    List<FollowEntity> findByNoticeListAndGroupId(Long userId, Long groupId);

}

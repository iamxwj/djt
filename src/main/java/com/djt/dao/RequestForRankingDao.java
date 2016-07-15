package com.djt.dao;

import com.djt.domain.RequestForRankingEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * @author Zhipeng
 * @date 2016/7/7.
 */
public interface RequestForRankingDao extends PagingAndSortingRepository<RequestForRankingEntity,Long> {
    @Query("select  count(f)  from RequestForRankingEntity f where f.userId = ?1")
    Integer countRankingList(Long userId);
}

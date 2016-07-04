package com.djt.dao;

import com.djt.domain.RequestCashEntity;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

/**
 * @author Zhipeng
 * @date 2016/6/15.
 */
public interface RequestedCashDao extends PagingAndSortingRepository<RequestCashEntity, Long> {
    List<RequestCashEntity> findByUserId(Long userId);
}

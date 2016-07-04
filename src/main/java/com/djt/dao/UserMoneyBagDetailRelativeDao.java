package com.djt.dao;

import com.djt.domain.UserMoneyBagDetailRelativeEntity;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

/**
 * Created by Zhipeng on 2016/5/13.
 */
public interface UserMoneyBagDetailRelativeDao extends PagingAndSortingRepository<UserMoneyBagDetailRelativeEntity,Long > {
    List<UserMoneyBagDetailRelativeEntity> findByRefId(Long refId);

}

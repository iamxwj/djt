/*
 * @(#)InstitutionMemberLevelDao.java, 2016/2/25.
 *
 * Copyright 2015 Alibaodu, Inc. All rights reserved.
 * ALIBAODU PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package com.djt.dao;

import com.djt.domain.InvestMemberLevelEntity;
import org.springframework.data.repository.CrudRepository;

/**
 * InvestMemberLevelDao
 *
 * @author chenbin
 * @date 2016/2/25
 */
public interface InvestMemberLevelDao extends CrudRepository<InvestMemberLevelEntity, Integer> {
}

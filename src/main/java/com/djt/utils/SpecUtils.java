/*
 * @(#)SpecificationUtils.java, 2015/11/12.
 *
 * Copyright 2015 Alibaodu, Inc. All rights reserved.
 * ALIBAODU PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package com.djt.utils;

import com.tzdr.data.condition.InvestSearchCondition;
import com.tzdr.data.condition.ProjectSearchCondition;
import com.tzdr.domain.*;
import org.apache.log4j.Logger;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.*;

/**
 * SpecificationUtils
 *
 * @author chenbin
 * @date 2015/11/12
 */
public class SpecUtils {
    private static Logger logger = Logger.getLogger(SpecUtils.class);
    /**
     * 构建过滤机构列表的查询条件
     * @param condition
     * @return
     */
    public static Specification<InstitutionInfoEntity> institutionListSpec(InvestSearchCondition condition) {
        logger.debug(condition.toString());
        return new Specification<InstitutionInfoEntity>() {
            @Override
            public Predicate toPredicate(Root<InstitutionInfoEntity> institution, CriteriaQuery<?> query, CriteriaBuilder cb) {
                query.distinct(true);

                ListJoin<InstitutionInfoEntity, InvestPhaseEntity> phase = institution.joinList("phaseEntityList", JoinType.INNER);
                ListJoin<InstitutionInfoEntity, InvestFieldEntity> field = institution.joinList("fieldEntityList", JoinType.INNER);

                Predicate criteria = cb.conjunction();

                if(condition.getLevel() != null && condition.getLevel() >= 1 && condition.getLevel() <= 7) {  // 机构评级
                    criteria = cb.and(criteria, cb.equal(institution.get("institutionLevel").as(Byte.class), condition.getLevel()));
                }
                if(condition.getInvestType() != null && condition.getInvestType() >= 1 && condition.getInvestType() <= 4) {  // 投资类型
                    criteria = cb.and(criteria, cb.equal(institution.get("investType").as(Byte.class), condition.getInvestType()));
                }
                if(condition.getPhaseId() != null && condition.getPhaseId() >= 1 && condition.getPhaseId() <= 4) {  // 投资阶段
                    criteria = cb.and(criteria, cb.equal(phase.get("phaseId").as(Byte.class), condition.getPhaseId()));
                }
                if(condition.getInvestFieldList() != null && condition.getInvestFieldList() != null && condition.getInvestFieldList().size() > 0) {  // 投资领域
                    //criteria = cb.and(criteria, field.get("fieldId").in(condition.getInvestFieldList()));
                    criteria = cb.and(criteria, field.get("fieldId").in(condition.getInvestFieldList()));
                }
                if(condition.getLocation() != null && condition.getLocation().trim().length() != 0) {  // 省份
                    criteria = cb.and(criteria, cb.equal(institution.get("province").as(String.class), condition.getLocation()));
                }
                return criteria;
            }
        };
    }

    /**
     * 构建投资人列表过滤条件
     * @param condition
     * @return
     */
    public static Specification<InvestorInfoEntity> investorListSpec(InvestSearchCondition condition) {
        return new Specification<InvestorInfoEntity>() {
            @Override
            public Predicate toPredicate(Root<InvestorInfoEntity> investor, CriteriaQuery<?> query, CriteriaBuilder cb) {
                query.distinct(true);

                ListJoin<InvestorInfoEntity, InvestPhaseEntity> phase = investor.joinList("phaseEntityList", JoinType.INNER);
                ListJoin<InvestorInfoEntity, InvestFieldEntity> field = investor.joinList("fieldEntityList", JoinType.INNER);

                Predicate criteria = cb.conjunction();

                if(condition.getLevel() != null && condition.getLevel() >= 1 && condition.getLevel() <= 7) {  // 投资人评级
                    criteria = cb.and(criteria, cb.equal(investor.get("investorLevel").as(Byte.class), condition.getLevel()));
                }
                if(condition.getInvestType() != null && condition.getInvestType() >= 1 && condition.getInvestType() <= 4) {  // 投资类型
                    criteria = cb.and(criteria, cb.equal(investor.get("investType").as(Byte.class), condition.getInvestType()));
                }
                if(condition.getLocation() != null && condition.getLocation().trim().length() != 0) {  // 省份
                    criteria = cb.and(criteria, cb.equal(investor.get("province").as(String.class), condition.getLocation()));
                }

                if(condition.getPhaseId() != null && condition.getPhaseId() >= 1 && condition.getPhaseId() <= 4) {  // 投资阶段
                    criteria = cb.and(criteria, cb.equal(phase.get("phaseId").as(Byte.class), condition.getPhaseId()));
                }
                if(condition.getInvestFieldList() != null && condition.getInvestFieldList() != null && condition.getInvestFieldList().size() > 0) {  // 投资领域
                    criteria = cb.and(criteria, field.get("fieldId").in(condition.getInvestFieldList()));
                    //criteria = cb.and(criteria, investor.get("fieldEntityList").get("fieldId").in(condition.getInvestFieldList()));
                }


                return criteria;
            }
        };
    }

    /**
     * 构建项目列表过滤条件
     * @param condition
     * @return
     */
    public static Specification<ProjectInfoEntity> projectListSpec(ProjectSearchCondition condition) {
        return new Specification<ProjectInfoEntity>() {
            @Override
            public Predicate toPredicate(Root<ProjectInfoEntity> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
                query.distinct(true);
                return null;
            }
        };
    }

}

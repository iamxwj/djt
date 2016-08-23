package com.djt.dao.specification;

import com.djt.domain.InstitutionInfoEntity;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

/**
 * @author Zhipeng
 * @date 2016/8/19.
 */
public class InstitutionSpecification implements Specification<InstitutionInfoEntity> {

    @Override
    public Predicate toPredicate(Root<InstitutionInfoEntity> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
        return null;
    }
}

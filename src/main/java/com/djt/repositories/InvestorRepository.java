package com.djt.repositories;

import com.djt.domain.es.InvestorDocument;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.repository.ElasticsearchCrudRepository;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

/**
 * @author Zhipeng
 * @date 2016/6/15.
 */
public interface InvestorRepository extends ElasticsearchRepository<InvestorDocument, Long> {
    public Page<InvestorDocument> findByInvestorNameAndInstitutionNameAndInvestorPosition(String investorName, String institutionName, String investorPosition, Pageable pageable);
}

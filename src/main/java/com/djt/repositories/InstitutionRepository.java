package com.djt.repositories;

import com.djt.domain.es.InstitutionDocument;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.List;

/**
 * @author Zhipeng
 * @date 2016/6/13.
 */
public interface InstitutionRepository extends ElasticsearchRepository<InstitutionDocument, Long> {
    Page<InstitutionDocument> findByInstitutionNameAndInstitutionMemberNames(String institutionName, String institutionMemberNames,Pageable pageable);
}

/*
 * @(#)InvestorInfoDaoTest.java, 2016/2/24.
 *
 * Copyright 2015 Alibaodu, Inc. All rights reserved.
 * ALIBAODU PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package dao;

import com.djt.dao.InstitutionInfoDao;
import com.djt.domain.es.InstitutionDocument;
import com.djt.domain.es.InvestorDocument;
import com.djt.repositories.InstitutionRepository;
import com.djt.repositories.InvestorRepository;
import com.djt.utils.EntityDocumentConvertor;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * InvestorInfoDaoTest
 *
 * @author chenbin
 * @date 2016/2/24
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring-context.xml")
public class InstitutionDocumentDaoTest {


    @Autowired
    private InstitutionRepository institutionRepository;

    @Autowired
    private InstitutionInfoDao institutionInfoDao;

    @Autowired
    private ElasticsearchTemplate template;

    //    @Test
//    public void testUpdate() {
//        InvestorInfoEntity entity = investorInfoDao.findByInvestorId(1000L);
//        System.out.println(entity);
//
//        entity.setInvestorName("沈南鹏");
//        entity.setInvestorId(2L);
//        investorInfoDao.save(entity);
//
//    }
    @Test
    public void testInsert() {
        template.deleteIndex(InstitutionDocument.class);
        template.createIndex(InstitutionDocument.class);
        institutionRepository.deleteAll();
        Iterable<InstitutionDocument> documents = EntityDocumentConvertor.renderInstitutions(institutionInfoDao.findAll());
        institutionRepository.save(documents);
        System.out.println(institutionRepository.findOne(300L));
//        UserInfoEntity userInfoEntity = userInfoDao.findByName("qinaichen");
//
//        InvestorInfoEntity investorInfoEntity = new InvestorInfoEntity();
//        investorInfoEntity.setUserInfoEntity(userInfoEntity);
//
//        investorInfoDao.save(investorInfoEntity);
    }


    @Test
    public void testFindBy() {
        Page<InstitutionDocument> institutionDocuments =
                institutionRepository.findByInstitutionNameAndInstitutionMemberNames("?", "?", new PageRequest(0, 10));

        for (InstitutionDocument institutionDocument : institutionDocuments) {
            System.out.println(institutionDocument);
        }
    }

    @Test
    public void testTemplate() {
    }
}

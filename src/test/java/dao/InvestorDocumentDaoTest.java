package dao;

import com.djt.dao.InvestorInfoDao;
import com.djt.domain.es.InstitutionDocument;
import com.djt.domain.es.InvestorDocument;
import com.djt.repositories.InvestorRepository;
import com.djt.utils.EntityDocumentConvertor;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author Zhipeng
 * @date 2016/6/21.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring-context.xml")
public class InvestorDocumentDaoTest {


    @Autowired
    private InvestorRepository investorRepository;

    @Autowired
    private ElasticsearchTemplate template;

    @Autowired
    private InvestorInfoDao investorInfoDao;

    @Test
    public void testInvestorDocument() {


        InvestorDocument investorDocument = new InvestorDocument(1L, "a", "a", "a");

        investorRepository.save(investorDocument);

        System.out.println(investorRepository.findOne(1L));
    }
    @Test
    public void testInsert() {
        template.deleteIndex(InvestorDocument.class);
        template.createIndex(InvestorDocument.class);
        investorRepository.deleteAll();
        Iterable<InvestorDocument> documents = EntityDocumentConvertor.renderInvestor(investorInfoDao.findAll());


        investorRepository.save(documents);
        System.out.println(investorRepository.findOne(300L));
//        UserInfoEntity userInfoEntity = userInfoDao.findByName("qinaichen");
//
//        InvestorInfoEntity investorInfoEntity = new InvestorInfoEntity();
//        investorInfoEntity.setUserInfoEntity(userInfoEntity);
//
//        investorInfoDao.save(investorInfoEntity);
    }
}

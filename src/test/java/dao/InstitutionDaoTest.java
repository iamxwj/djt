package dao;

import com.djt.dao.InstitutionInfoDao;
import com.djt.dao.InvestorInfoDao;
import com.djt.domain.InstitutionInfoEntity;
import com.djt.domain.InvestorInfoEntity;
import com.djt.domain.es.InstitutionDocument;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * @author Zhipeng
 * @date 2016/6/22.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring-context.xml")
public class InstitutionDaoTest {
    @Autowired
    private InstitutionInfoDao institutionInfoDao;
    @Autowired
    private InvestorInfoDao investorInfoDao;


    @Test
    public void testFindList(){
        Page<InstitutionInfoEntity> institutionInfoEntities = institutionInfoDao.findByFirstFieldsLike("%互联网%", new PageRequest(0,10));

        for(InstitutionInfoEntity institutionInfoEntity: institutionInfoEntities){
            System.out.println(institutionInfoEntity);
        }
    }

    @Test
    public void testFindInvestor(){
        Page<InvestorInfoEntity> institutionInfoEntities = investorInfoDao.findByLevelTypeAndFirstFieldsLike((byte)1,"%互联网%", new PageRequest(0,10));

        for(InvestorInfoEntity institutionInfoEntity: institutionInfoEntities){
            System.out.println(institutionInfoEntity);
        }
    }
}

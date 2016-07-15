package com.djt.service.impl;

import com.djt.dao.RequestForRankingDao;
import com.djt.data.ResponseData;
import com.djt.domain.RequestForRankingEntity;
import com.djt.domain.UserInfoEntity;
import com.djt.service.RequestForRankingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/**
 * @author Zhipeng
 * @date 2016/7/7.
 */
@Service
public class RequestForRankingServiceImpl implements RequestForRankingService {

    @Autowired
    private RequestForRankingDao requestForRankingDao;

    @Override
    public ResponseData rankingRequest(Long userId) {
        try {
            requestForRankingDao.save(new RequestForRankingEntity(userId));
            return new ResponseData(true, "添加成功", null);
        } catch (Exception e) {
//            e.printStackTrace();
//            logger.error(e.toString());
            return new ResponseData(false, "添加失败", null);
        }
    }

    @Override
    public ResponseData isRankingRequested(Long userId) {
        try {
            int i = requestForRankingDao.countRankingList(userId);
            if(i==0)
                return new ResponseData(true, "查询成功", false);
            else
                return new ResponseData(true,"查询成功", true);
        } catch (Exception e) {
//            e.printStackTrace();
//            logger.error(e.toString());
            return new ResponseData(false, "查询失败", null);
        }
    }
}

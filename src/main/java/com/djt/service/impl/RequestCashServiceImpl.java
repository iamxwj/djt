package com.djt.service.impl;

import com.djt.dao.RequestedCashDao;
import com.djt.dao.UserMoneyBagDao;
import com.djt.data.ResponseData;
import com.djt.domain.RequestCashEntity;
import com.djt.domain.UserMoneyBagEntity;
import com.djt.service.RequestCashService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Zhipeng
 * @date 2016/6/17.
 */
@Service
public class RequestCashServiceImpl implements RequestCashService {

    @Autowired
    private RequestedCashDao requestCashDao;

    @Autowired
    private UserMoneyBagDao moneyBagDao;

    @Override
    public ResponseData getRequestCash(Long user) {
        try {
            List<RequestCashEntity> requestList = requestCashDao.findByUserId(user);
            return new ResponseData(true, "历史记录", null);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseData(false, "获取失败", null);
        }
    }

    @Override
    public ResponseData add(RequestCashEntity requestCashEntity) {
        try {
            requestCashDao.save(requestCashEntity);
            decreaseAmountToBag(requestCashEntity.getUserId(),requestCashEntity.getAmount());
            return new ResponseData(true, "添加成功", null);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseData(false, "添加失败", null);
        }
    }

    private void decreaseAmountToBag(Long userId, int amount) {
        UserMoneyBagEntity bag = moneyBagDao.findByUserId(userId);
        long current = bag.getAmount();
        long result = current - amount;
        bag.setAmount(result);
        moneyBagDao.save(bag);
    }
}

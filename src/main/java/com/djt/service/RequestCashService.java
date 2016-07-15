package com.djt.service;

import com.djt.data.ResponseData;
import com.djt.domain.RequestCashEntity;

/**
 * @author Zhipeng
 * @date 2016/6/17.
 */
public interface RequestCashService {
    public ResponseData getRequestCash(Long user);

    public ResponseData add(RequestCashEntity requestCashEntity);
}

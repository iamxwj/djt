package com.djt.service;

import com.djt.data.ResponseData;

/**
 * @author Zhipeng
 * @date 2016/7/22.
 */
public interface SmsVerifyService {
    public ResponseData sendSms(Long phone);

    public ResponseData verifySms(Long smsId, int code, Long phone);
}

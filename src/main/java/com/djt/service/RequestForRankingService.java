package com.djt.service;

import com.djt.data.ResponseData;

/**
 * @author Zhipeng
 * @date 2016/7/7.
 */
public interface RequestForRankingService {
    public ResponseData rankingRequest(Long userId);

    public ResponseData isRankingRequested(Long userId);
}

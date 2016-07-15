package com.djt.controller;

import com.djt.data.ResponseData;
import com.djt.service.RequestForRankingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author Zhipeng
 * @date 2016/7/7.
 */
@Controller
@RequestMapping("/web/reqeust_ranking")
public class RequestForRankingController {

    @Autowired
    private RequestForRankingService requestForRankingServiceImpl;

    @RequestMapping("/add")
    @ResponseBody
    public ResponseData rankingRequest(@RequestParam("userId") Long userId){
            return requestForRankingServiceImpl.rankingRequest(userId);
    }

    @RequestMapping("/has")
    @ResponseBody
    public ResponseData isRankingRequested(@RequestParam("userId")Long userId){
        return requestForRankingServiceImpl.isRankingRequested(userId);
    }
}
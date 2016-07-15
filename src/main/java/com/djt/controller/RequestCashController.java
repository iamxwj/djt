package com.djt.controller;

import com.djt.data.ResponseData;
import com.djt.domain.RequestCashEntity;
import com.djt.service.RequestCashService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author Zhipeng
 * @date 2016/6/17.
 */
@Controller
@RequestMapping("/web/request_cash")
public class RequestCashController {


    @Autowired
    private RequestCashService cashService;
    @RequestMapping("/get")
    @ResponseBody
    public ResponseData getRequestCash(@RequestParam("userId") Long userId){
        return cashService.getRequestCash(userId);
    }
    @RequestMapping("/add")
    @ResponseBody
    public ResponseData add(@RequestBody RequestCashEntity requestCashEntity){
        return cashService.add(requestCashEntity);
    }
}

package com.djt.controller;

import com.djt.data.ResponseData;
import com.djt.service.FollowService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by Zhipeng on 2016/4/7.
 */
@Controller
@RequestMapping("/web/follow")
public class FollowController {
    Logger logger = Logger.getLogger(FollowController.class);
    @Autowired
    private FollowService followService;


    /**
     * 关注一个人
     *
     * @param userId, followId
     */
    @RequestMapping(value = "/follow_person", method = RequestMethod.GET)
    @ResponseBody
    public ResponseData followPerson(@RequestParam("userId") Long userId, @RequestParam("userType") Byte userType,
                                     @RequestParam("followId") Long followId, @RequestParam("followType") Byte followType) {
        return followService.addFollow(userId, userType, followId, followType);
    }

    /**
     * 取消关注一个人
     *
     * @param userId, followId
     */
    @RequestMapping(value = "/unfollow_person", method = RequestMethod.GET)
    @ResponseBody
    public ResponseData unfollowPerson(@RequestParam("userId") Long userId, @RequestParam("followId") Long followId) {
        return followService.deleteFollow(userId, followId);
    }

    /**
     * 粉丝的数量
     *
     * @param userId
     */
    @RequestMapping(value = "/count_fans", method = RequestMethod.GET)
    @ResponseBody
    public ResponseData countFans(@RequestParam("userId") Long userId) {
        return followService.countFans(userId);
    }


    /**
     * 关注的数量
     *
     * @param userId
     */
    @RequestMapping(value = "/count_follow", method = RequestMethod.GET)
    @ResponseBody
    public ResponseData countPerson(@RequestParam("userId") Long userId) {
        return followService.countFollows(userId);
    }

    /**
     * 获取关注人列表
     *
     * @param userId
     */
    @RequestMapping(value = "/get_follow", method = RequestMethod.GET)
    @ResponseBody
    public ResponseData getFollowList(@RequestParam("userId") Long userId) {
        return followService.getAllFollowPerson(userId);
    }

    /**
     * 获取关注机构列表
     *
     * @param userId
     */
    @RequestMapping(value = "/get_follow_institution", method = RequestMethod.GET)
    @ResponseBody
    public ResponseData getFollowInstitutionList(@RequestParam("userId") Long userId) {
        return followService.getAllFollowInstitution(userId);
    }

    /**
     * 获取粉丝人列表
     *
     * @param userId
     */
    @RequestMapping(value = "/get_fans", method = RequestMethod.GET)
    @ResponseBody
    public ResponseData getAllFansPerson(@RequestParam("userId") Long userId) {
        return followService.getAllFansPerson(userId);
    }


    /**
     * 获取粉丝机构列表
     *
     * @param userId
     */
    @RequestMapping(value = "/get_fans_institution", method = RequestMethod.GET)
    @ResponseBody
    public ResponseData getAllFansInstitution(@RequestParam("userId") Long userId) {
        return followService.getAllFansInstitution(userId);
    }

    /**
     * 是否已经关注
     */
    @RequestMapping(value = "/isfollow_person", method = RequestMethod.GET)
    @ResponseBody
    public ResponseData isfollowPerson(@RequestParam("userId") Long userId, @RequestParam("followId") Long followId) {
        return followService.isFollow(userId, followId);
    }
}

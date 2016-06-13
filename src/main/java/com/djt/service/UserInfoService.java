package com.djt.service;

import com.djt.data.ResponseData;
import com.djt.data.UserLoginInfo;
import com.djt.data.UserRegisterInfo;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.concurrent.ExecutionException;

/**
 * @author HOU Zhipeng
 * @date 2016/06/12
 */
public interface UserInfoService {

    /**
     * 设置会话数据
     * @param httpSession
     * @param username
     */
    public void setSessionData(HttpSession httpSession, String username) throws ExecutionException;

    /**
     * 设置Cookie
     * @param response
     */
    public void addCookies(HttpSession session, HttpServletResponse response);


    /**
     * 验证用户名密码
     * @return
     */
    public ResponseData validateUserPass(HttpServletRequest request, HttpServletResponse response, UserLoginInfo info);

    /**
     * 添加用户
     * @param form
     * @return
     */
    public ResponseData addUser(HttpServletRequest request, UserRegisterInfo form);


//    public boolean isUserLogin();
    /**
     * 用户是否存在
     * @param username
     * @return
     */
    public boolean existsUser(String username);


    /**
     * 手机号码是否存在
     * @param mobile
     * @return
     */
    public boolean existsMobile(String mobile);

    /**
     * 邮箱是否存在
     * @param email
     * @return
     */
    public boolean existsEmail(String email);

    /**
     * 修改密码
     */
    public ResponseData modifyPassword(UserLoginInfo userLoginInfo);

    /**
     * 修改email
     * @param userLoginInfo
     * @return
     */
    ResponseData modifyEmail(UserLoginInfo userLoginInfo);

    /**
     * 修改Phone
     * @param userLoginInfo
     * @return
     */
    ResponseData modifyPhone(UserLoginInfo userLoginInfo);
}

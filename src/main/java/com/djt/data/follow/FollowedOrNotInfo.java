package com.djt.data.follow;

/**
 * Created by Zhipeng on 2016/5/30.
 */
public class FollowedOrNotInfo {
    private Long userId;
    private boolean flag;

    public FollowedOrNotInfo() {
    }

    public FollowedOrNotInfo(Long userId, boolean flag) {
        this.userId = userId;
        this.flag = flag;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    @Override
    public String toString() {
        return "FollowedOrNotInfo{" +
                "userId=" + userId +
                ", flag=" + flag +
                '}';
    }
}

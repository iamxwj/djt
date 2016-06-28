package com.djt.data.follow;

/**
 * Created by Zhipeng on 2016/5/30.
 */
public class FollowFansCountInfo {
    private Long userId;
    private int count;

    public FollowFansCountInfo() {
    }

    public FollowFansCountInfo(Long userId, int count) {
        this.userId = userId;
        this.count = count;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}

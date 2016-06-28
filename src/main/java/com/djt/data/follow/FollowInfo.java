package com.djt.data.follow;

/**
 * Created by Zhipeng on 2016/4/8.
 */
public class FollowInfo {
    private Long userId;
    private String name;
    private byte   userType;
    private byte level;
    private Long id;
    private String mobilePhoto;
    private String investPosition;
    private String projectPhase;
    private String investInstiName;

    public FollowInfo(Long userId, String name, byte userType, byte level, Long id, String mobilePhoto,
                      String investPosition, String projectPhase, String investInstiName) {
        this.userId = userId;
        this.name = name;
        this.userType = userType;
        this.level = level;
        this.id = id;
        this.mobilePhoto = mobilePhoto;
        this.investPosition = investPosition;
        this.projectPhase = projectPhase;
        this.investInstiName = investInstiName;
    }

    public String getInvestInstiName() {
        return investInstiName;
    }

    public void setInvestInstiName(String investInstiName) {
        this.investInstiName = investInstiName;
    }

    public String getMobilePhoto() {
        return mobilePhoto;
    }

    public void setMobilePhoto(String mobilePhoto) {
        this.mobilePhoto = mobilePhoto;
    }

    public String getInvestPosition() {
        return investPosition;
    }

    public void setInvestPosition(String investPosition) {
        this.investPosition = investPosition;
    }

    public String getProjectPhase() {
        return projectPhase;
    }

    public void setProjectPhase(String projectPhase) {
        this.projectPhase = projectPhase;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public byte getUserType() {
        return userType;
    }

    public void setUserType(byte userType) {
        this.userType = userType;
    }

    public byte getLevel() {
        return level;
    }

    public void setLevel(byte level) {
        this.level = level;
    }

}

package com.djt.domain;

import javax.persistence.*;

/**
 * Created by Zhipeng on 2016/4/7.
 */
@Entity
@Table(name = "follow", schema = "", catalog = "djt")
public class FollowEntity {
    private Long id;
    private Long noticeList;
    private Long fansList;
    private Long groupId;
    private Byte noticeType;
    private Byte fansType;
    private Byte followType;

    public FollowEntity(Long noticeList, Long fansList, Byte noticeType, Byte fansType, Byte followType) {
        this.noticeList = noticeList;
        this.fansList = fansList;
        this.noticeType = noticeType;
        this.fansType = fansType;
        this.groupId = 0L;
        this.followType = followType;
    }

    public FollowEntity() {
    }

    @Basic
    @Column(name = "notice_type")
    public Byte getNoticeType() {

        return noticeType;
    }

    public void setNoticeType(Byte noticeType) {
        this.noticeType = noticeType;
    }

    @Basic
    @Column(name = "fans_type")
    public Byte getFansType() {
        return fansType;
    }

    public void setFansType(Byte fansType) {
        this.fansType = fansType;
    }

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "notice_list")
    public Long getNoticeList() {
        return noticeList;
    }

    public void setNoticeList(Long noticeList) {
        this.noticeList = noticeList;
    }

    @Basic
    @Column(name = "fans_list")
    public Long getFansList() {
        return fansList;
    }

    public void setFansList(Long fansList) {
        this.fansList = fansList;
    }

    @Basic
    @Column(name = "group_id")
    public Long getGroupId() {
        return groupId;
    }

    public void setGroupId(Long groupId) {
        this.groupId = groupId;
    }

    @Column(name = "follow_type")
    public Byte getFollowType() {
        return followType;
    }

    public void setFollowType(Byte followType) {
        this.followType = followType;
    }
}

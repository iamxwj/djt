/*
 * @(#)InstitutionMemberEntity.java, 2015/12/2.
 *
 * Copyright 2015 Alibaodu, Inc. All rights reserved.
 * ALIBAODU PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package com.djt.domain;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * InstitutionMemberEntity
 *
 * @author chenbin
 * @date 2015/12/2
 */
@Entity
@Table(name = "institution_member", schema = "", catalog = "djt")
public class InstitutionMemberEntity {
    private Long memberId;
    private String memberName;
    private byte memberLevel;
    private String memberPosition;
    private String memberPhoto;
    private Timestamp createTime;
    private Timestamp updateTime;

    @Id
    @Column(name = "member_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getMemberId() {
        return memberId;
    }

    public void setMemberId(Long memberId) {
        this.memberId = memberId;
    }

    private InstitutionInfoEntity institutionInfoEntity;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "institution_id")
    public InstitutionInfoEntity getInstitutionInfoEntity() {
        return institutionInfoEntity;
    }

    public void setInstitutionInfoEntity(InstitutionInfoEntity institutionInfoEntity) {
        this.institutionInfoEntity = institutionInfoEntity;
    }

    @Basic
    @Column(name = "member_name")
    public String getMemberName() {
        return memberName;
    }

    public void setMemberName(String memberName) {
        this.memberName = memberName;
    }

    @Basic
    @Column(name = "member_level")
    public byte getMemberLevel() {
        return memberLevel;
    }

    public void setMemberLevel(byte memberLevel) {
        this.memberLevel = memberLevel;
    }

    @Basic
    @Column(name = "member_position")
    public String getMemberPosition() {
        return memberPosition;
    }

    public void setMemberPosition(String memberPosition) {
        this.memberPosition = memberPosition;
    }

    @Basic
    @Column(name = "member_photo")
    public String getMemberPhoto() {
        return memberPhoto;
    }

    public void setMemberPhoto(String memberPhoto) {
        this.memberPhoto = memberPhoto;
    }

    @Basic
    @Column(name = "create_time")
    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }

    @Basic
    @Column(name = "update_time")
    public Timestamp getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Timestamp updateTime) {
        this.updateTime = updateTime;
    }
}

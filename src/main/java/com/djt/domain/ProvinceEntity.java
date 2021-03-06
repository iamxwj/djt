/*
 * @(#)ProvinceEntity.java, 2015/12/2.
 *
 * Copyright 2015 Alibaodu, Inc. All rights reserved.
 * ALIBAODU PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package com.djt.domain;

import javax.persistence.*;
import java.util.List;

/**
 * ProvinceEntity
 *
 * @author chenbin
 * @date 2015/12/2
 */
@Entity
@Table(name = "province", schema = "", catalog = "djt")
public class ProvinceEntity {
    private Integer provinceId;
    private String provinceName;
    private List<CityEntity> cityEntityList;

    @Id
    @Column(name = "province_id")
    public Integer getProvinceId() {
        return provinceId;
    }

    public void setProvinceId(Integer provinceId) {
        this.provinceId = provinceId;
    }

    @Basic
    @Column(name = "province_name")
    public String getProvinceName() {
        return provinceName;
    }

    public void setProvinceName(String provinceName) {
        this.provinceName = provinceName;
    }

    @OneToMany(mappedBy = "provinceEntity", fetch = FetchType.EAGER)
    public List<CityEntity> getCityEntityList() {
        return cityEntityList;
    }

    public void setCityEntityList(List<CityEntity> cityEntityList) {
        this.cityEntityList = cityEntityList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ProvinceEntity that = (ProvinceEntity) o;

        if (provinceId != null ? !provinceId.equals(that.provinceId) : that.provinceId != null) return false;
        if (provinceName != null ? !provinceName.equals(that.provinceName) : that.provinceName != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = provinceId != null ? provinceId.hashCode() : 0;
        result = 31 * result + (provinceName != null ? provinceName.hashCode() : 0);
        return result;
    }
}

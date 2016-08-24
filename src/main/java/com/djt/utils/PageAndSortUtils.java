/*
 * @(#)PageAndSortUtils.java, 2015/12/1.
 *
 * Copyright 2015 Alibaodu, Inc. All rights reserved.
 * ALIBAODU PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package com.djt.utils;

import com.djt.data.PageInfo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

/**
 * PageAndSortUtils
 *
 * @author chenbin
 * @date 2015/12/1
 */
public class PageAndSortUtils {
    /**
     * 构建按property降序的Sort对象
     * @param property
     * @return
     */
    public static Sort descSort(String property) {
        Sort sort = new Sort(Sort.Direction.DESC, property);
        return sort;
    }

    /**
     * 构建按property升序的Sort对象
     * @param property
     * @return
     */
    public static Sort ascSort(String property) {
        Sort sort = new Sort(Sort.Direction.ASC, property);
        return sort;
    }

    public static Pageable pageRequest(int pageIndex, int pageSize, Sort sort) {
        PageRequest pageRequest = new PageRequest(pageIndex, pageSize, sort);
        return pageRequest;
    }

    public static Pageable pageDescSortRequest(String property, int pageIndex, int pageSize) {
        Sort sort = descSort(property);
        return pageRequest(pageIndex, pageSize, sort);
    }

    public static Pageable pageAscSortRequest(String property, int pageIndex, int pageSize) {
        Sort sort = ascSort(property);
        return pageRequest(pageIndex, pageSize, sort);
    }

    public static <T> PageInfo<T>  getPageInfo(int curPage,int size,Page<T> page){
       return  new PageInfo<T>(curPage, size,page.getTotalPages(),page.getTotalElements(),page.getContent());

    }
    public static <T,E> PageInfo<E>  getPageInfo2(int curPage,int size,Page<T> page){
        return  new PageInfo<E>(curPage, size,page.getTotalPages(),page.getTotalElements());

    }
}

package com.djt.utils;

import org.apache.commons.beanutils.BeanUtils;

import java.util.Map;

/**
 * Created by Zhipeng on 2016/6/12.
 */
public class BeanToMapUtils {
    public static Map<String,String> describe(Object T){
        Map<String,String> map = null;
        try {
             map = BeanUtils.describe(T);
            map.remove("class");
        }catch (Exception e){
            e.printStackTrace();
        }
        return map;
    }
}

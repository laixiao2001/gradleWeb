package com.test.common;

import com.alibaba.fastjson.TypeReference;

/**
 * Created by liusven on 2016/10/26.
 */
public interface ITypeReference {
    /**
     * 根据url获取requestT的泛型实例
     * @param url
     * @return
     */
    public TypeReference getTypeReference(String url);
}

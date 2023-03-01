package com.crm.demo.service;

import com.alibaba.fastjson.JSONObject;

import java.util.List;
import java.util.Map;

public interface IndexService {
    /**
     * 根据用户名获取用户登录信息
     * @param userName
     * @return
     */
    Map<String,Object> getUserInfo(String userName);

    /**
     * 根据用户名获取动态菜单
     * @param userName
     * @return
     */
    List<JSONObject> getMenu(String userName);
}

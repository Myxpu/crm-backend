package com.crm.demo.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.crm.demo.pojo.entity.SysRole;
import com.crm.demo.pojo.entity.SysUser;
import com.crm.demo.service.IndexService;
import com.crm.demo.service.SysRightService;
import com.crm.demo.service.SysRoleService;
import com.crm.demo.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class IndexServiceImpl implements IndexService {
    @Autowired
    private SysUserService sysUserService;

    @Autowired
    private SysRoleService sysRoleService;

    @Autowired
    private SysRightService sysRightService;

    @Autowired
    private RedisTemplate redisTemplate;

    @Override
    public Map<String, Object> getUserInfo(String userName) {
        Map<String, Object> result = new HashMap<>();
        SysUser sysUser = sysUserService.selectByUsername(userName);
        if (null == sysUser) {

        }

        List<SysRole> roles = sysRoleService.selectRoleByUser(sysUser.getUsrId());
        List<String> roleNameList = roles.stream().map(item -> item.getRoleName()).collect(Collectors.toList());
        if (roleNameList.size() == 0) {
            roleNameList.add("");
        }

        //根据用户id获取操作权限值
        List<String> sysRightValueList = sysRightService.selectSysRightValueByUsrId(sysUser.getUsrId());
        redisTemplate.opsForValue().set(userName, sysRightValueList);

        result.put("name", sysUser.getUsrName());
        result.put("roles", roleNameList);
        result.put("sysRightValueList", sysRightValueList);
        return result;
    }

    @Override
    public List<JSONObject> getMenu(String userName) {
        SysUser sysUser = sysUserService.selectByUsername(userName);

        List<JSONObject> sysRightList = sysRightService.selectSysRightByUsrId(sysUser.getUsrId());

        return sysRightList;
    }
}

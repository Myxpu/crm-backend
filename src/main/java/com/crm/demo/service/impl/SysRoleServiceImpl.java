package com.crm.demo.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.crm.demo.pojo.entity.SysRole;
import com.crm.demo.mapper.SysRoleMapper;
import com.crm.demo.pojo.entity.SysUserRole;
import com.crm.demo.service.SysRoleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.crm.demo.service.SysUserRoleService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author qioes
 * @since 2021-04-24
 */
@Service
public class SysRoleServiceImpl extends ServiceImpl<SysRoleMapper, SysRole> implements SysRoleService {

    @Autowired
    private SysUserRoleService sysUserRoleService;

    @Override
    public Map<String, Object> findRoleByUsrId(String usrId) {
        //查询所有角色
        List<SysRole> allRoleList = baseMapper.selectList(null);

        //根据用户id，查询用户拥有的角色id
        List<SysUserRole> existUserRoleList = sysUserRoleService.list(new QueryWrapper<SysUserRole>().eq("user_id",usrId));

        List<String> existRoleList = existUserRoleList.stream().map(c->c.getRoleId()).collect(Collectors.toList());

        //对角色进行分类
        List<SysRole> assignRoles = new ArrayList<>();
        for(SysRole role :allRoleList){
            if (existRoleList.contains(role.getRoleId())){
                assignRoles.add(role);
            }
        }

        Map<String,Object> roleMap = new HashMap<>();
        roleMap.put("assignRoles",assignRoles);
        roleMap.put("allRolesList",allRoleList);
        return roleMap;
    }

    @Override
    public void saveUserRoleRealtionShip(String usrId, String[] roleIds) {
        sysUserRoleService.remove(new QueryWrapper<SysUserRole>().eq("user_id", usrId));

        List<SysUserRole> userRoleList = new ArrayList<>();
        for(String roleId : roleIds) {
            if(StringUtils.isEmpty(roleId)) continue;
            SysUserRole sysUserRole = new SysUserRole();
            sysUserRole.setUserId(usrId);
            sysUserRole.setRoleId(roleId);

            userRoleList.add(sysUserRole);
        }
        sysUserRoleService.saveBatch(userRoleList);
    }

    @Override
    public List<SysRole> selectRoleByUser(String usrId) {
        //根据用户id拥有的角色id
        List<SysUserRole> userRoleList = sysUserRoleService.list(new QueryWrapper<SysUserRole>().eq("user_id", usrId).select("role_id"));
        List<String> roleIdList = userRoleList.stream().map(item -> item.getRoleId()).collect(Collectors.toList());
        List<SysRole> roleList = new ArrayList<>();
        if(roleIdList.size() > 0) {
            roleList = baseMapper.selectBatchIds(roleIdList);
        }
        return roleList;
    }
}

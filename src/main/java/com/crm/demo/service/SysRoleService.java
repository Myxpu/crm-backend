package com.crm.demo.service;

import com.crm.demo.pojo.entity.SysRole;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;
import java.util.Map;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author qioes
 * @since 2021-04-24
 */
public interface SysRoleService extends IService<SysRole> {
    //根据用户获取角色数据
    Map<String,Object> findRoleByUsrId(String usrId);

    void saveUserRoleRealtionShip(String usrId,String[] roleId);

    List<SysRole> selectRoleByUser(String usrId);
}

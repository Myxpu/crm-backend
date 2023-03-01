package com.crm.demo.service;

import com.alibaba.fastjson.JSONObject;
import com.crm.demo.pojo.entity.SysRight;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author qioes
 * @since 2021-04-24
 */
public interface SysRightService extends IService<SysRight> {

    //获取全部菜单
    List<SysRight> queryAllMenu();

    //根据角色获取菜单
    List<SysRight> selectAllMenu(String roleId);

    //给角色分配权限
    void saveRoleSysRightRealtionShip(Long roleId, String[] rightCode);

    //递归删除菜单
    void removeChildById(String rightCode);

    //根据用户id获取用户菜单
    List<String> selectSysRightValueByUsrId(String usrId);

    List<JSONObject> selectSysRightByUsrId(String usrId);


}

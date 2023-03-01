package com.crm.demo.service;

import com.crm.demo.pojo.entity.SysUser;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author qioes
 * @since 2021-04-24
 */
public interface SysUserService extends IService<SysUser> {
    public SysUser selectByUsername(String usrName);
}

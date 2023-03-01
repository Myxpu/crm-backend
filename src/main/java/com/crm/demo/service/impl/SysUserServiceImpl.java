package com.crm.demo.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.crm.demo.pojo.entity.SysUser;
import com.crm.demo.mapper.SysUserMapper;
import com.crm.demo.service.SysUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author qioes
 * @since 2021-04-24
 */
@Service
public class SysUserServiceImpl extends ServiceImpl<SysUserMapper, SysUser> implements SysUserService {

    @Override
    public SysUser selectByUsername(String usrName) {
        return baseMapper.selectOne(new QueryWrapper<SysUser>().eq("usr_name",usrName));
    }
}

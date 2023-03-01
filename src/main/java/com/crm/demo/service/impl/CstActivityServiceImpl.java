package com.crm.demo.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.crm.demo.pojo.entity.CstActivity;
import com.crm.demo.mapper.CstActivityMapper;
import com.crm.demo.service.CstActivityService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author qioes
 * @since 2021-04-24
 */
@Service
public class CstActivityServiceImpl extends ServiceImpl<CstActivityMapper, CstActivity> implements CstActivityService {
    @Resource
    private CstActivityMapper cstActivityMapper;

    @Override
    public void pageQuery(Page<CstActivity> page, String custNo) {
        QueryWrapper<CstActivity> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("atv_cust_no", custNo);

        cstActivityMapper.selectPage(page, queryWrapper);
    }
}

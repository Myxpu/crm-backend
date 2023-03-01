package com.crm.demo.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.crm.demo.pojo.entity.CstLinkman;
import com.crm.demo.mapper.CstLinkmanMapper;
import com.crm.demo.service.CstLinkmanService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
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
public class CstLinkmanServiceImpl extends ServiceImpl<CstLinkmanMapper, CstLinkman> implements CstLinkmanService {
    @Resource
    private CstLinkmanMapper cstLinkmanMapper;

    @Override
    public void pageQuery(Page<CstLinkman> page, String custNo) {
        QueryWrapper<CstLinkman> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("lkm_cust_no", custNo);

        cstLinkmanMapper.selectPage(page, queryWrapper);
    }
}

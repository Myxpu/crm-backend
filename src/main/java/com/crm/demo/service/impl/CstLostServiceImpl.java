package com.crm.demo.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.crm.demo.pojo.entity.CstLost;
import com.crm.demo.mapper.CstLostMapper;
import com.crm.demo.pojo.query.CstLostQuery;
import com.crm.demo.service.CstLostService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

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
public class CstLostServiceImpl extends ServiceImpl<CstLostMapper, CstLost> implements CstLostService {
    @Resource
    private CstLostMapper cstLostMapper;

    @Override
    public void pageQuery(Page<CstLost> page, CstLostQuery query) {
        QueryWrapper<CstLost> queryWrapper = new QueryWrapper<>();

        if (query == null) {
            cstLostMapper.selectPage(page, queryWrapper);
            return;
        }

        String lstCustName = query.getLstCustName();
        String lstCustManagerName = query.getLstCustManagerName();
        String lstStatus = query.getLstStatus();

        if (!StringUtils.isEmpty(lstCustName)) {
            queryWrapper.like("lst_cust_name", lstCustName);
        }
        if (!StringUtils.isEmpty(lstCustManagerName)) {
            queryWrapper.like("lst_cust_manager_name", lstCustManagerName);
        }
        if (!StringUtils.isEmpty(lstStatus)) {
            queryWrapper.eq("lst_status", lstStatus);
        }


        cstLostMapper.selectPage(page, queryWrapper);
    }
}

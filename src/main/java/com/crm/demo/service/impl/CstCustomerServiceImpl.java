package com.crm.demo.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.crm.demo.pojo.entity.CstCustomer;
import com.crm.demo.mapper.CstCustomerMapper;
import com.crm.demo.pojo.query.CstCustomerQuery;
import com.crm.demo.service.CstCustomerService;
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
public class CstCustomerServiceImpl extends ServiceImpl<CstCustomerMapper, CstCustomer> implements CstCustomerService {
    @Resource
    private CstCustomerMapper cstCustomerMapper;
    @Override
    public void pageQuery(Page<CstCustomer> page, CstCustomerQuery query) {
        QueryWrapper<CstCustomer> queryWrapper = new QueryWrapper<>();

        if (query == null) {
            cstCustomerMapper.selectPage(page, queryWrapper);
            return;
        }

        String custName = query.getCustName();
        String custNo = query.getCustNo();
        String custRegion = query.getCustRegion();
        String custManagerName = query.getCustManagerName();
        String custLevelLabel = query.getCustLevelLabel();

        if (!StringUtils.isEmpty(custName)) {
            queryWrapper.like("cust_name", custName);
        }
        if (!StringUtils.isEmpty(custNo)) {
            queryWrapper.like("cust_no", custNo);
        }
        if (!StringUtils.isEmpty(custRegion)) {
            queryWrapper.eq("cust_region", custRegion);
        }
        if (!StringUtils.isEmpty(custManagerName)) {
            queryWrapper.like("cust_manager_name", custManagerName);
        }
        if (!StringUtils.isEmpty(custLevelLabel)) {
            queryWrapper.eq("cust_level_label", custLevelLabel);
        }


        cstCustomerMapper.selectPage(page, queryWrapper);
    }
}

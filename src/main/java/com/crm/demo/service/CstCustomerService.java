package com.crm.demo.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.crm.demo.pojo.entity.CstCustomer;
import com.baomidou.mybatisplus.extension.service.IService;
import com.crm.demo.pojo.query.CstCustomerQuery;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author qioes
 * @since 2021-04-24
 */
public interface CstCustomerService extends IService<CstCustomer> {
    public void pageQuery(Page<CstCustomer> page, CstCustomerQuery query);
}

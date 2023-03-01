package com.crm.demo.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.crm.demo.pojo.entity.CstLost;
import com.baomidou.mybatisplus.extension.service.IService;
import com.crm.demo.pojo.query.CstLostQuery;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author qioes
 * @since 2021-04-24
 */
public interface CstLostService extends IService<CstLost> {
    //查询流失记录
    public void pageQuery(Page<CstLost> page, CstLostQuery query);

}

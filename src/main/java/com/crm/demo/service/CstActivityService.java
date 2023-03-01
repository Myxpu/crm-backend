package com.crm.demo.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.crm.demo.pojo.entity.CstActivity;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author qioes
 * @since 2021-04-24
 */
public interface CstActivityService extends IService<CstActivity> {
    //查询交往记录
    public void pageQuery(Page<CstActivity> page, String custNo);
}

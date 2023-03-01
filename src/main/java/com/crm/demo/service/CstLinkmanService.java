package com.crm.demo.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.crm.demo.pojo.entity.CstLinkman;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author qioes
 * @since 2021-04-24
 */
public interface CstLinkmanService extends IService<CstLinkman> {
    public void pageQuery(Page<CstLinkman> page, String custNo);
}

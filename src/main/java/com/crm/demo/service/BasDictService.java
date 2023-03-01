package com.crm.demo.service;

import com.crm.demo.pojo.entity.BasDict;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author qioes
 * @since 2021-04-24
 */
public interface BasDictService extends IService<BasDict> {
    //查询基础数据下拉列表
    public List<BasDict> findByBasDict(String dictType);

}

package com.crm.demo.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.crm.demo.pojo.entity.BasDict;
import com.crm.demo.mapper.BasDictMapper;
import com.crm.demo.service.BasDictService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author qioes
 * @since 2021-04-24
 */
@Service
public class BasDictServiceImpl extends ServiceImpl<BasDictMapper, BasDict> implements BasDictService {
    @Resource
    private BasDictMapper basDictMapper;

    @Override
    public List<BasDict> findByBasDict(String dictType) {
        QueryWrapper<BasDict> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("dict_type",dictType);

        List<BasDict> basDicts = basDictMapper.selectList(queryWrapper);

        return basDicts;
    }
}

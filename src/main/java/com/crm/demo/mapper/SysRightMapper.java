package com.crm.demo.mapper;

import com.crm.demo.pojo.entity.SysRight;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author qioes
 * @since 2021-04-24
 */
public interface SysRightMapper extends BaseMapper<SysRight> {
    List<String> selectSysRightValueByUsrId(String usrId);

    List<String> selectAllSysRightValue();

    List<SysRight> selectSysRightByUsrId(String usrId);
}

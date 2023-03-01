package com.crm.demo.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.crm.demo.common.helper.MemuHelper;
import com.crm.demo.pojo.entity.SysRight;
import com.crm.demo.mapper.SysRightMapper;
import com.crm.demo.pojo.entity.SysRoleRight;
import com.crm.demo.pojo.entity.SysUser;
import com.crm.demo.service.SysRightService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.crm.demo.service.SysRoleRightService;
import com.crm.demo.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.crm.demo.common.helper.SysRightHelper;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author qioes
 * @since 2021-04-24
 */
@Service
public class SysRightServiceImpl extends ServiceImpl<SysRightMapper, SysRight> implements SysRightService {

    @Autowired
    private SysRoleRightService sysRoleRightService;

    @Autowired
    private SysUserService sysUserService;

    @Override
    public List<SysRight> queryAllMenu() {
        QueryWrapper<SysRight> wrapper = new QueryWrapper<>();
        wrapper.orderByDesc("right_code");
        List<SysRight> sysRightList = baseMapper.selectList(wrapper);

        List<SysRight> result = SysRightHelper.bulid(sysRightList);

        return result;
    }

    @Override
    public List<SysRight> selectAllMenu(String roleId) {
        List<SysRight> sysRightList = baseMapper.selectList(new QueryWrapper<SysRight>().orderByDesc("CAST(right_code AS SIGNED)"));

        //根据角色id获取角色权限
        List<SysRoleRight> roleRightList = sysRoleRightService.list(new QueryWrapper<SysRoleRight>().eq("rf_role_id",roleId));

        for (int i=0;i<sysRightList.size();i++){
            SysRight sysRight = sysRightList.get(i);
            for (int m=0;m<roleRightList.size();m++){
                SysRoleRight sysRoleRight = roleRightList.get(m);
                if(sysRoleRight.getRfRightCode().equals(sysRight.getRightCode())){
                    sysRight.setSelect(true);
                }
            }
        }
        List<SysRight> sysRightList1 = SysRightHelper.bulid(sysRightList);
        return sysRightList1;
    }

    @Override
    public void removeChildById(String rightCode) {
        List<String> idList = new ArrayList<>();
        this.selectChildListById(rightCode,idList);

        idList.add(rightCode);
        baseMapper.deleteBatchIds(idList);
    }

    @Override
    public List<String> selectSysRightValueByUsrId(String usrId) {
        List<String> selectSysRightValueList = null;
        if(this.isSysAdmin(usrId)){
            selectSysRightValueList = baseMapper.selectAllSysRightValue();
        }else{
            selectSysRightValueList = baseMapper.selectSysRightValueByUsrId(usrId);
        }
        return selectSysRightValueList;
    }

    @Override
    public List<JSONObject> selectSysRightByUsrId(String usrId) {
        List<SysRight> selectSysRightList = null;
        if(this.isSysAdmin(usrId)){
            selectSysRightList = baseMapper.selectList(null);
        }else{
            selectSysRightList = baseMapper.selectSysRightByUsrId(usrId);
        }
        List<SysRight> sysRightList = SysRightHelper.bulid(selectSysRightList);
        List<JSONObject> result = MemuHelper.bulid(sysRightList);
        return result;
    }

    /**
     * 判断用户是否系统管理员
     * @param userId
     * @return
     */
    private boolean isSysAdmin(String userId) {
        SysUser user = sysUserService.getById(userId);

        if(null != user && "admin".equals(user.getUsrName())) {
            return true;
        }
        return false;
    }

    //给角色分配权限
    @Override
    public void saveRoleSysRightRealtionShip(Long roleId, String[] rightCodes) {
        sysRoleRightService.remove(new QueryWrapper<SysRoleRight>().eq("rf_role_id",roleId));

        List<SysRoleRight> roleRightList = new ArrayList<>();
        for(String rightCode:rightCodes){
            if(StringUtils.isEmpty(rightCode))continue;

            SysRoleRight sysRoleRight = new SysRoleRight();
            sysRoleRight.setRfRoleId(roleId);
            sysRoleRight.setRfRightCode(rightCode);
            roleRightList.add(sysRoleRight);
        }
        sysRoleRightService.saveBatch(roleRightList);

    }

    /**
     * 递归获取子节点
     * @param rightCode
     * @param idList
     */
    private void selectChildListById(String rightCode, List<String> idList) {
        List<SysRight> childList = baseMapper.selectList(new QueryWrapper<SysRight>().eq("right_parent_code",rightCode).select("right_code"));
        childList.stream().forEach(item->{
            idList.add(item.getRightCode());
            this.selectChildListById(item.getRightCode(),idList);
        });
    }
}

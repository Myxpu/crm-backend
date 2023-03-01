package com.crm.demo.controller;


import com.crm.demo.common.result.Result;
import com.crm.demo.common.result.ResultCode;
import com.crm.demo.pojo.entity.SysRight;
import com.crm.demo.service.SysRightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author qioes
 * @since 2021-04-24
 */
@RestController
@RequestMapping("/sysRight")
@CrossOrigin
public class SysRightController {
    @Autowired
    private SysRightService sysRightService;

    //获取全部菜单
    @GetMapping
    public Result indexAllSysRight(){
        List<SysRight> list = sysRightService.queryAllMenu();
        return new Result(ResultCode.SUCCESS,list);
    }

    //递归删除菜单
    @DeleteMapping("remove/{rightCode}")
    public Result remove(@PathVariable String rightCode){
        sysRightService.removeChildById(rightCode);
        return new Result(ResultCode.SUCCESS);
    }

    //给角色分配权限
    @PostMapping("/doAssign")
    public Result doAssign(Long roleId,String[] rightCode){
        sysRightService.saveRoleSysRightRealtionShip(roleId,rightCode);

        return new Result(ResultCode.SUCCESS);
    }

    //根据角色获取菜单
    @GetMapping("{roleId}")
    public Result toAssign(
            @PathVariable String roleId
    ){
        List<SysRight> list = sysRightService.selectAllMenu(roleId);
        return new Result(ResultCode.SUCCESS,list);
    }

    //新增菜单
    @PostMapping("save")
    public Result save(@RequestBody SysRight sysRight){
        sysRightService.save(sysRight);
        return Result.SUCCESS();
    }

    //修改菜单
    @PutMapping("update")
    public Result updateById(
            @RequestBody SysRight sysRight
    ){
        sysRightService.updateById(sysRight);
        return Result.SUCCESS();
    }
}


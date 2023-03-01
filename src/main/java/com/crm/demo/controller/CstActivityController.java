package com.crm.demo.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.crm.demo.common.result.PageResult;
import com.crm.demo.common.result.Result;
import com.crm.demo.common.result.ResultCode;
import com.crm.demo.pojo.entity.CstActivity;
import com.crm.demo.service.CstActivityService;
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
@RequestMapping("/cstActivity")
@CrossOrigin
public class CstActivityController {
    @Autowired
    private CstActivityService cstActivityService;

    //查询交往记录
    @GetMapping("/{custNo}/{page}/{limit}")
    public Result findByActivity(
            @PathVariable String custNo,
            @PathVariable Long page,
            @PathVariable Long limit
    ) {
        Page<CstActivity> pageParam = new Page<>(page, limit);
        cstActivityService.pageQuery(pageParam, custNo);

        List<CstActivity> list = pageParam.getRecords();
        Long total = pageParam.getTotal();

        PageResult<CstActivity> pageResult = new PageResult<>();
        pageResult.setTotal(total);
        pageResult.setRows(list);

        return new Result(ResultCode.SUCCESS, pageResult);

    }

    //新建交往记录
    @PostMapping("/addActivity")
    public Result addActivity(
            @RequestBody CstActivity cstActivity
    ) {
        boolean result = cstActivityService.save(cstActivity);

        if (result) {
            return new Result(ResultCode.SUCCESS);
        } else {
            return new Result(ResultCode.FAIL);
        }
    }
    //查询交往记录信息
    @GetMapping("/{atvId}")
    public Result getActivity(
            @PathVariable Long atvId
    ){
        CstActivity cstActivity = cstActivityService.getById(atvId);
        return new Result(ResultCode.SUCCESS,cstActivity);
    }

    //修改交往记录
    @PutMapping("/updateActivity")
    public Result updateActivity(
            @RequestBody CstActivity cstActivity
    ) {
        boolean result = cstActivityService.updateById(cstActivity);

        if (result) {
            return new Result(ResultCode.SUCCESS);
        } else {
            return new Result(ResultCode.FAIL);
        }
    }

    //删除交往记录
    @DeleteMapping("/{atvId}")
    public Result delActivity(
            @PathVariable Long atvId
    ) {
        boolean result = cstActivityService.removeById(atvId);
        if (result ) {
            return new Result(ResultCode.SUCCESS);
        } else {
            return new Result(ResultCode.FAIL);
        }
    }


}


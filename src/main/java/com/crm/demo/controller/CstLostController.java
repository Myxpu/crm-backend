package com.crm.demo.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.crm.demo.common.result.PageResult;
import com.crm.demo.common.result.Result;
import com.crm.demo.common.result.ResultCode;
import com.crm.demo.pojo.entity.CstLost;
import com.crm.demo.pojo.query.CstLostQuery;
import com.crm.demo.service.CstLostService;
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
@RequestMapping("/cstLost")
@CrossOrigin
public class CstLostController {
    @Autowired
    private CstLostService cstLostService;

    //查询客户流失
    @PostMapping("/{page}/{limit}")
    public Result findByLost(
            @RequestBody CstLostQuery query,
            @PathVariable Long page,
            @PathVariable Long limit
    ) {
        Page<CstLost> pageParam = new Page<>(page, limit);
        cstLostService.pageQuery(pageParam, query);

        List<CstLost> list = pageParam.getRecords();
        Long total = pageParam.getTotal();

        PageResult<CstLost> pageResult = new PageResult<>();
        pageResult.setTotal(total);
        pageResult.setRows(list);

        return new Result(ResultCode.SUCCESS, pageResult);
    }

    //修改流失记录状态
    @PutMapping("updateLost")
    public Result updateLost(
            @RequestBody CstLost cstLost
    ) {
        boolean result = cstLostService.updateById(cstLost);

        if (result) {
            return new Result(ResultCode.SUCCESS);
        } else {
            return new Result(ResultCode.FAIL);
        }
    }

    //查询客户联系人详情
    @GetMapping("/{lstId}")
    public Result findByLostInfo(@PathVariable Long lstId) {
        CstLost cstLost = cstLostService.getOne(new QueryWrapper<CstLost>().eq("lst_id",lstId));

        return new Result(ResultCode.SUCCESS, cstLost);
    }

}


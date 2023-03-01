package com.crm.demo.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.crm.demo.common.result.PageResult;
import com.crm.demo.common.result.Result;
import com.crm.demo.common.result.ResultCode;
import com.crm.demo.pojo.entity.CstCustomer;
import com.crm.demo.pojo.query.CstCustomerQuery;
import com.crm.demo.service.CstCustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author qioes
 * @since 2021-04-24
 */
@RestController
@RequestMapping("/cstCustomer")
@CrossOrigin
public class CstCustomerController {

    @Autowired
    private CstCustomerService cstCustomerService;

    //分页查询客户
    @PostMapping("/{page}/{limit}")
    public Result findByCustomer(
            @PathVariable Long page,
            @PathVariable Long limit,
            @RequestBody CstCustomerQuery query
    ) {
        Page<CstCustomer> pageParam = new Page<>(page, limit);
        cstCustomerService.pageQuery(pageParam, query);

        List<CstCustomer> customers = pageParam.getRecords();
        Long total = pageParam.getTotal();
        PageResult<CstCustomer> pageResult = new PageResult<>();
        pageResult.setRows(customers);
        pageResult.setTotal(total);
        return new Result(ResultCode.SUCCESS, pageResult);
    }

    //通过客户编号查询
    @GetMapping("/{custNo}")
    public Result findByCustNo(@PathVariable String custNo) {
        CstCustomer cstCustomer = cstCustomerService.getOne(new QueryWrapper<CstCustomer>().eq("cust_no",custNo));
        return new Result(ResultCode.SUCCESS, cstCustomer);
    }

    //修改客户信息
    @PutMapping("/update")
    public Result updateByCustNo(@RequestBody CstCustomer cstCustomer) {
        boolean result = cstCustomerService.updateById(cstCustomer);
        if (result) {
            return new Result(ResultCode.SUCCESS);
        } else {
            return new Result(ResultCode.FAIL);
        }
    }

    //删除客户信息
    @DeleteMapping("/{custNo}")
    public Result delCustomer(
            @PathVariable String custNo
    ) {
        boolean result = cstCustomerService.removeById(custNo);
        if (result) {
            return new Result(ResultCode.SUCCESS);
        } else {
            return new Result(ResultCode.FAIL);
        }
    }
}


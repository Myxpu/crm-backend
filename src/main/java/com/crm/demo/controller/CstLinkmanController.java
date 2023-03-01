package com.crm.demo.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.crm.demo.common.result.PageResult;
import com.crm.demo.common.result.Result;
import com.crm.demo.common.result.ResultCode;
import com.crm.demo.pojo.entity.CstLinkman;
import com.crm.demo.service.CstLinkmanService;
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
@RequestMapping("/cstLinkman")
@CrossOrigin
public class CstLinkmanController {

    @Autowired
    private CstLinkmanService cstLinkmanService;

    //通过客户编号查询联系人列表
    @GetMapping("{custNo}/{page}/{limit}")
    public Result findByLinkman(
            @PathVariable String custNo,
            @PathVariable Long page,
            @PathVariable Long limit
    ) {
        Page<CstLinkman> pageParam = new Page<>(page, limit);
        cstLinkmanService.pageQuery(pageParam,custNo);

        List<CstLinkman> list = pageParam.getRecords();
        Long total = pageParam.getTotal();

        PageResult<CstLinkman> pageResult = new PageResult<>();
        pageResult.setTotal(total);
        pageResult.setRows(list);

        return new Result(ResultCode.SUCCESS, pageResult);

    }

    //查询客户联系人详情
    @GetMapping("/{lkmId}")
    public Result findByLinkInfo(@PathVariable Long lkmId) {
        CstLinkman cstLinkman = cstLinkmanService.getById(lkmId);

        return new Result(ResultCode.SUCCESS, cstLinkman);
    }

    //新建联系人
    @PostMapping("/addLinkman")
    public Result addLinkman(
            @RequestBody CstLinkman cstLinkman
    ) {
        boolean result = cstLinkmanService.save(cstLinkman);

        if (result) {
            return new Result(ResultCode.SUCCESS);
        } else {
            return new Result(ResultCode.FAIL);
        }
    }

    //修改联系人
    @PutMapping("/updateLinkman")
    public Result updateLinkman(
            @RequestBody CstLinkman cstLinkman
    ) {
        boolean result = cstLinkmanService.updateById(cstLinkman);

        if (result ) {
            return new Result(ResultCode.SUCCESS);
        } else {
            return new Result(ResultCode.FAIL);
        }
    }

    //删除联系人
    @DeleteMapping("/{lkmId}")
    public Result delLinkman(
            @PathVariable Long lkmId
    ) {
        boolean result = cstLinkmanService.removeById(lkmId);
        if (result) {
            return new Result(ResultCode.SUCCESS);
        } else {
            return new Result(ResultCode.FAIL);
        }
    }
}


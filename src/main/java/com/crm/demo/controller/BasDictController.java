package com.crm.demo.controller;


import com.crm.demo.common.result.Result;
import com.crm.demo.common.result.ResultCode;
import com.crm.demo.pojo.entity.BasDict;
import com.crm.demo.service.BasDictService;
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
@RequestMapping("/basDict")
@CrossOrigin
public class BasDictController {
    @Autowired
    private BasDictService basDictService;

    @GetMapping("/list/{dictType}")
    public Result findByBasDict(@PathVariable int dictType) {
        List<BasDict> basDicts = null;
        if (dictType == 1) {

            basDicts = basDictService.findByBasDict("地区");
        }
        if (dictType == 2) {
            basDicts = basDictService.findByBasDict("客户等级");
        }
        return new Result(ResultCode.SUCCESS, basDicts);
    }
}


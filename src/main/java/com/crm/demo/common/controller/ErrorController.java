package com.crm.demo.common.controller;


import com.crm.demo.common.result.Result;
import com.crm.demo.common.result.ResultCode;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class ErrorController {

    //公共错误跳转
    @RequestMapping(value="autherror")
    public Result autherror(int code) {
        return code ==1?new Result(ResultCode.UNAUTHENTICATED):new Result(ResultCode.UNAUTHORISE);
    }

}

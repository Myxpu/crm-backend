package com.crm.demo.pojo.query;

import lombok.Data;

import java.io.Serializable;

@Data
public class CstLostQuery implements Serializable {
    //客户名称
    private String lstCustName;

    //客户经理
    private String lstCustManagerName;

    //状态
    private String lstStatus;
}

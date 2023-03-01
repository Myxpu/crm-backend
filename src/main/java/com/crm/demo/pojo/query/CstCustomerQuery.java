package com.crm.demo.pojo.query;

import lombok.Data;

import java.io.Serializable;

@Data
public class CstCustomerQuery implements Serializable {
    private static final long serialVersionUID = 1L;

    //客户名称
    private String custName;
    //客户编号
    private String custNo;
    //地区
    private String custRegion;
    //客户经理/负责人
    private String custManagerName;
    //客户等级
    private String custLevelLabel;

}

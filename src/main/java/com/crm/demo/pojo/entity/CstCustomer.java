package com.crm.demo.pojo.entity;

import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 
 * </p>
 *
 * @author qioes
 * @since 2021-04-24
 */
@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="CstCustomer对象", description="")
public class CstCustomer implements Serializable {

    private static final long serialVersionUID = 1L;

    private String custNo;

    private String custName;

    private String custRegion;

    private Long custManagerId;

    private String custManagerName;

    private Integer custLevel;

    private String custLevelLabel;

    private Integer custSatisfy;

    private Integer custCredit;

    private String custAddr;

    private String custZip;

    private String custTel;

    private String custFax;

    private String custWebsite;

    private String custLicenceNo;

    private String custChieftain;

    private Long custBankroll;

    private Long custTurnover;

    private String custBank;

    private String custBankAccount;

    private String custLocalTaxNo;

    private String custNationalTaxNo;

    private String custStatus;


}

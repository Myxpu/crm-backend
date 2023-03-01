package com.crm.demo.pojo.entity;

import java.time.LocalDateTime;
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
@ApiModel(value="CstService对象", description="")
public class CstService implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long svrId;

    private String svrType;

    private String svrTitle;

    private String svrCustNo;

    private String svrCustName;

    private String svrStatus;

    private String svrRequest;

    private Long svrCreateId;

    private String svrCreateBy;

    private LocalDateTime svrCreateDate;

    private Long svrDueId;

    private String svrDueTo;

    private LocalDateTime svrDueDate;

    private String svrDeal;

    private Long svrDealId;

    private String svrDealBy;

    private LocalDateTime svrDealDate;

    private String svrResult;

    private Integer svrSatisfy;


}

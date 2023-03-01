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
@ApiModel(value="CstLost对象", description="")
public class CstLost implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long lstId;

    private String lstCustNo;

    private String lstCustName;

    private Long lstCustManagerId;

    private String lstCustManagerName;

    private LocalDateTime lstLastOrderDate;

    private LocalDateTime lstLostDate;

    private String lstDelay;

    private String lstReason;

    private String lstStatus;


}

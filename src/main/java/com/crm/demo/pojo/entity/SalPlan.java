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
@ApiModel(value="SalPlan对象", description="")
public class SalPlan implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long plaId;

    private Long plaChcId;

    private LocalDateTime plaDate;

    private String plaTodo;

    private String plaResult;


}

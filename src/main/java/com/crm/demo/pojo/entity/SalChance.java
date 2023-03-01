package com.crm.demo.pojo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.TableId;
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
@ApiModel(value="SalChance对象", description="")
public class SalChance implements Serializable {

    private static final long serialVersionUID = 1L;

      @TableId(value = "chc_id", type = IdType.AUTO)
    private Long chcId;

    private String chcSource;

    private String chcCustName;

    private String chcTitle;

    private Integer chcRate;

    private String chcLinkman;

    private String chcTel;

    private String chcDesc;

    private Long chcCreateId;

    private String chcCreateBy;

    private LocalDateTime chcCreateDate;

    private Long chcDueId;

    private String chcDueTo;

    private LocalDateTime chcDueDate;

    private String chcStatus;


}

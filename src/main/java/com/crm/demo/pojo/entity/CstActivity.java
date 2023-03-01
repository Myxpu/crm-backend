package com.crm.demo.pojo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
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
@ApiModel(value="CstActivity对象", description="")
public class CstActivity implements Serializable {

    private static final long serialVersionUID = 1L;

      @TableId(value = "atv_id", type = IdType.AUTO)
    private Long atvId;

    private String atvCustNo;

    private String atvCustName;

    private LocalDateTime atvDate;

    private String atvPlace;

    private String atvTitle;

    private String atvDesc;


}

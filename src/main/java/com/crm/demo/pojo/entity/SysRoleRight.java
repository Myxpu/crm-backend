package com.crm.demo.pojo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
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
@ApiModel(value="SysRoleRight对象", description="")
public class SysRoleRight implements Serializable {

    private static final long serialVersionUID = 1L;

      @TableId(value = "rf_id", type = IdType.AUTO)
    private Long rfId;

    private Long rfRoleId;

    private String rfRightCode;


}

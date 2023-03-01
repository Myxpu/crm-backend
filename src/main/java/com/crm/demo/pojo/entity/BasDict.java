package com.crm.demo.pojo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.web.bind.annotation.CrossOrigin;

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
@ApiModel(value="BasDict对象", description="")
public class BasDict implements Serializable {

    private static final long serialVersionUID = 1L;

      @TableId(value = "dict_id", type = IdType.AUTO)
    private Long dictId;

    private String dictType;

    private String dictItem;

    private String dictValue;

    private Integer dictIsEditable;


}

package com.example.spring.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * <p>
 * 
 * </p>
 *
 * @author jiajiao
 * @since 2022-11-13
 */
@Getter
@Setter
  @TableName("booking")
@ApiModel(value = "Booking对象", description = "")
public class Booking implements Serializable {

    private static final long serialVersionUID = 1L;

      @ApiModelProperty("预约单号")
        @TableId(value = "id", type = IdType.AUTO)
      private Integer id;

      @ApiModelProperty("家长")
      private String studentid;

      @ApiModelProperty("教员")
      private String teacherid;

      @ApiModelProperty("家长名称")
      private String studentname;

      @ApiModelProperty("教员名称")
      private String teachername;


}

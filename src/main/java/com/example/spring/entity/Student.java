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
 * @since 2022-11-09
 */
@Getter
@Setter
  @TableName("student")
@ApiModel(value = "Student对象", description = "")
public class Student implements Serializable {

    private static final long serialVersionUID = 1L;

      @ApiModelProperty("学员编号(唯一)")
        @TableId(value = "id", type = IdType.AUTO)
      private Integer id;

      @ApiModelProperty("名称")
      private String sname;

      @ApiModelProperty("账号")
      private String saccount;

      @ApiModelProperty("密码")
      private String spassword;

      @ApiModelProperty("性别")
      private String ssex;

      @ApiModelProperty("年级")
      private String sgrade;

      @ApiModelProperty("联系电话")
      private String sphone;

      @ApiModelProperty("补习科目")
      private String ssubject;

      @ApiModelProperty("时薪")
      private Integer sprice;

      @ApiModelProperty("地址")
      private String saddress;

      @ApiModelProperty("要求")
      private String srequest;

      @ApiModelProperty("头像")
      private String savatar;

      @ApiModelProperty("身份")
      private String siden;

}

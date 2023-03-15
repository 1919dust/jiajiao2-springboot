package com.example.spring.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor//创建无参构造
@AllArgsConstructor//创建有参构造
@TableName(value = "teacher")
public class Teacher {
    @TableId(type = IdType.AUTO)
    private Integer id;
    private String teachername;
    private String sex;
    private String phone;
    private String iden;
    private String account;
    //忽略字段，前端不展示密码
//    @JsonIgnore
    private String password;
    private String subject;
    private String wxnumber;
    private String price;
    private String school;
    private String address;
    private String personimg;
//    如果定义字段想与数据库的不一样
//    @TableField(value="数据库名")

}

package com.example.spring.controller.dto;
import lombok.Data;
/**
 * 接受前端登录请求的参数
 */
@Data
public class StudentDTO {
    private Integer id;
    private String account;
    private String password;
//    返回昵称\头像\身份
    private String sname;
    private String savatar;
    private String siden;

}

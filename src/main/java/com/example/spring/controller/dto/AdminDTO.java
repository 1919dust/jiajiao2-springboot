package com.example.spring.controller.dto;
import lombok.Data;
/**
 * 接受前端登录请求的参数
 */
@Data
public class AdminDTO {
    private String account;
    private String password;
    //    返回昵称和头像
    private String aname;
    private String aavatar;

}

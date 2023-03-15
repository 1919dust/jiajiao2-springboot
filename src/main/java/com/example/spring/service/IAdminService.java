package com.example.spring.service;

import com.example.spring.controller.dto.AdminDTO;
import com.example.spring.entity.Admin;
import com.baomidou.mybatisplus.extension.service.IService;


/**
 * <p>
 *  服务类
 * </p>
 *
 * @author jiajiao
 * @since 2022-11-09
 */
public interface IAdminService extends IService<Admin> {
    AdminDTO login(AdminDTO adminDTO);
}

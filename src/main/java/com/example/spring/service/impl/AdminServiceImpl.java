package com.example.spring.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.spring.common.Constants;
import com.example.spring.controller.dto.AdminDTO;
import com.example.spring.entity.Admin;
import com.example.spring.entity.Teacher;
import com.example.spring.exception.ServiceException;
import com.example.spring.mapper.AdminMapper;
import com.example.spring.service.IAdminService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author jiajiao
 * @since 2022-11-09
 */
@Service
public class AdminServiceImpl extends ServiceImpl<AdminMapper, Admin> implements IAdminService {
    @Override
    public AdminDTO login(AdminDTO adminDTO) {
        Admin one = getUserInfo(adminDTO);
        if (one != null) {
            BeanUtils.copyProperties(one, adminDTO, String.valueOf(true));
            return adminDTO;
        } else {
            throw new ServiceException(Constants.CODE_600, "用户名或密码错误");
        }
    }


    private Admin getUserInfo(AdminDTO adminDTO) {
        QueryWrapper<Admin> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("aaccount", adminDTO.getAccount());
//        queryWrapper.eq("password", adminDTO.getPassword());
        Admin one;
        try {
            one = getOne(queryWrapper); // 从数据库查询用户信息
        } catch (Exception e) {
//            LOG.error(e);
            throw new ServiceException(Constants.CODE_500, "系统错误");
        }
        return one;
    }
}

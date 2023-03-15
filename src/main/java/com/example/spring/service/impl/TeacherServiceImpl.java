package com.example.spring.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.spring.common.Constants;
import com.example.spring.controller.dto.TeacherDTO;
import com.example.spring.entity.Student;
import com.example.spring.entity.Teacher;
import com.example.spring.exception.ServiceException;
import com.example.spring.mapper.TeacherMapper;
import com.example.spring.service.ITeacherService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Service
public class TeacherServiceImpl extends ServiceImpl<TeacherMapper, Teacher> implements ITeacherService {
    @Override
    public TeacherDTO login(TeacherDTO teacherDTO) {
        Teacher one = getUserInfo(teacherDTO);
        if (one != null) {
            BeanUtils.copyProperties(one, teacherDTO, String.valueOf(true));
            return teacherDTO;
        } else {
            throw new ServiceException(Constants.CODE_600, "用户名或密码错误");
        }
    }

    @Override
    public boolean saveTeacher(Teacher teacher) {
        return saveOrUpdate(teacher);
    }

    @Override
    public Teacher register(TeacherDTO teacherDTO) {
        Teacher one = getUserInfo(teacherDTO);
        if (one == null) {
            one = new Teacher();
            BeanUtils.copyProperties(teacherDTO, one, String.valueOf(true));
            save(one);  // 把 copy完之后的用户对象存储到数据库
        } else {
            throw new ServiceException(Constants.CODE_600, "用户已存在");
        }
        return one;
    }

    private Teacher getUserInfo(TeacherDTO teacherDTO) {
        QueryWrapper<Teacher> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("account", teacherDTO.getAccount());
//        queryWrapper.eq("password", teacherDTO.getPassword());
        Teacher one;
        try {
            one = getOne(queryWrapper); // 从数据库查询用户信息
        } catch (Exception e) {
//            LOG.error(e);
            throw new ServiceException(Constants.CODE_500, "系统错误");
        }
        return one;
    }
}

package com.example.spring.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.spring.controller.dto.TeacherDTO;
import com.example.spring.entity.Teacher;
import com.example.spring.mapper.TeacherMapper;
import org.springframework.stereotype.Service;


public interface ITeacherService extends IService<Teacher> {
    TeacherDTO login(TeacherDTO teacherDTO);
    boolean saveTeacher(Teacher teacher);
    Teacher register(TeacherDTO teacherDTO);

}

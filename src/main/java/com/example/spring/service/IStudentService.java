package com.example.spring.service;

import com.example.spring.controller.dto.StudentDTO;
import com.example.spring.entity.Student;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author jiajiao
 * @since 2022-11-09
 */
public interface IStudentService extends IService<Student> {

    StudentDTO login(StudentDTO studentDTO);

    boolean saveTeacher(Student student);

    Object register(StudentDTO studentDTO);
}

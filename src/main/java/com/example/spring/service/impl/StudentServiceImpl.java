package com.example.spring.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.spring.common.Constants;
import com.example.spring.controller.dto.StudentDTO;
import com.example.spring.entity.Student;
import com.example.spring.entity.Teacher;
import com.example.spring.exception.ServiceException;
import com.example.spring.mapper.StudentMapper;
import com.example.spring.service.IStudentService;
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
public class StudentServiceImpl extends ServiceImpl<StudentMapper, Student> implements IStudentService {
    @Override
    public StudentDTO login(StudentDTO studentDTO) {
        Student one = getUserInfo(studentDTO);
        if (one != null) {
            BeanUtils.copyProperties(one, studentDTO, String.valueOf(true));
            return studentDTO;
        } else {
            throw new ServiceException(Constants.CODE_600, "用户名或密码错误");
        }
    }

    @Override
    public boolean saveTeacher(Student student) {
        return saveOrUpdate(student);
    }

    @Override
    public Student register(StudentDTO studentDTO) {
        Student one = getUserInfo(studentDTO);
        if (one == null) {
            one = new Student();
            BeanUtils.copyProperties(studentDTO, one, String.valueOf(true));
            save(one);  // 把 copy完之后的用户对象存储到数据库
        } else {
            throw new ServiceException(Constants.CODE_600, "用户已存在");
        }
        return one;
    }

    private Student getUserInfo(StudentDTO studentDTO) {
        QueryWrapper<Student> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("saccount", studentDTO.getAccount());
//        queryWrapper.eq("spassword", studentDTO.getPassword());
        Student one;
        try {
            one = getOne(queryWrapper); // 从数据库查询用户信息
        } catch (Exception e) {
//            LOG.error(e);
            throw new ServiceException(Constants.CODE_500, "系统错误");
        }
        return one;
    }
}

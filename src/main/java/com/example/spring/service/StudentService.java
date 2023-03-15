package com.example.spring.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.spring.controller.dto.StudentDTO;
import com.example.spring.entity.Student;
import com.example.spring.mapper.StudentMapper;
import org.springframework.stereotype.Service;

@Service
public class StudentService extends ServiceImpl<StudentMapper, Student> {

    public boolean saveStudent(Student student) {
        return saveOrUpdate(student);
    }
    //    实现对数据库的新增
//    @Autowired
//    private UserMapper userMapper;
//    public int save(User user){
//        if(user.getId()==null){//无id为新增，有为修改
//            return userMapper.insert(user);
//        }else{
//            return userMapper.update(user);
//        }
//    }
}
package com.example.spring.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.spring.common.Constants;
import com.example.spring.common.Result;
import com.example.spring.controller.dto.TeacherDTO;
import com.example.spring.entity.Teacher;
import com.example.spring.service.ITeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/teacher")
public class TeacherController {

    @Autowired
    private ITeacherService iteacherService;

    @PostMapping
    public boolean save(@RequestBody Teacher teacher){
//        新增或者更新
        return iteacherService.saveTeacher(teacher);
    }
//查询所有数据
    @GetMapping
    public List<Teacher> index(){
        return iteacherService.list();
    }
//删除
    @DeleteMapping("/{id}")
    public boolean delete(@PathVariable Integer id){
        return iteacherService.removeById(id);
    }

//    批量删除
    @PostMapping("/del/batch")
    public boolean deleteBatch(@RequestBody List<Integer> ids){
        return iteacherService.removeByIds(ids);
    }

//    分页查询-mybatis
//    接口路径：/usr/page
//    @RequestParam接收 ？pageNum=1&pageSize=10
//    @GetMapping("/page")
//    public Map<String ,Object> findPage(@RequestParam Integer pageNum, @RequestParam Integer pageSize){
//        pageNum = (pageNum-1)*pageSize;
//        List<User> data = userMapper.selectPage(pageNum,pageSize);
//        //查询总条数并封装
//        Integer total = userMapper.selectTotal();
//        Map<String ,Object> res = new HashMap<>();
//        res.put("data",data);
//        res.put("total",total);
//        return res;
//    }

//    分页查询-mybatis-plus
    @GetMapping("/page")
    public IPage<Teacher> findPage(@RequestParam Integer pageNum,
                                   @RequestParam Integer pageSize,
                                   @RequestParam(defaultValue = "") String id,
                                   @RequestParam(defaultValue = "") String teachername,
                                   @RequestParam(defaultValue = "") String sex,
                                   @RequestParam(defaultValue = "") String subject,
                                   @RequestParam(defaultValue = "") String iden
                                ){
        IPage<Teacher> page = new Page<>(pageNum,pageSize);
        QueryWrapper<Teacher> queryWrapper = new QueryWrapper<>();

//        模糊查询多条件
//        queryWrapper.like(Strings.isEmpty(teachername),"teachername",teachername);
//        queryWrapper.like(Strings.isEmpty(sex),"sex",sex);
//        queryWrapper.like(Strings.isEmpty(id),"id",id);
//        queryWrapper.like(Strings.isEmpty(subject),"subject",subject);

        if (!"".equals(id)){
            queryWrapper.like("id",id);
        }
        if (!"".equals(teachername)){
            queryWrapper.like("teacherName",teachername);
        }
        if (!"".equals(sex)){
            queryWrapper.like("sex",sex);
        }
        if (!"".equals(subject)){
            queryWrapper.like("subject",subject);
        }
        if (!"".equals(iden)){
            queryWrapper.like("iden",iden);
        }
        queryWrapper.orderByDesc("id");
        return iteacherService.page(page,queryWrapper);
    }
    //登录
    @PostMapping("/login")
    public Result login(@RequestBody TeacherDTO teacherDTO) {
        String account = teacherDTO.getAccount();
        String password = teacherDTO.getPassword();
        if (StringUtils.isBlank(account) || StringUtils.isBlank(password)) {
            return Result.error(Constants.CODE_400,"参数错误");
        }
        TeacherDTO dto = iteacherService.login(teacherDTO);
        return Result.success(dto);
    }

    //        注册
    @PostMapping("/register")
    public Result register(@RequestBody TeacherDTO teacherDTO) {
        String account = teacherDTO.getAccount();
        String password = teacherDTO.getPassword();
        if (StringUtils.isBlank(account) || StringUtils.isBlank(password)) {
            return Result.error(Constants.CODE_400,"参数错误");
        }
        return Result.success(iteacherService.register(teacherDTO));
    }
}

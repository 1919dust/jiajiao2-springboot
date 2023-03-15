package com.example.spring.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.spring.common.Constants;
import com.example.spring.common.Result;
import com.example.spring.controller.dto.StudentDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.spring.service.IStudentService;
import com.example.spring.entity.Student;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author jiajiao
 * @since 2022-11-09
 */
@RestController
@RequestMapping("/student")
        public class StudentController {

        @Autowired
private IStudentService studentService;

// 新增或者更新
@PostMapping
public boolean save(@RequestBody Student student) {
        return studentService.saveOrUpdate(student);
        }

@DeleteMapping("/{id}")
public Boolean delete(@PathVariable Integer id) {
        return studentService.removeById(id);
        }

@PostMapping("/del/batch")
public boolean deleteBatch(@RequestBody List<Integer> ids) {
        return studentService.removeByIds(ids);
        }

@GetMapping
public List<Student> findAll() {
        return studentService.list();
        }

@GetMapping("/{id}")
public Student findOne(@PathVariable Integer id) {
        return studentService.getById(id);
        }

        @GetMapping("/page")
        public IPage<Student> findPage(@RequestParam Integer pageNum,
                                       @RequestParam Integer pageSize,
                                       @RequestParam(defaultValue = "") String id,
                                       @RequestParam(defaultValue = "") String sname,
                                       @RequestParam(defaultValue = "") String ssex,
                                       @RequestParam(defaultValue = "") String ssubject,
                                       @RequestParam(defaultValue = "") String sgrade
        ){
                IPage<Student> page = new Page<>(pageNum,pageSize);
                QueryWrapper<Student> queryWrapper = new QueryWrapper<>();

//        模糊查询多条件
//        queryWrapper.like(Strings.isEmpty(teachername),"teachername",teachername);
//        queryWrapper.like(Strings.isEmpty(sex),"sex",sex);
//        queryWrapper.like(Strings.isEmpty(id),"id",id);
//        queryWrapper.like(Strings.isEmpty(subject),"subject",subject);

                if (!"".equals(id)){
                        queryWrapper.like("id",id);
                }
                if (!"".equals(sname)){
                        queryWrapper.like("sname",sname);
                }
                if (!"".equals(ssex)){
                        queryWrapper.like("ssex",ssex);
                }
                if (!"".equals(ssubject)){
                        queryWrapper.like("ssubject",ssubject);
                }
                if (!"".equals( sgrade)){
                        queryWrapper.like("sgrade",sgrade);
                }
                queryWrapper.orderByDesc("id");
                return studentService.page(page,queryWrapper);
        }
        //登录
        @PostMapping("/login")
        public Result login(@RequestBody StudentDTO studentDTO) {
                String account = studentDTO.getAccount();
                String password = studentDTO.getPassword();
                if (StringUtils.isBlank(account) || StringUtils.isBlank(password)) {
                        return Result.error(Constants.CODE_400,"参数错误");
                }
                StudentDTO dto = studentService.login(studentDTO);
                return Result.success(dto);
        }

        //        注册
        @PostMapping("/register")
        public Result register(@RequestBody StudentDTO studentDTO) {
                String account = studentDTO.getAccount();
                String password = studentDTO.getPassword();
                if (StringUtils.isBlank(account) || StringUtils.isBlank(password)) {
                        return Result.error(Constants.CODE_400,"参数错误");
                }
                return Result.success(studentService.register(studentDTO));
        }

}


package com.example.spring.controller;

import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.example.spring.common.Constants;
import com.example.spring.common.Result;
import com.example.spring.controller.dto.AdminDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.spring.service.IAdminService;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author jiajiao
 * @since 2022-11-09
 */
@RestController
@RequestMapping("/admin")
        public class AdminController {

        @Autowired
        private IAdminService adminService;

//        // 新增或者更新
//        @PostMapping
//        public boolean save(@RequestBody Admin admin) {
//                return adminService.saveOrUpdate(admin);
//        }
//
//        @DeleteMapping("/{id}")
//        public Boolean delete(@PathVariable Integer id) {
//                return adminService.removeById(id);
//        }
//
//        @PostMapping("/del/batch")
//        public boolean deleteBatch(@RequestBody List<Integer> ids) {
//                return adminService.removeByIds(ids);
//        }
//
//        @GetMapping
//        public List<Admin> findAll() {
//                return adminService.list();
//        }
//
//        @GetMapping("/{id}")
//        public Admin findOne(@PathVariable Integer id) {
//                return adminService.getById(id);
//        }

        //登录
        @PostMapping("/login")
        public Result login(@RequestBody AdminDTO adminDTO) {
                String account = adminDTO.getAccount();
                String password = adminDTO.getPassword();
                if (StringUtils.isBlank(account) || StringUtils.isBlank(password)) {
                        return Result.error(Constants.CODE_400," 参数错误");
                }
                AdminDTO dto = adminService.login(adminDTO);
                return Result.success(dto);
        }

}
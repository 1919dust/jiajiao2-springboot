package com.example.spring.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;
import java.util.List;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;

import com.example.spring.service.IBookingService;
import com.example.spring.entity.Booking;


/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author jiajiao
 * @since 2022-11-13
 */
@RestController
@RequestMapping("/booking")
        public class BookingController {

        @Autowired
private IBookingService bookingService;

// 新增或者更新
@PostMapping
public boolean save(@RequestBody Booking booking) {
        return bookingService.saveOrUpdate(booking);
        }

@DeleteMapping("/{id}")
public Boolean delete(@PathVariable Integer id) {
        return bookingService.removeById(id);
        }

@PostMapping("/del/batch")
public boolean deleteBatch(@RequestBody List<Integer> ids) {
        return bookingService.removeByIds(ids);
        }

@GetMapping
public List<Booking> findAll() {
        return bookingService.list();
        }

@GetMapping("/{id}")
public Booking findOne(@PathVariable Integer id) {
        return bookingService.getById(id);
        }
@GetMapping("/page")
public IPage<Booking> findPage(@RequestParam Integer pageNum,
                               @RequestParam Integer pageSize,
                               @RequestParam(defaultValue = "") String id,
                               @RequestParam(defaultValue = "") String studentid,
                               @RequestParam(defaultValue = "") String studentname,
                               @RequestParam(defaultValue = "") String teacherid,
                               @RequestParam(defaultValue = "") String teachername
){
        IPage<Booking> page = new Page<>(pageNum,pageSize);
        QueryWrapper<Booking> queryWrapper = new QueryWrapper<>();

        if (!"".equals(id)){
                queryWrapper.like("id",id);
        }
        if (!"".equals(studentid)){
                queryWrapper.like("studentid",studentid);
        }
        if (!"".equals(studentname)){
                queryWrapper.like("studentname",studentname);
        }
        if (!"".equals(teacherid)){
                queryWrapper.like("teacherid",teacherid);
        }
        if (!"".equals(teachername)){
                queryWrapper.like("teachername",teachername);
        }
        queryWrapper.orderByDesc("id");
        return bookingService.page(page,queryWrapper);
}
        }


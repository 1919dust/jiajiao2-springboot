package com.example.spring.service.impl;

import com.example.spring.entity.Booking;
import com.example.spring.mapper.BookingMapper;
import com.example.spring.service.IBookingService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author jiajiao
 * @since 2022-11-13
 */
@Service
public class BookingServiceImpl extends ServiceImpl<BookingMapper, Booking> implements IBookingService {

}

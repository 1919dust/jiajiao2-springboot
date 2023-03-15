package com.example.spring.mapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.spring.entity.Teacher;
//接口增删改查

public interface TeacherMapper extends BaseMapper<Teacher> {

//    @Select("select * from t_teacher")
//    List<User> findAll();
//
//    //插入动态数据
//    @Insert("insert into t_teacher(teachername,password,phone,wxnumber,subject,price,school,address,provice) " +
//            "values(#{teachername},#{password}),#{phone}),#{wxnumber}),#{subject}),#{price}),#{school}),#{address}),#{provice})")
//    int insert(User user);
//
////    更新数据
////    @Update("update t_teacher set teachername = #{teachername},phone = #{phone},wxnumber = #{wxnumber},subject = #{subject},price = #{price}
////    ,school = #{school},address = #{address},provice = #{provice}where id = #{id}")
//    int update(User user);
//
//    @Delete("delete from t_teacher where id = #{id}")
//    Integer deleteById(@Param("id") Integer id);
//
//    @Select("select * from t_teacher limit #{pageNum}, #{pageSize}")
//    List<User> selectPage(Integer pageNum, Integer pageSize);
//
//    @Select("select count(*) from t_teacher")
//    Integer selectTotal();
}

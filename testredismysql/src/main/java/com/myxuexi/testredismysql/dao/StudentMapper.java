package com.myxuexi.testredismysql.dao;

import com.myxuexi.testredismysql.model.Student;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Mapper
@Repository
public interface StudentMapper {
    @Select("Select * from student")
    List<Student> selectAll();

    @Select("select * from student where numbercode = #{numberCode}")
    Student getStudent(@Param("numberCode") String numberCode);
    @Delete("delete from student where numbercode = #{numberCode}")
    int delete(@Param("numberCode") String numberCode);

//    int update(Student student);
//
//    int insert(Student student);


}

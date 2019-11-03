package com.myxuexi.testredismysql.controller;

import com.google.gson.Gson;
import com.myxuexi.testredismysql.model.Student;
import com.myxuexi.testredismysql.service.StudentService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

@RestController
@RequestMapping(path = "/student")
public class StudentController {
    private  static volatile  Map<String,Boolean> maoshamap =new  HashMap<String, Boolean>();

    public static AtomicInteger counta = new AtomicInteger(0);
    public static AtomicInteger jsd = new AtomicInteger(0);
    public static  int count=0;

    @Autowired
    private StudentService studentService;
    static {
        maoshamap.put("miaoshawan",false);
         count =20;
    }

    @GetMapping( path = "/getList")
    public List<Student> getList(){
        List<Student> students = studentService.selectAll();
        return students;
    }

    @GetMapping( path = "/getStudent")
    public String getList(@Param("numberCode") String numberCode){
        Student students = studentService.getStudent(numberCode);
        String str = new Gson().toJson(students);
        return str;
    }
    @GetMapping( path = "/domaosha")
    public String domaosha(){
        if(maoshamap.get("miaoshawan")){
          System.out.println("请求失败的总数**************"+counta.getAndIncrement());
            return "已经结束了";
        }
//       Long count = studentService.decr("shangpin",1);
//        System.out.println("现在剩余  count="+count);
        count --;
        System.out.println("现在请求成功的是="+counta.getAndIncrement());
        System.out.println("现在的内存标识是="+maoshamap.get("miaoshawan"));
       if(count<0){
           maoshamap.put("miaoshawan",true);
           return "失败了";

       }
       return "成功";
    }

//    @PostMapping(path = "/insert")
//    public String insert(@RequestBody Student student){
//        int insert = studentService.insert(student);
//        String msg = "";
//        if( insert > 0 ){
//            msg = "{\"msg\":\"新增成功\",\"flag\":true}";
//        }else {
//            msg = "{\"msg\":\"新增失败\",\"flag\":false}";
//        }
//        return msg;
//    }

    @GetMapping(path = "/delete")
    public String delete(@Param("numberCode") String numberCode){
        int delete = studentService.delete(numberCode);
        String msg = "";
        if( delete > 0 ){
            msg = "{\"msg\":\"删除成功！！\",\"flag\":true}";
        }else {
            msg = "{\"msg\":\"删除失败！！\",\"flag\":false}";
        }
        return msg;
    }

//    @PostMapping(path = "/update")
//    public String update(@RequestBody Student student){
//        int update = studentService.update(student);
//        String msg = "";
//        if( update > 0 ){
//            msg = "{\"msg\":\"更新成功！！！\",\"flag\":true}";
//        }else {
//            msg = "{\"msg\":\"更新失败！！！\",\"flag\":false}";
//        }
//        return msg;
//    }

}

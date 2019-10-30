package com.myxuexi.testredismysql.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.Accessors;

import java.io.Serializable;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
@ToString
public class Student implements Serializable {
    private Integer id;
    private  String stuname;
    private  String stusex;
    private  String numbercode;
    private Integer stuage;
}

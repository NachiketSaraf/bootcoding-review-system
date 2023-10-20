package com.bootcoding.review.review.system.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.catalina.LifecycleState;

import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student {
    private int id;
    private int rollNumber;
    private String name;
    private int age;
    private String gender;
    private String branch;
    private int year;
    private int semister;
    private List<Course> courses;
}
package com.bootcoding.review.review.system.controller;

import com.bootcoding.review.review.system.model.Student;
import com.bootcoding.review.review.system.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentController {


    @Autowired
    private StudentService studentService;


    @PostMapping("/student")
    public String createStudent(@RequestBody Student student) {
        return studentService.createStudent(student);
    }


//    @PostMapping("/student")
//    public String insertStudent(@RequestBody Student student) {
//        if(studentService.studentExist()){
//            return "Student exist";
//        }
//        return studentService.insertStudent(student);
//    }

    @GetMapping("/student/{rollNumber}")
    public Student getStudent(@PathVariable int rollNumber) {
        return studentService.getStudent(rollNumber);
    }

    @GetMapping("/student")
    public List<Student> getStudentList() {
        return studentService.getStudentList();
    }

    @PutMapping("/student/{studentId}")
    public Student updateStudent(@PathVariable int studentId, @RequestBody Student student) {
        return studentService.updateStudent(studentId, student);
    }

    @DeleteMapping("/student/{studentId}")
    public String deleteStudent(@PathVariable int studentId) {
        return studentService.deleteStudent(studentId);
    }


    @GetMapping("/student/branch/{branch}")
    public List<Student> getStudentsByBranch(@PathVariable String branch) {
        return studentService.getStudentsByBranch(branch);


    }

}

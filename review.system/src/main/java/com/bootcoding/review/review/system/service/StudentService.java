package com.bootcoding.review.review.system.service;

import com.bootcoding.review.review.system.model.Student;

import java.util.List;

public interface StudentService {
    boolean studentExist(Student student);
    Student insertStudent(Student student);

    Student getStudent(int rollNumber);

    List<Student> getStudentList();

    Student updateStudent(int studentId, Student student);


    String deleteStudent(int studentId);

    List<Student> getStudentsByBranch(String branch);
}

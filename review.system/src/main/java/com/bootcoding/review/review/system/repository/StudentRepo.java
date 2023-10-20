package com.bootcoding.review.review.system.repository;

import com.bootcoding.review.review.system.model.Student;

import java.util.List;

public interface StudentRepo {
    Student insertStudent(Student student);

    Student getStudent(int rollNumber);

    List<Student> getStudentList();

    Student updateStudent(int studentId, Student student);

    String deleteStudent(int studentId);

    List<Student> getStudentsByBranch(String branch);

    boolean checkStudent(Student student);

    void save(Student student);
}

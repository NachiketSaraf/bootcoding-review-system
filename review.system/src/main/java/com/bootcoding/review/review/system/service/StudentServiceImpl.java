package com.bootcoding.review.review.system.service;

import com.bootcoding.review.review.system.model.Student;
import com.bootcoding.review.review.system.repository.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepo studentRepo;

    public boolean studentExist(Student student){
        return studentRepo.checkStudent(student);
    }

    @Override
    public Student insertStudent(Student student) {
        return studentRepo.insertStudent(student);
    }

    @Override
    public Student getStudent(int rollNumber) {
        return studentRepo.getStudent(rollNumber);
    }

    @Override
    public List<Student> getStudentList() {
        return studentRepo.getStudentList();
    }

    @Override
    public Student updateStudent(int studentId, Student student) {
        return studentRepo.updateStudent(studentId, student);
    }

    @Override
    public String deleteStudent(int studentId) {
        return studentRepo.deleteStudent(studentId);
    }

    @Override
    public List<Student> getStudentsByBranch(String branch) {
        return studentRepo.getStudentsByBranch(branch);
    }

    @Override
    public String createStudent(Student student) {
        studentRepo.save(student);
        return "Successfully created student!";
    }
}
package com.bootcoding.review.review.system.repository;

import com.bootcoding.review.review.system.model.Student;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class StudentRepoImpl implements StudentRepo{
    private final DataSource dataSource;
    private final JdbcTemplate jdbcTemplate;

    // Constructor Injection
    public StudentRepoImpl(DataSource dataSource, JdbcTemplate jdbcTemplate) {
        this.dataSource = dataSource;
        this.jdbcTemplate = jdbcTemplate;
    }

    public void save(Student student) {
        try {
            String query = "INSERT into student(name)" + " values (?)";
            jdbcTemplate.update(query, student.getName());

            String selectStudentIdQuery = "SELECT id FROM student WHERE name = ?";
            int studentId = jdbcTemplate.queryForObject(selectStudentIdQuery, int.class, student.getName());

            String query2 = "INSERT INTO course(name,student_id)" + " values (?,?)";
            for(Course course: student.getCourses()){
                jdbcTemplate.update(query2, course.getName(),studentId);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    private Map<Integer,Student> studentMap = new HashMap<>();

    @Override
    public boolean checkStudent(Student student) {

        return false;
    }

    @Override
    public void save(Student student) {

    }

    @Override
    public Student insertStudent(Student student) {
        studentMap.put(student.getRollNumber(),student);
        return student;
    }

    @Override
    public Student getStudent(int rollNumber) {
        return   studentMap.get(rollNumber);
    }

    @Override
    public List<Student> getStudentList() {
        ArrayList<Student> students = new ArrayList<>(studentMap.values());
        return students;
    }

    @Override
    public Student updateStudent(int studentId , Student student) {
        if (studentMap.containsKey(studentId)) {
            studentMap.put(studentId, student);
            return student;
        }else {
            System.out.println("User Not Found" + studentId);
        }
        return null;
    }

    @Override
    public String deleteStudent(int studentId) {
        studentMap.remove(studentId);
        return "student deleted successfully...";
    }

    @Override
    public List<Student> getStudentsByBranch(String branch) {
        List<Student> students = new ArrayList<>();
        for (int i : studentMap.keySet()){
            if(branch.equals(studentMap.get(i).getBranch())){
                students.add(studentMap.get(i));
            }
        }
        return  students;
    }


}
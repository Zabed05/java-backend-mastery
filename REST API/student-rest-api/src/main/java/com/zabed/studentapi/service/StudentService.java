package com.zabed.studentapi.service;

import com.zabed.studentapi.dao.StudentDAO;
import com.zabed.studentapi.model.Student;

import java.util.List;

public class StudentService {

    private final StudentDAO studentDAO;

    public StudentService() {
        this.studentDAO = new StudentDAO();
    }

    public List<Student> getAllStudents() {
        return studentDAO.getAllStudents();
    }

    public void addStudent(Student student) {
        studentDAO.addStudent(student);
    }

    public Student getStudentById(int id) {
        return studentDAO.getStudentById(id);
    }
}
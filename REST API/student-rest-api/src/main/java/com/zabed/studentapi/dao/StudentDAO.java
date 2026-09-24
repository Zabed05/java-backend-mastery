package com.zabed.studentapi.dao;

import com.zabed.studentapi.model.Student;

import java.util.ArrayList;
import java.util.List;

public class StudentDAO {

    private final List<Student> students = new ArrayList<>();

    public StudentDAO() {
        students.add(new Student(1, "Zabed", "zabed@gmail.com"));
        students.add(new Student(2, "Rahul", "rahul@gmail.com"));
    }

    public List<Student> getAllStudents() {
        return students;
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    public Student getStudentById(int id) {

        for(Student student : students){
            if(student.getId() == id){
                return student;
            }
        }
        return null;
    }
}
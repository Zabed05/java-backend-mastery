package com.zabed.studentapi.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.zabed.studentapi.model.Student;
import com.zabed.studentapi.service.StudentService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

import static com.sun.management.HotSpotDiagnosticMXBean.ThreadDumpFormat.JSON;

//@WebServlet("/students")
// For request.getPathInfo() to give us: /2 so we need the Servlet mapping to allow the extra path ->
@WebServlet("/students/*")
public class StudentServlet extends HttpServlet {

    private final ObjectMapper objectMapper = new ObjectMapper();
    private final StudentService studentService = new StudentService();

//    @Override
//    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//
//        List<Student> students = studentService.getAllStudents();
//
//        response.setContentType("application/json");
//        response.setCharacterEncoding("UTF-8");
//
//        objectMapper.writeValue(response.getWriter(), students); // Jackson converts: Student[] -> JSON
//    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String pathInfo = request.getPathInfo(); // by this the Servlet receives: /2

        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");

        // GET /students/{id}
        if (pathInfo != null && pathInfo.length() > 1) {

            String idPart = pathInfo.substring(1); // it removes the /: (/2 -> 2)
            int id;

            try {
                id = Integer.parseInt(idPart); // Integer.parseInt("2") gives: 2 (Basically it convert string into integer)
            }
            catch (NumberFormatException e) {
                response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
                response.getWriter().write("{\"error\":\"Student ID must be a number\"}");
                return;
            }

            Student student = studentService.getStudentById(id);

            if (student == null) {
                response.setStatus(HttpServletResponse.SC_NOT_FOUND);
                response.getWriter().write("{\"error\":\"Student not found\"}");
                return;
            }

            objectMapper.writeValue(response.getWriter(), student);
            return;
        }

        // GET /students
        List<Student> students = studentService.getAllStudents();

        objectMapper.writeValue(response.getWriter(), students);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Student student = objectMapper.readValue(request.getReader(), Student.class); // JSON -> Jackson -> Student object

        studentService.addStudent(student); // sends it through our layers.

        response.setStatus(HttpServletResponse.SC_CREATED); // because the POST request successfully created a new resource,
                                                                // and status shows "POST successful → 201 Created"
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");

        objectMapper.writeValue(response.getWriter(), student);
    }
}
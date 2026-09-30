package com.zabed.studentapi.dao;

import com.zabed.studentapi.model.Student;
import com.zabed.studentapi.util.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class StudentDAO {

    public List<Student> getAllStudents() {

        List<Student> students = new ArrayList<>();

        String sql = "SELECT id, name, email FROM students";

        try (
                Connection connection = DBConnection.getConnection();
                PreparedStatement statement = connection.prepareStatement(sql);
                ResultSet resultSet = statement.executeQuery()
        ) {

            while (resultSet.next()) {

                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String email = resultSet.getString("email");


                students.add(new Student(id, name, email));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return students;
    }

    public void addStudent(Student student) {
        String sql = "INSERT INTO students(id, name, email) VALUES(?, ?, ?)";

        try (Connection connection = DBConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setInt(1, student.getId());
            statement.setString(2, student.getName());
            statement.setString(3, student.getEmail());

            statement.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Student getStudentById(int id) {

        String sql = "SELECT id, name, email FROM students WHERE id = ?";
        try (
                Connection connection = DBConnection.getConnection();
                PreparedStatement statement = connection.prepareStatement(sql);
        ) {
            statement.setInt(1, id);
            try (ResultSet resultSet = statement.executeQuery()) {

                if (resultSet.next()) {
                    Student student = new Student();

                    student.setId(resultSet.getInt("id"));
                    student.setName(resultSet.getString("name"));
                    student.setEmail(resultSet.getString("email"));

                    return student;
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    public Student updateStudent(int id, Student updatedStudent) {
        String sql = "UPDATE students SET name = ?, email = ? WHERE id = ?" ;

        try (Connection connection = DBConnection.getConnection();
             PreparedStatement pStatement = connection.prepareStatement(sql)) {

            pStatement.setString(1, updatedStudent.getName());
            pStatement.setString(2, updatedStudent.getEmail());
            pStatement.setInt(3, id);

            int rowsUpdated = pStatement.executeUpdate();

            if (rowsUpdated > 0) {
                updatedStudent.setId(id);
                return updatedStudent;
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    public boolean deleteStudent(int id) {
        String sql = "DELETE FROM Students WHERE id = ?";

        try(Connection connection = DBConnection.getConnection();
            PreparedStatement pStatement = connection.prepareStatement(sql)){

            pStatement.setInt(1, id);

            int rowAffected = pStatement.executeUpdate();

            return rowAffected > 0;
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
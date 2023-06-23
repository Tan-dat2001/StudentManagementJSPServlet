package com.StudentManagement.dao;

import com.StudentManagement.model.Khoa;
import com.StudentManagement.model.Student;

import java.sql.SQLException;
import java.util.List;

public interface IStudentDAO {
    public void insertStudent(Student student) throws SQLException;

    public Student selectStudentById(Long id);

    public List<Student> selectAllStudents();

    public boolean deleteStudentById(Long id) throws SQLException;

    public boolean updateStudent(Student student) throws SQLException;



}

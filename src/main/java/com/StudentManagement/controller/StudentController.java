package com.StudentManagement.controller;

import com.StudentManagement.dao.KhoaDAO;
import com.StudentManagement.dao.StudentDAO;
import com.StudentManagement.model.Khoa;
import com.StudentManagement.model.Student;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "StudentController", value = "/StudentController")
public class StudentController extends HttpServlet {
    private StudentDAO studentDAO;
    private KhoaDAO khoaDAO;

    public void init(){
        studentDAO = new StudentDAO();
        khoaDAO = new KhoaDAO();
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if(action == null){
            action = "";
        }
        switch (action) {
            case "create":
                showNewForm(request, response);
                break;
            case "edit":
                showEditForm(request, response);
                break;
            case "delete":
                try {
                    deleteStudent(request, response);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                break;
            default:
                listStudent(request, response);
                break;
        }
    }

    private void listStudent(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Student> listStudent = studentDAO.selectAllStudents();
        request.setAttribute("listStudent1", listStudent);
        RequestDispatcher dispatcher = request.getRequestDispatcher("views/list.jsp");
        dispatcher.forward(request, response);
    }

    private void deleteStudent(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
        Long id = Long.parseLong(request.getParameter("id"));
        studentDAO.deleteStudentById(id);

        List<Student> listStudent = studentDAO.selectAllStudents();
        request.setAttribute("listStudent", listStudent);
        RequestDispatcher dispatcher = request.getRequestDispatcher("user/list.jsp");
        dispatcher.forward(request, response);
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Long id = Long.parseLong(request.getParameter("id"));
        Student existingStudent = studentDAO.selectStudentById(id);
        RequestDispatcher dispatcher = request.getRequestDispatcher("user/edit.jsp");
        request.setAttribute("student", existingStudent);
        dispatcher.forward(request, response);
    }

    private void showNewForm(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("views/create.jsp");
        dispatcher.forward(request, response);
    }

//    private void insertStudent(HttpServletRequest request, HttpServletResponse response)
//            throws SQLException, IOException, ServletException {
//        String mssv = request.getParameter("mssv"); //lấy tên có thuộc tính name="?" ở file jsp
//        String hoTen = request.getParameter("fullName");
//        String gioiTinh = request.getParameter("gender");
//        Long khoa_id = request.getParameter("")
//        User newUser = new User(name, email, country);
//        userDAO.insertUser(newUser);
//        RequestDispatcher dispatcher = request.getRequestDispatcher("user/create.jsp");
//        dispatcher.forward(request, response);
//    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        String action = request.getParameter("action");
//        if (action == null) {
//            action = "";
//        }
//        try {
//            switch (action) {
//                case "create":
//                    insertUser(request, response);
//                    break;
//                case "edit":
//                    updateUser(request, response);
//                    break;
//            }
//        } catch (SQLException ex) {
//            throw new ServletException(ex);
//        }
    }
}

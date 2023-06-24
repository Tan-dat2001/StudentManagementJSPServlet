package com.StudentManagement.controller;

import com.StudentManagement.dao.StudentDAO;
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


    public void init(){
        studentDAO = new StudentDAO();

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if(action != null){
            if(action.equals("listAllStudent")){
                listStudent(request,response);
            }else if(action.equals("create")){
                showNewForm(request,response);
            }else if(action.equals("edit")){
                showEditForm(request,response);
            }else if(action.equals("listStudentByKhoa")){
                showStudentByKhoa(request,response);
            }else if(action.equals("delete")){
                try {
                    deleteStudent(request,response);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

        }
//        switch (action) {
//            case "create":
//                showNewForm(request, response);
//                break;
//            case "edit":
//                showEditForm(request, response);
//                break;
//            case "listStudentByKhoa":
//                showStudentByKhoa(request,response);
//            case "delete":
//                try {
//                    deleteStudent(request, response);
//                } catch (SQLException e) {
//                    e.printStackTrace();
//                }
//                break;
////            case "listAllStudent":
//            default:
//                listStudent(request, response);
//                break;
//        }
    }

    private void showStudentByKhoa(HttpServletRequest request, HttpServletResponse response) {
    }

    private void listStudent(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Student> listStudent = studentDAO.selectAllStudents();
        request.setAttribute("listStudent", listStudent);
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
        RequestDispatcher dispatcher = request.getRequestDispatcher("views/edit.jsp");
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
    private void insertStudent(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        String mssv = request.getParameter("mssv");
        String name = request.getParameter("name");
        String gender = request.getParameter("gender");
        String faculty = request.getParameter("faculty");
        Student newStudent = new Student(mssv,name,gender,faculty);
        studentDAO.insertStudent(newStudent);
        RequestDispatcher dispatcher = request.getRequestDispatcher("views/list.jsp");
        dispatcher.forward(request, response);
    }
    private void updateStudent(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        StudentDAO studentDAO = new StudentDAO();
        Long id = Long.parseLong(request.getParameter("id"));
        String mssv = request.getParameter("mssv");
        String name = request.getParameter("name");
        String gender = request.getParameter("gender");
        String faculty = request.getParameter("faculty");
        Student student = new Student(id, mssv ,name, gender, faculty);
        studentDAO.updateStudent(student);
        RequestDispatcher dispatcher = request.getRequestDispatcher("views/list.jsp");
        dispatcher.forward(request, response);
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        try {
            switch (action) {
                case "create":
                    insertStudent(request, response);
                    break;
                case "edit":
                    updateStudent(request, response);
                    break;
            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }

    }
}

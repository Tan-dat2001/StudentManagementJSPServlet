package com.StudentManagement.controller;

import com.StudentManagement.dao.StudentDAO;
import com.StudentManagement.model.Student;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "LoginController", value = "/LoginController")
public class LoginController extends HttpServlet {
//    private StudentDAO studentDAO;
//
//
//    public void init(){
//        studentDAO = new StudentDAO();
//
//    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(true   );

        try{
            String username = request.getParameter("txtUsername");
            String password = request.getParameter("txtPassword");
            StudentDAO studentDAO = new StudentDAO();
            Student student = studentDAO.checkLogin(username,password);
            if(student != null){
                session.setAttribute("student", student);
                String action = "listAllStudent";
                response.sendRedirect("/StudentController?action=" + action);
            }else{
                response.sendRedirect("index.jsp");
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (Exception e) {
            log("error at login servlet: " + e.toString());
            e.printStackTrace();
        }
//        }finally {
//            response.sendRedirect("views/error.jsp");
//        }
    }
}

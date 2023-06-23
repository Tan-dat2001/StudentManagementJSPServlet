package com.StudentManagement.dao;

import com.StudentManagement.model.Khoa;
import com.StudentManagement.model.Student;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentDAO implements IStudentDAO{

    private String jdbcURL = "jdbc:mysql://localhost:3306/test?useSSL=false";
    private String jdbcUsername = "root";
    private String jdbcPassword = "280412092312";

    public StudentDAO(){

    }
    protected Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return connection;
    }



//    private static final String INSERT_USERS_SQL = "INSERT INTO users" + "  (name, email, country) VALUES " +
//            " (?, ?, ?);";
//    private static final String SELECT_USER_BY_ID = "select id,name,email,country from users where id =?";
//    private static final String SELECT_ALL_USERS = "select * from users";
//    private static final String DELETE_USERS_SQL = "delete from users where id = ?;";
//    private static final String UPDATE_USERS_SQL = "update users set name = ?,email= ?, country =? where id = ?;";
    @Override
    public void insertStudent(Student student) throws SQLException {
        String sql = "insert into sinhvien(mssv,hoten,gioitinh,khoa_id,) values(?,?,?,?)";
        try (Connection connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, student.getHoTen());
            preparedStatement.setString(2, student.getMssv());
            preparedStatement.setString(3, student.getGioiTinh());
            preparedStatement.setLong(4, student.getKhoa_id());
            System.out.println(preparedStatement);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            printSQLException(e);
        }
    }

    @Override
    public Student selectStudentById(Long id) {
        Student student = null;
        String sql = "select mssv,hoten,gioitinh,khoa_id from sinhvien where id = ?";
        // Step 1: Establishing a Connection
        try (Connection connection = getConnection();
             // Step 2:Create a statement using connection object
             PreparedStatement preparedStatement = connection.prepareStatement(sql);) {
            preparedStatement.setLong(1, id);
            System.out.println(preparedStatement);
            // Step 3: Execute the query or update query
            ResultSet rs = preparedStatement.executeQuery();

            // Step 4: Process the ResultSet object.
            while (rs.next()) {
                Long sinhvien_id = rs.getLong("sinhvien_id");
                String mssv = rs.getString("mssv");
                String hoTen = rs.getString("hoten");
                String gioiTinh = rs.getString("gioitinh");
                Long khoa_id = rs.getLong("khoa_id");

                student = new Student(sinhvien_id,mssv,hoTen,gioiTinh,khoa_id);
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return student;
    }

    @Override
    public List<Student> selectAllStudents() {
        // using try-with-resources to avoid closing resources (boiler plate code)
        List<Student> students = new ArrayList<>();
        String sql = "select * from sinhvien";
        // Step 1: Establishing a Connection
        try (Connection connection = getConnection();

             // Step 2:Create a statement using connection object
            PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
//            System.out.println(preparedStatement);
            // Step 3: Execute the query or update query
            ResultSet rs = preparedStatement.executeQuery();

            // Step 4: Process the ResultSet object.
            while (rs.next()) {
//                Long sinhvien_id = rs.getLong("sinhvien_id");
                String mssv = rs.getString("mssv");
                String hoTen = rs.getString("hoten");
                String gioiTinh = rs.getString("gioitinh");
                Long khoa_id = rs.getLong("khoa_id");
//                String username = rs.getString("username");
//                String password = rs.getString("password");
                students.add(new Student( mssv, hoTen, gioiTinh, khoa_id));
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return students ;
    }

    private void printSQLException(SQLException ex) {
        for (Throwable e : ex) {
            if (e instanceof SQLException) {
                e.printStackTrace(System.err);
                System.err.println("SQLState: " + ((SQLException) e).getSQLState());
                System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
                System.err.println("Message: " + e.getMessage());
                Throwable t = ex.getCause();
                while (t != null) {
                    System.out.println("Cause: " + t);
                    t = t.getCause();
                }
            }
        }
    }

    @Override
    public boolean deleteStudentById(Long id) throws SQLException {
        boolean rowDeleted;
        String sql = "delete from sinhvien where sinhvien_id = ?";
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setLong(1, id);
            rowDeleted = statement.executeUpdate() > 0;
        }
        return rowDeleted;
    }

    @Override
    public boolean updateStudent(Student student) throws SQLException {
        String sql = "update sinhvien set mssv=?, hoten=?, gioitinh=?,khoa_id=? where sinhvien_id=?";
        boolean rowUpdated;
        try (Connection connection = getConnection(); PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, student.getMssv());
            statement.setString(2, student.getHoTen());
            statement.setString(3, student.getGioiTinh());
            statement.setLong(4, student.getKhoa_id());
            rowUpdated = statement.executeUpdate() > 0;
        }
        return rowUpdated;
    }

    //check Login
    public Student checkLogin(String user, String pass) throws SQLException, Exception{
        Student student = null;
        String sql = "select * from sinhvien where username = ? and password = ?";
        try(Connection connection = getConnection(); PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, user);
            statement.setString(2, pass);
            ResultSet rs = statement.executeQuery();
            if(rs.next()){
                student = new Student(rs.getLong("sinhvien_id"),
                        rs.getString("mssv"),
                        rs.getString("hoTen"),
                        rs.getString("gioiTinh"),
                        rs.getLong("khoa_id"),
                        rs.getString("username"),
                        rs.getString("password"));
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return  student;
    }


}

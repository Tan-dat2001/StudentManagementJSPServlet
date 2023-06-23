package com.StudentManagement.dao;

import com.StudentManagement.model.Khoa;
import com.StudentManagement.model.Student;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class KhoaDAO implements IKhoaDAO{
    private String jdbcURL = "jdbc:mysql://localhost:3306/test?useSSL=false";
    private String jdbcUsername = "root";
    private String jdbcPassword = "280412092312";

    public KhoaDAO(){

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


    @Override
    public List<Khoa> SelectAllKhoas() {
        // using try-with-resources to avoid closing resources (boiler plate code)
        List<Khoa> khoas = new ArrayList<>();
        String sql = "select * from khoa";
        // Step 1: Establishing a Connection
        try (Connection connection = getConnection();

             // Step 2:Create a statement using connection object
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
//            System.out.println(preparedStatement);
            // Step 3: Execute the query or update query
            ResultSet rs = preparedStatement.executeQuery();

            // Step 4: Process the ResultSet object.
            while (rs.next()) {
                Long khoa_id = rs.getLong("khoa_id");
                String tenKhoa = rs.getString("tenkhoa");
                khoas.add(new Khoa(khoa_id,tenKhoa));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return khoas ;

    }
}

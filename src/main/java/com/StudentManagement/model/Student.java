package com.StudentManagement.model;

public class Student {
    private Long id;
    private String mssv;
    private String hoTen;
    private String gioiTinh;
    private Long khoa_id;
    private String username;
    private String password;

    public Student() {
    }

    public Student(Long id, String mssv, String hoTen, String gioiTinh, Long khoa_id, String username, String password) {
        this.id = id;
        this.mssv = mssv;
        this.hoTen = hoTen;
        this.gioiTinh = gioiTinh;
        this.khoa_id = khoa_id;
        this.username = username;
        this.password = password;
    }

    public Student(Long id, String mssv, String hoTen, String gioiTinh, Long khoa_id) {
        this.id = id;
        this.mssv = mssv;
        this.hoTen = hoTen;
        this.gioiTinh = gioiTinh;
        this.khoa_id = khoa_id;
    }

    public Student(String mssv, String hoTen, String gioiTinh, Long khoa_id) {
        this.mssv = mssv;
        this.hoTen = hoTen;
        this.gioiTinh = gioiTinh;
        this.khoa_id = khoa_id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMssv() {
        return mssv;
    }

    public void setMssv(String mssv) {
        this.mssv = mssv;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public String getGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(String gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public Long getKhoa_id() {
        return khoa_id;
    }

    public void setKhoa_id(Long khoa_id) {
        this.khoa_id = khoa_id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

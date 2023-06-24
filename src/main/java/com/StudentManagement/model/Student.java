package com.StudentManagement.model;

public class Student {
    private Long id;
    private String mssv;
    private String hoTen;
    private String gioiTinh;
    private String khoa;
    private String username;
    private String password;

    public Student() {
    }

    public Student(Long id, String mssv, String hoTen, String gioiTinh, String khoa, String username, String password) {
        this.id = id;
        this.mssv = mssv;
        this.hoTen = hoTen;
        this.gioiTinh = gioiTinh;
        this.khoa = khoa;
        this.username = username;
        this.password = password;
    }

    public Student(Long id, String mssv, String hoTen, String gioiTinh, String khoa) {
        this.id = id;
        this.mssv = mssv;
        this.hoTen = hoTen;
        this.gioiTinh = gioiTinh;
        this.khoa = khoa;
    }

    public Student(String mssv, String hoTen, String gioiTinh, String khoa) {
        this.mssv = mssv;
        this.hoTen = hoTen;
        this.gioiTinh = gioiTinh;
        this.khoa = khoa;
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

    public String getKhoa() {
        return khoa;
    }

    public void setKhoa(String khoa) {
        this.khoa = khoa;
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

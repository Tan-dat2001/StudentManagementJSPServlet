package com.StudentManagement.model;

public class Khoa {
    private Long khoa_id;
    private String tenKhoa;

    public Khoa(Long khoa_id, String tenKhoa) {
        this.khoa_id = khoa_id;
        this.tenKhoa = tenKhoa;
    }

    public Long getKhoa_id() {
        return khoa_id;
    }

    public void setKhoa_id(Long khoa_id) {
        this.khoa_id = khoa_id;
    }

    public String getTenKhoa() {
        return tenKhoa;
    }

    public void setTenKhoa(String tenKhoa) {
        this.tenKhoa = tenKhoa;
    }
}

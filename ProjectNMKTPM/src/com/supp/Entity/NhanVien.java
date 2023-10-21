/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.supp.Entity;

import java.io.Serializable;

/**
 *
 * @author Duy Quang
 */
public class NhanVien  {
    private String maNV,tenNV,matKhau,dienThoai,email,vaiTro,hinhAnh;

    public NhanVien() {
        this.vaiTro = "Nhân viên";
    }

    public NhanVien(String maNV, String tenNV, String matKhau, String dienThoai, String email, String vaiTro, String hinhAnh) {
        this.maNV = maNV;
        this.tenNV = tenNV;
        this.matKhau = matKhau;
        this.dienThoai = dienThoai;
        this.email = email;
        this.vaiTro = vaiTro;
        this.hinhAnh = hinhAnh;
    }

    public String getMaNV() {
        return maNV;
    }

    public void setMaNV(String maNV) {
        this.maNV = maNV;
    }

    public String getTenNV() {
        return tenNV;
    }

    public void setTenNV(String tenNV) {
        this.tenNV = tenNV;
    }

    public String getMatKhau() {
        return matKhau;
    }

    public void setMatKhau(String matKhau) {
        this.matKhau = matKhau;
    }

    public String getDienThoai() {
        return dienThoai;
    }

    public void setDienThoai(String dienThoai) {
        this.dienThoai = dienThoai;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getVaiTro() {
        return vaiTro != null ? vaiTro : "Nhân viên";
    }

    public void setVaiTro(String vaiTro) {
        this.vaiTro = vaiTro;
    }

    public String getHinhAnh() {
        return hinhAnh;
    }

    public void setHinhAnh(String hinhAnh) {
        this.hinhAnh = hinhAnh;
    }

    
   
    
    
}

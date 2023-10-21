/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.supp.Util;

import com.supp.Entity.NhanVien;

/**
 *
 * @author Duy Quang
 */
public class Auth {
    public static NhanVien user = null;
    public static void clear(){
        Auth.user = null;
    }
    
    public static boolean isLogin(){
        return Auth.user != null;
    }
    
    public static boolean isManager(){
        return Auth.isLogin()&& user.getVaiTro().equals("Quản lý");
    }
    
    public static boolean isAdmin(){
        return Auth.isLogin()&& user.getVaiTro().equals("Admin");
    }
}

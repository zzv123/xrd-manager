package com.xrd.znsbgl.service;

import com.xrd.znsbgl.entity.Admin;

import java.util.ArrayList;

public interface AdminService {
    //通过用户名获得用户详情
    public Admin getAdminByUsername(String username);

    public int addAdmin(Admin admin);

    public ArrayList<Admin> getAllAdmin();

}

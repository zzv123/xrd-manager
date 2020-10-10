package com.xrd.znsbgl.service.impl;

import com.xrd.znsbgl.entity.Admin;
import com.xrd.znsbgl.mapper.AdminMapper;
import com.xrd.znsbgl.service.AdminService;
import com.xrd.znsbgl.util.MD5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    AdminMapper adminMapper;

    @Override
    public Admin getAdminByUsername(String username) {
        Admin a = adminMapper.getAdminByUsername(username);
        return a;
    }

    @Override
    public int addAdmin(Admin admin) {
        admin.setPassword(MD5Util.md5(admin.getPassword()));
        int i = adminMapper.addAdmin(admin);
        return i;
    }

    @Override
    public ArrayList<Admin> getAllAdmin() {
        return adminMapper.getAllAdmin();
    }
}

package com.xrd.znsbgl.controller;

import com.xrd.znsbgl.entity.Admin;
import com.xrd.znsbgl.entity.LoginLog;
import com.xrd.znsbgl.mapper.AdminMapper;
import com.xrd.znsbgl.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

@RestController
public class AdminController {

    @Autowired
    AdminService adminService;


    @PostMapping("/addAdmin")
    public HashMap<String, Object> addAdmin(Admin admin){
        HashMap<String,Object> hashMap = new HashMap<String, Object>();
        //先判断用户名不能重复
        Admin a = adminService.getAdminByUsername(admin.getUsername());
        if (a==null){
            if(admin.getUsername().length()<6){
                hashMap.put("code",0);
                hashMap.put("msg","添加失败，用户名不能小于6位");
            }else if(admin.getPassword().length()<6){
                hashMap.put("code",0);
                hashMap.put("msg","添加失败，密码不能小于6位");
            }else{
                int i = adminService.addAdmin(admin);
                hashMap.put("code",i);
                hashMap.put("msg","添加成功");
            }
        }else{
            hashMap.put("code",0);
            hashMap.put("msg","添加失败，用户名重复");

        }
        return hashMap;
    }
    @GetMapping("/getAllAdmin")
    public HashMap<String, Object> getAllAdmin() {
        HashMap<String, Object> hashMap = new HashMap<String, Object>();
        hashMap.put("code",1);
        hashMap.put("msg","查询成功");
        hashMap.put("data",adminService.getAllAdmin());
        return hashMap;

    }



}

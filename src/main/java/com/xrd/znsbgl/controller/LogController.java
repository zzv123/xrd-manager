package com.xrd.znsbgl.controller;
import com.xrd.znsbgl.entity.Admin;
import com.xrd.znsbgl.entity.LoginLog;
import com.xrd.znsbgl.mapper.AdminMapper;
import com.xrd.znsbgl.mapper.LogMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;

@RestController
public class LogController {

    @Autowired
    LogMapper logMapper;
    @Autowired
    AdminMapper adminMapper;

    @GetMapping("/getAllLog")
    public HashMap<String, Object> getAllLog() {
        HashMap<String, Object> hashMap = new HashMap<String, Object>();
        //获得所有的日志信息
        ArrayList<LoginLog> al = logMapper.getAllLog();
        System.out.println(al);
        for(int i=0;i<al.size();i++){
           Admin admin= adminMapper.getAdminById(al.get(i).getAdminId());
           al.get(i).setAdmin(admin);
        }
        System.out.println(al);

        hashMap.put("code",1);
        hashMap.put("msg","查询成功");
        hashMap.put("data",al);
        return hashMap;
    }
}

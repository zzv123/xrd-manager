package com.xrd.znsbgl.controller;

import com.xrd.znsbgl.entity.Admin;
import com.xrd.znsbgl.entity.LoginLog;
import com.xrd.znsbgl.mapper.LogMapper;
import com.xrd.znsbgl.mapper.LoginMapper;
import com.xrd.znsbgl.service.LogService;
import com.xrd.znsbgl.service.LoginService;
import com.xrd.znsbgl.util.MD5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

@CrossOrigin//允许跨域注解
@RestController
public class LoginController {

    @Autowired
    LoginService loginService;

    @Autowired
    LogService logService;

    @GetMapping("/login")
    public HashMap<String, Object> login(Admin admin, String ip, HttpSession httpSession){
        HashMap<String,Object> hashMap = new HashMap<String, Object>();
        //如果用户名密码正确，返回1，否则返回2
        Admin a = loginService.getAdminByUP(admin);
        if(a==null){
            hashMap.put("code",0);
            hashMap.put("msg","用户登录失败");
        }else{
            //添加数据入数据库（登陆信息）
            int i = logService.addLog(a.getId(),ip);
            hashMap.put("code",1);
            hashMap.put("msg","用户登录成功");
            //写入session
            Date date = new Date();
            String token = MD5Util.md5(a.getUsername()+date.getTime());
            httpSession.setAttribute(token,a);
            httpSession.setMaxInactiveInterval(60*60);
            hashMap.put("token",token);
        }
        return hashMap;
    }

    @GetMapping("getToken")
    public HashMap<String, Object> getToken(String token,HttpSession httpSession){
        HashMap<String,Object> hashMap = new HashMap<String, Object>();
        Admin admin = (Admin) httpSession.getAttribute(token);
        if(admin==null){
            hashMap.put("code",0);
            hashMap.put("msg","非法登录");
        }else{
            hashMap.put("code",1);
            hashMap.put("msg","token验证成功");
            hashMap.put("data",admin);
        }
        return hashMap;
    }
    @GetMapping("deleteToken")
    public HashMap<String, Object> deleteToken(String token,HttpSession httpSession){
        HashMap<String,Object> hashMap = new HashMap<String, Object>();
        httpSession.removeAttribute(token);
        hashMap.put("code",1);
        hashMap.put("msg","退出成功");

        return hashMap;
    }


}

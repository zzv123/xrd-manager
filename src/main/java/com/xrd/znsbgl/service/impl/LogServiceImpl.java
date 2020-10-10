package com.xrd.znsbgl.service.impl;

import com.xrd.znsbgl.entity.LoginLog;
import com.xrd.znsbgl.mapper.LogMapper;
import com.xrd.znsbgl.service.LogService;
import com.xrd.znsbgl.util.SystemTimeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

@Service
public class LogServiceImpl implements LogService {
    @Autowired
    LogMapper logMapper;
    @Override
    public int addLog(Integer id, String ip) {
        LoginLog loginLog = new LoginLog();
        loginLog.setAdminId(id);
        loginLog.setIp(ip);
        Timestamp ts = SystemTimeUtil.getSystemTime2();
        loginLog.setLoginTime(ts);//当前时间
        int i = logMapper.addLog(loginLog);
        return i;
    }
}

package com.xrd.znsbgl.util;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
//系统时间工具类
public class SystemTimeUtil {
//获得当前系统时间
    public Timestamp getSystemTime(){
        Date date = new Date();//获得系统时间
        String nowTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date);
        Timestamp timestamp = Timestamp.valueOf(nowTime);//把时间转换
        return timestamp;
    }
    public static Timestamp getSystemTime2(){
        Date date = new Date();//获得系统时间
        String nowTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date);
        Timestamp timestamp = Timestamp.valueOf(nowTime);//把时间转换
        return timestamp;
    }
}

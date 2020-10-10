package com.xrd.znsbgl.mapper;

import com.xrd.znsbgl.entity.LoginLog;
import org.apache.ibatis.annotations.Mapper;

import java.util.ArrayList;

@Mapper
public interface LogMapper {

    public int addLog(LoginLog loginLog);

    public ArrayList<LoginLog> getAllLog();
}

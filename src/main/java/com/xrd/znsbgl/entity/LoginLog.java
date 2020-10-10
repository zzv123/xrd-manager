package com.xrd.znsbgl.entity;

import java.sql.Timestamp;

public class LoginLog {
    private Integer id;
    private Integer adminId;
    private Timestamp loginTime;
    private String ip;
    private Admin admin;

    public Admin getAdmin() {
        return admin;
    }

    public void setAdmin(Admin admin) {
        this.admin = admin;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getAdminId() {
        return adminId;
    }

    public void setAdminId(Integer adminId) {
        this.adminId = adminId;
    }

    public Timestamp getLoginTime() {
        return loginTime;
    }

    public void setLoginTime(Timestamp loginTime) {
        this.loginTime = loginTime;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    @Override
    public String toString() {
        return "LoginLog{" +
                "id=" + id +
                ", adminId=" + adminId +
                ", loginTime=" + loginTime +
                ", ip='" + ip + '\'' +
                ", admin=" + admin +
                '}';
    }
}

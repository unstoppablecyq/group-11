package com.example.demo.resp;

import com.baomidou.mybatisplus.annotation.TableName;


public class SysUserLoginResp {
    private Long id;

    private String LoginName;



    private String password;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLoginName() {
        return LoginName;
    }

    public void setLoginName(String loginName) {
        LoginName = loginName;
    }



    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "SysUserEntity{" +
                "id=" + id +
                ", LoginName='" + LoginName + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}

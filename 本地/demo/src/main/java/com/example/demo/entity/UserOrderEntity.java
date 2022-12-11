package com.example.demo.entity;

import com.baomidou.mybatisplus.annotation.TableName;

@TableName("userorderinfo")
public class UserOrderEntity {
    public Long id;
    public String msg;
    public String username;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String toString() {
        return "UserOrderEntity{" +
                "id=" + id +
                ", msg='" + msg + '\'' +
                ", username='" + username + '\'' +
                '}';
    }
}

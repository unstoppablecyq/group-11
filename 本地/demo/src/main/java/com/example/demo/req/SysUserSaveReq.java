package com.example.demo.req;

import org.apache.coyote.http11.filters.SavedRequestInputFilter;

public class SysUserSaveReq {
    private Long id;
    private String username;
    private String email;
    private String password;

    private String checkpass;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCheckpass() {
        return checkpass;
    }

    public void setCheckpass(String checkpass) {
        this.checkpass = checkpass;
    }

    @Override
    public String toString() {
        return "SysUserSaveReq{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", checkpass='" + checkpass + '\'' +
                '}';
    }
}

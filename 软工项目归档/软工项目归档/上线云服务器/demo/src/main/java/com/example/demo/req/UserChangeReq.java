package com.example.demo.req;

public class UserChangeReq {
    public String username;
    public String oldpass;
    public String newpass;
    public String checknewpass;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getOldpass() {
        return oldpass;
    }

    public void setOldpass(String oldpass) {
        this.oldpass = oldpass;
    }

    public String getNewpass() {
        return newpass;
    }

    public void setNewpass(String newpass) {
        this.newpass = newpass;
    }

    public String getChecknewpass() {
        return checknewpass;
    }

    public void setChecknewpass(String checknewpass) {
        this.checknewpass = checknewpass;
    }

    @Override
    public String toString() {
        return "UserChangeReq{" +
                "username='" + username + '\'' +
                ", oldpass='" + oldpass + '\'' +
                ", newpass='" + newpass + '\'' +
                ", checknewpass='" + checknewpass + '\'' +
                '}';
    }
}

package com.example.demo.req;

public class CheckbodyReq {
    public Long id;
    public String username;
    public String checkbody_id;
    public String iseyes;
    public String istooth;
    public String address;

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

    public String getCheckbody_id() {
        return checkbody_id;
    }

    public void setCheckbody_id(String checkbody_id) {
        this.checkbody_id = checkbody_id;
    }

    public String getIseyes() {
        return iseyes;
    }

    public void setIseyes(String iseyes) {
        this.iseyes = iseyes;
    }

    public String getIstooth() {
        return istooth;
    }

    public void setIstooth(String istooth) {
        this.istooth = istooth;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "CheckbodyReq{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", checkbody_id='" + checkbody_id + '\'' +
                ", iseyes='" + iseyes + '\'' +
                ", istooth='" + istooth + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}

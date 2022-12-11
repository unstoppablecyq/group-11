package com.example.demo.entity;

import com.baomidou.mybatisplus.annotation.TableName;

@TableName("acidinfo")
public class AcidEntity {
    public Long id;
    public String username;
    public Long hospital_id;
    public String hospital;
    public String timer;
    public boolean delivery;
    public String healthcode;
    public String text;

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

    public Long getHospital_id() {
        return hospital_id;
    }

    public void setHospital_id(Long hospital_id) {
        this.hospital_id = hospital_id;
    }

    public String getHospital() {
        return hospital;
    }

    public void setHospital(String hospital) {
        this.hospital = hospital;
    }

    public String getTimer() {
        return timer;
    }

    public void setTimer(String timer) {
        this.timer = timer;
    }

    public boolean isDelivery() {
        return delivery;
    }

    public void setDelivery(boolean delivery) {
        this.delivery = delivery;
    }

    public String getHealthcode() {
        return healthcode;
    }

    public void setHealthcode(String healthcode) {
        this.healthcode = healthcode;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return "AcidEntity{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", hospital_id=" + hospital_id +
                ", hospital='" + hospital + '\'' +
                ", timer='" + timer + '\'' +
                ", delivery=" + delivery +
                ", healthcode='" + healthcode + '\'' +
                ", text='" + text + '\'' +
                '}';
    }
}

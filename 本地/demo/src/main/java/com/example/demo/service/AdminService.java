package com.example.demo.service;

import com.example.demo.req.AdminReq;
import com.example.demo.req.SysUserLoginReq;
import com.example.demo.resp.CommonResp;

public interface AdminService {
    AdminReq adminlogin(AdminReq req, CommonResp<AdminReq> resp);
}

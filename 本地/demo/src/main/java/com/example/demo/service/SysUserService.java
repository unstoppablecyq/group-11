package com.example.demo.service;

import com.example.demo.req.SysUserLoginReq;
import com.example.demo.req.SysUserSaveReq;
import com.example.demo.req.UserChangeReq;
import com.example.demo.resp.CommonResp;

public interface SysUserService {

    //login
    SysUserLoginReq login(SysUserLoginReq req, CommonResp<SysUserLoginReq> resp);
    SysUserLoginReq saveuser(SysUserLoginReq req, CommonResp<SysUserLoginReq> resp);
    SysUserSaveReq register(SysUserSaveReq req, CommonResp<SysUserSaveReq> resp);

    Boolean changepass(UserChangeReq req);


    //SysUserLoginResp login(SysUserLoginReq req);
}

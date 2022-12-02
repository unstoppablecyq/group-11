package com.example.demo.Controller;

import com.example.demo.entity.SysUserEntity;
import com.example.demo.mapper.AcidMapper;
import com.example.demo.req.AcidReq;
import com.example.demo.req.SysUserLoginReq;
import com.example.demo.req.SysUserSaveReq;
import com.example.demo.req.UserChangeReq;
import com.example.demo.resp.CommonResp;
import com.example.demo.resp.SysUserLoginResp;
import com.example.demo.service.AcidService;
import com.example.demo.service.SysUserService;
import com.example.demo.utils.JwtUtil;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/api")
public class SysUserController {

    @Autowired
    private SysUserService sysUserService;


    @PostMapping("register")
//    zxcv1234
    public CommonResp register(@RequestBody  SysUserSaveReq req){
        req.setPassword(DigestUtils.md5DigestAsHex(req.getPassword().getBytes()));
        CommonResp<SysUserSaveReq> resp = new CommonResp<>();
        SysUserSaveReq userSaveReq = sysUserService.register(req,resp);
        resp.setContent(userSaveReq);
        return resp;
    }

    @PostMapping("login")
    public CommonResp login(@RequestBody SysUserLoginReq req){
//        zxcv1234
        req.setPassword(DigestUtils.md5DigestAsHex(req.getPassword().getBytes()));
        CommonResp<SysUserLoginReq> resp = new CommonResp<>();
        SysUserLoginReq userLoginReq = sysUserService.login(req,resp);
        resp.setContent(userLoginReq);

        System.out.println(resp);//输出resp返回给前端的信息
        return resp;
    }

    @PostMapping("saveuser")
    public CommonResp saveuser(@RequestBody SysUserLoginReq req){
//        zxcv1234
        CommonResp<SysUserLoginReq> resp = new CommonResp<>();
        SysUserLoginReq userLoginReq = sysUserService.saveuser(req,resp);
        resp.setContent(userLoginReq);

        System.out.println(resp);//输出resp返回给前端的信息
        return resp;
    }


    @GetMapping("checkToken")
    public Boolean checkToken(HttpServletRequest request){
        String token = request.getHeader("token");
        //System.out.println(token);
        return JwtUtil.checkToken(token);
    }

    @PostMapping("changepass")
    public Boolean changepass(@RequestBody UserChangeReq req){
        //System.out.println(req);
        Boolean userchangeReq = sysUserService.changepass(req);
        return userchangeReq;
    }

}






















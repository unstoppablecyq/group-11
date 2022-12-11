package com.example.demo.Controller;


import com.example.demo.req.AdminReq;
import com.example.demo.req.SysUserLoginReq;
import com.example.demo.resp.CommonResp;
import com.example.demo.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class AdminController {

    @Autowired
    private AdminService adminService;

    @PostMapping("adminlogin")
    public CommonResp login(@RequestBody AdminReq req){
//        zxcv1234
        CommonResp<AdminReq> resp = new CommonResp<>();
        AdminReq adminReq = adminService.adminlogin(req,resp);
        resp.setContent(adminReq);

        System.out.println(resp);//输出resp返回给前端的信息
        return resp;
    }
}

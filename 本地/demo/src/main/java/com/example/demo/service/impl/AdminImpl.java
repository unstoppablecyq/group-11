package com.example.demo.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.demo.entity.AcidEntity;
import com.example.demo.entity.AdminEntity;
import com.example.demo.entity.SysUserEntity;
import com.example.demo.exception.BusinessExceptionCode;
import com.example.demo.mapper.AcidMapper;
import com.example.demo.mapper.AdminMapper;
import com.example.demo.mapper.SysUserMapper;
import com.example.demo.req.AdminReq;
import com.example.demo.req.SysUserLoginReq;
import com.example.demo.resp.CommonResp;
import com.example.demo.service.AcidService;
import com.example.demo.service.AdminService;

import com.example.demo.utils.CopyUtil;
import com.example.demo.utils.JwtUtil;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.ObjectUtils;

import javax.annotation.Resource;
import java.util.List;

@Service
public class AdminImpl extends ServiceImpl<AdminMapper, AdminEntity> implements AdminService {


    @Resource
    private AdminMapper adminMapper;
    @Override
    public AdminReq adminlogin(AdminReq req, CommonResp<AdminReq> resp) {
        AdminEntity userDb = selectByAdminName(req.getUsername());
        if(ObjectUtils.isEmpty(userDb)){
            //userDb为空 用户名不存在 返回提示：用户名不存在或者密码不正确
            resp.setSuccess(false);
            resp.setMessage(BusinessExceptionCode.LOGIN_USER_ERROR.getDesc());
            System.out.println("error");
        }else{//用户存在
            if(userDb.getPassword().equals(req.getPassword())){
                //密码正确
                AdminReq adminReq = CopyUtil.copy(userDb, AdminReq.class);
                return adminReq;
            }else{
                //密码错误
                resp.setSuccess(false);
                resp.setMessage(BusinessExceptionCode.LOGIN_USER_ERROR.getDesc());

            }
        }
        return req;
    }
    public AdminEntity selectByAdminName(String loginName){
        //构造条件
        QueryWrapper<AdminEntity> wrapper = new QueryWrapper<>();
        //将前端传来的用户名和数据库用户名进行对比
        wrapper.lambda().eq(AdminEntity::getUsername,loginName);
        //发送给mapper处理看返回结果
        List<AdminEntity> userEntityList = adminMapper.selectList(wrapper);

        if(CollectionUtils.isEmpty(userEntityList)){
            //如果返回结果为空说明没有这个用户名
            return  null;
        }else {
            //如果有就返回这个用户名
            return userEntityList.get(0);
        }
    }
}

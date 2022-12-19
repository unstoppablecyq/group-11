package com.example.demo.service.impl;



import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.demo.entity.AcidEntity;
import com.example.demo.entity.SysUserEntity;
import com.example.demo.exception.BusinessExceptionCode;
import com.example.demo.mapper.SysUserMapper;
import com.example.demo.req.AcidReq;
import com.example.demo.req.SysUserLoginReq;
import com.example.demo.req.SysUserSaveReq;
import com.example.demo.req.UserChangeReq;
import com.example.demo.resp.CommonResp;
import com.example.demo.service.SysUserService;
import com.example.demo.utils.CopyUtil;
import com.example.demo.utils.JwtUtil;
import com.example.demo.utils.SnowFlake;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.DigestUtils;
import org.springframework.util.ObjectUtils;

import javax.annotation.Resource;
import java.util.List;

@Service
public class SysUserServiceImpl extends ServiceImpl<SysUserMapper, SysUserEntity> implements SysUserService {

    @Resource
    private SysUserMapper sysUserMapper;

    @Autowired
    private SnowFlake snowFlake;


    //login
    @Override
    public SysUserLoginReq login(SysUserLoginReq req, CommonResp<SysUserLoginReq> resp) {
        //先查询用户名是否存在
        SysUserEntity userDb = selectByLoginName(req.getUsername());
        if(ObjectUtils.isEmpty(userDb)){
            //userDb为空 用户名不存在 返回提示：用户名不存在或者密码不正确
            resp.setSuccess(false);
            resp.setMessage(BusinessExceptionCode.LOGIN_USER_ERROR.getDesc());
            System.out.println("error");
        }else{//用户存在
            if(userDb.getPassword().equals(req.getPassword())){
                //密码正确
                SysUserLoginReq userLoginReq = CopyUtil.copy(userDb, SysUserLoginReq.class);
                //生成token在loginreq里
                userLoginReq.setToken(JwtUtil.createToken());
                //System.out.println(userLoginReq);
                System.out.println("OK login !");
                return userLoginReq;
            }else{
                //密码错误
                resp.setSuccess(false);
                resp.setMessage(BusinessExceptionCode.LOGIN_USER_ERROR.getDesc());

            }
        }
        return req;
    }

    @Override
    public SysUserLoginReq saveuser(SysUserLoginReq req, CommonResp<SysUserLoginReq> resp) {
        //创建要插入数据库的一条数据userupdate
        SysUserEntity userupdate = CopyUtil.copy(req, SysUserEntity.class);
        //根据username找到数据库里原来的数据
        SysUserEntity userDb = selectByLoginName(req.getUsername());
        //密码转移
        userupdate.setPassword(userDb.getPassword());
        userupdate.setCheckpass(userDb.getCheckpass());
        //根据username更新数据库中那条信息
        sysUserMapper.updateById(userupdate);
        //在从数据库中拿出已经更新的数据
        SysUserEntity userDbupdate = selectByLoginName(userupdate.getUsername());
        //创建返回对象userLoginReq
        SysUserLoginReq userLoginReq = CopyUtil.copy(userDbupdate, SysUserLoginReq.class);
        //System.out.println(userLoginReq);
        return userLoginReq;
    }

    //register
    @Override
    public SysUserSaveReq register(SysUserSaveReq req, CommonResp<SysUserSaveReq> resp) {
        SysUserEntity user = CopyUtil.copy(req, SysUserEntity.class);
        //先判断id是否为空
        if(ObjectUtils.isEmpty(req.getId())){
            //查询用户名是否存在
            SysUserEntity userDb = selectByLoginName(req.getUsername());
            if(ObjectUtils.isEmpty(userDb)){
                //如果用户名没有被注册，调用雪花算法创建新增
                user.setId(snowFlake.nextId());//新增 id
                sysUserMapper.insert(user);
                System.out.println("hasn't been register! OK add a value to Mysql");
            }else{
                resp.setSuccess(false);
                resp.setMessage(BusinessExceptionCode.USER_LOGIN_NAME_EXIST.getDesc());

                System.out.println("username: "+req.getUsername()+" has been register!");
            }
        }
        return req;
    }

    @Override
    public Boolean changepass(UserChangeReq req) {
        //数据库中找出username对应数据
        SysUserEntity userDb = selectByLoginName(req.getUsername());
        //set方法更改密码已经check密码
        userDb.setCheckpass(req.getChecknewpass());
        userDb.setPassword(DigestUtils.md5DigestAsHex(req.getNewpass().getBytes()));
        //System.out.println(userDb);
        //根据id更新数据库该条数据
        sysUserMapper.updateById(userDb);
        return true;
    }


    // 查询数据库的用户名是否存在
    public SysUserEntity selectByLoginName(String loginName){
        //构造条件
        QueryWrapper<SysUserEntity> wrapper = new QueryWrapper<>();
        //将前端传来的用户名和数据库用户名进行对比
        wrapper.lambda().eq(SysUserEntity::getUsername,loginName);
        //发送给mapper处理看返回结果
        List<SysUserEntity> userEntityList = sysUserMapper.selectList(wrapper);

        if(CollectionUtils.isEmpty(userEntityList)){
            //如果返回结果为空说明没有这个用户名
            return  null;
        }else {
            //如果有就返回这个用户名
            return userEntityList.get(0);
        }
    }






}























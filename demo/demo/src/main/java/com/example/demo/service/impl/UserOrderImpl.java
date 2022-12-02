package com.example.demo.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.demo.entity.CheckbodyEntity;
import com.example.demo.entity.SysUserEntity;
import com.example.demo.entity.UserOrderEntity;
import com.example.demo.mapper.CheckbodyMapper;
import com.example.demo.mapper.UserOrderMapper;
import com.example.demo.req.UserOrderReq;
import com.example.demo.service.UserOrderService;
import com.example.demo.utils.CopyUtil;
import com.example.demo.utils.SnowFlake;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
@Service
public class UserOrderImpl extends ServiceImpl<UserOrderMapper, UserOrderEntity> implements UserOrderService {
    @Resource
    private UserOrderMapper userOrderMapper;
    @Autowired
    private SnowFlake snowFlake;
    @Override
    public Boolean deleteuserorder(UserOrderReq req) {
        UserOrderEntity userOrderReq = CopyUtil.copy(req, UserOrderEntity.class);
        userOrderMapper.deleteById(userOrderReq.getId());
        return true;
    }

    @Override
    public Boolean addusermsg(UserOrderReq req) {
        UserOrderEntity userOrderEntity = CopyUtil.copy(req ,UserOrderEntity.class);
        userOrderEntity.setId(snowFlake.nextId());//新增 id
        userOrderMapper.insert(userOrderEntity);
        return true;
    }
}

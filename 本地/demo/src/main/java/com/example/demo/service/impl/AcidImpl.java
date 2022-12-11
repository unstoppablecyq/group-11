package com.example.demo.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.demo.entity.AcidEntity;
import com.example.demo.entity.SysUserEntity;
import com.example.demo.mapper.AcidMapper;
import com.example.demo.req.AcidReq;
import com.example.demo.resp.CommonResp;
import com.example.demo.service.AcidService;
import com.example.demo.utils.CopyUtil;
import com.example.demo.utils.SnowFlake;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.List;

@Service
public class AcidImpl extends ServiceImpl<AcidMapper, AcidEntity> implements AcidService {
    @Resource
    private AcidMapper acidMapper;
    @Autowired
    private SnowFlake snowFlake;
    @Override
    public AcidReq acid(AcidReq req, CommonResp<AcidReq> resp) {
        AcidEntity acidReq = CopyUtil.copy(req, AcidEntity.class);
        acidReq.setId(snowFlake.nextId());//新增 id
        acidMapper.insert(acidReq);
        AcidReq acidReq1 = CopyUtil.copy(acidReq, AcidReq.class);
        return acidReq1;
    }

    @Override
    public Boolean delateacid(AcidReq req) {
        AcidEntity acidReq = CopyUtil.copy(req, AcidEntity.class);
        acidMapper.deleteById(acidReq.getId());
        return true;
    }
}

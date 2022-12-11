package com.example.demo.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.demo.entity.AcidEntity;
import com.example.demo.entity.CheckbodyEntity;
import com.example.demo.mapper.AcidMapper;
import com.example.demo.mapper.CheckbodyMapper;
import com.example.demo.req.AcidReq;
import com.example.demo.req.CheckbodyReq;
import com.example.demo.resp.CommonResp;
import com.example.demo.service.CheckbodyService;
import com.example.demo.utils.CopyUtil;
import com.example.demo.utils.SnowFlake;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class CheckbodyImpl extends ServiceImpl<CheckbodyMapper, CheckbodyEntity> implements CheckbodyService {
    @Resource
    private CheckbodyMapper checkbodyMapper;
    @Autowired
    private SnowFlake snowFlake;

    @Override
    public CheckbodyReq checkbody(CheckbodyReq req, CommonResp<CheckbodyReq> resp) {
        CheckbodyEntity checkReq = CopyUtil.copy(req, CheckbodyEntity.class);
        checkReq.setId(snowFlake.nextId());//新增 id
        checkbodyMapper.insert(checkReq);
        CheckbodyReq checkReq1 = CopyUtil.copy(checkReq, CheckbodyReq.class);
        return checkReq1;
    }

    @Override
    public Boolean deletecheckbody(CheckbodyReq req) {
        CheckbodyEntity checkReq = CopyUtil.copy(req, CheckbodyEntity.class);
        checkbodyMapper.deleteById(checkReq.getId());
        return true;
    }
}

package com.example.demo.service;

import com.example.demo.req.CheckbodyReq;
import com.example.demo.resp.CommonResp;

public interface CheckbodyService {
    CheckbodyReq checkbody(CheckbodyReq req, CommonResp<CheckbodyReq> resp);

    Boolean deletecheckbody(CheckbodyReq req);
}

package com.example.demo.service;

import com.example.demo.req.AcidReq;
import com.example.demo.resp.CommonResp;

public interface AcidService {

    AcidReq acid(AcidReq req, CommonResp<AcidReq> resp);
    Boolean delateacid(AcidReq req);
}

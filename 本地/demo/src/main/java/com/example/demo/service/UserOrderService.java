package com.example.demo.service;

import com.example.demo.req.UserOrderReq;

public interface UserOrderService {
    Boolean deleteuserorder(UserOrderReq req);

    Boolean addusermsg(UserOrderReq req);
}

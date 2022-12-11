package com.example.demo.Controller;

import com.example.demo.entity.AcidEntity;
import com.example.demo.entity.UserOrderEntity;
import com.example.demo.req.CheckbodyReq;
import com.example.demo.req.UserOrderReq;
import com.example.demo.resp.CommonResp;
import com.example.demo.service.SysUserService;
import com.example.demo.service.UserOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.web.bind.annotation.*;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping("/api")
public class UserOrderController {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private UserOrderService userOrderService;

    @PostMapping("getuserorder")
    public List getuserorder(@RequestBody UserOrderReq req){
        String uname = req.getUsername();
        System.out.println(uname);
        String sql="select * from userorderinfo WHERE " + "username = '"+uname+"' ";//SQL查询语句
        List<UserOrderEntity> acids = jdbcTemplate.query(sql, new RowMapper<UserOrderEntity>(){

            @Override
            public UserOrderEntity mapRow(ResultSet rs, int i) throws SQLException {
                UserOrderEntity acid = new UserOrderEntity();
                acid.setMsg(rs.getString("msg"));
                acid.setUsername(rs.getString("username"));
                acid.setId(rs.getLong("id"));
                return acid;
            }
        });
        System.out.println(acids);
        return acids;
    }
    @PostMapping("addusermsg")
    public Boolean addusermsg(@RequestBody UserOrderReq req){
        Boolean acid = userOrderService.addusermsg(req) ;
        return acid;
    }

    @PostMapping("deleteorderinfo")
    public Boolean deleteorderinfo(@RequestBody UserOrderReq req){
        Boolean acid = userOrderService.deleteuserorder(req);
        return acid;
    }

}

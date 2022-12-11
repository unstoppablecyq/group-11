package com.example.demo.Controller;

import com.example.demo.entity.AcidEntity;
import com.example.demo.req.AcidReq;
import com.example.demo.resp.CommonResp;
import com.example.demo.service.AcidService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping("/api")
public class AcidController {
    @Autowired
    private AcidService acidService;
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @PostMapping("acid")
    public CommonResp acid(@RequestBody AcidReq req){

        CommonResp<AcidReq> resp = new CommonResp<>();
        AcidReq acidReq = acidService.acid(req,resp);
        resp.setContent(acidReq);
        return resp;
    }

    @PostMapping("getnewacid")
    public List getnewacid(){

        String sql="select * from acidinfo";//SQL查询语句
        List<AcidEntity> acids = jdbcTemplate.query(sql, new RowMapper<AcidEntity>(){
            @Override
            public AcidEntity mapRow(ResultSet rs, int i) throws SQLException {
                AcidEntity acid = new AcidEntity();
                acid.setId(rs.getLong("id"));
                acid.setUsername(rs.getString("username"));
                acid.setHospital(rs.getString("hospital"));
                acid.setTimer(rs.getString("Timer"));
                acid.setHealthcode(rs.getString("Healthcode"));
                return acid;
            }
        });
        return acids;
    }

    @PostMapping("delateacid")
    public Boolean delateacid(@RequestBody AcidReq req){
        Boolean acid = acidService.delateacid(req);
        return acid;
    }
}

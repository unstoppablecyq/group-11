package com.example.demo.Controller;

import com.example.demo.entity.AcidEntity;
import com.example.demo.entity.CheckbodyEntity;
import com.example.demo.req.AcidReq;
import com.example.demo.req.CheckbodyReq;
import com.example.demo.resp.CommonResp;
import com.example.demo.service.CheckbodyService;
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
public class CheckbodyController {
    @Autowired
    private CheckbodyService checkbodyService;
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @PostMapping("checkbody")
    public CommonResp checkbody(@RequestBody CheckbodyReq req){
        CommonResp<CheckbodyReq> resp = new CommonResp<>();
        CheckbodyReq checkbodyReq = checkbodyService.checkbody(req,resp);
        resp.setContent(checkbodyReq);
        System.out.println(resp);
        return resp;
    }
    @PostMapping("getnewcheckbody")
    public List getnewcheckbody(){

        String sql="select * from checkbodyinfo";//SQL查询语句
        List<CheckbodyEntity> acids = jdbcTemplate.query(sql, new RowMapper<CheckbodyEntity>(){
            @Override
            public CheckbodyEntity mapRow(ResultSet rs, int i) throws SQLException {
                CheckbodyEntity acid = new CheckbodyEntity();
                acid.setId(rs.getLong("id"));
                acid.setUsername(rs.getString("username"));
                acid.setCheckbody_id(rs.getString("checkbody_id"));
                acid.setIseyes(rs.getString("iseyes"));
                acid.setIstooth(rs.getString("istooth"));
                acid.setAddress(rs.getString("address"));
                return acid;
            }
        });
        return acids;
    }
    @PostMapping("deletecheckbody")
    public Boolean deletecheckbody(@RequestBody CheckbodyReq req){
        Boolean check = checkbodyService.deletecheckbody(req);
        return check;
    }
}

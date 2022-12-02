package com.example.demo.Controller;
import com.example.demo.entity.SysUserEntity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Controller
public class UserController {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    @ResponseBody
    @RequestMapping(value = "/api/readsql")

    /*
     * List 里的对象是Map对象，而Map对象是
     * 由一个String类型的键和Object类型的值组成
     * */
    public List getUsers(){
        String sql="select * from logininfo";//SQL查询语句
        List <SysUserEntity> users = jdbcTemplate.query(sql, new RowMapper <SysUserEntity> (){
            @Override
            public SysUserEntity mapRow(ResultSet rs, int i) throws SQLException{
                SysUserEntity user = new SysUserEntity();
                user.setId(rs.getLong("id"));
                user.setEmail(rs.getString("email"));
                user.setUsername(rs.getString("username"));
                user.setPassword(rs.getString("password"));
                return user;
            }
        });
        System.out.println("ok found: "+users);
        return users;
    }
}
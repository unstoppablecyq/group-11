package com.example.demo.utils;

import io.jsonwebtoken.*;
import lombok.val;

import java.util.Date;
import java.util.UUID;

public class JwtUtil {
    private static long time = 1000*60*60 ; //1 h
    private static String signature = "admin";
    // create token
    public static String createToken(){
        //借助第三方依赖jwt
        JwtBuilder jwtBuilder = Jwts.builder();
        String jwtToken = jwtBuilder
                .setHeaderParam("typ","JWT")
                .setHeaderParam("alg","HS256")
                .claim("username","admin")
                .claim("role","admin")
                .setSubject("admin-test")
                .setExpiration(new Date(System.currentTimeMillis()+time))
                .setId(UUID.randomUUID().toString())
                .signWith(SignatureAlgorithm.HS256,signature)
                .compact();
        return jwtToken;
    }

    public static boolean checkToken(String token){
        if(token == null){
            return false;
        }
        try {
            val claimsJws = Jwts.parser().setSigningKey(signature).parseClaimsJws(token);
        } catch (Exception e) {
            return false;
        }
        return true ;
    }


}
























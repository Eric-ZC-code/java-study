package com.itheima;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@SpringBootTest
class TliasWebManagementApplicationTests {

    @Test
    void contextLoads() {
    }

//    @Test
//    public void signatureTest() {
//        Map<String, Object> claims = new HashMap<>();
//        claims.put("id",1);
//        claims.put("name","tom");
//
//        String jwt = Jwts.builder()
//                .signWith(SignatureAlgorithm.HS256, "itheima")
//                .setClaims(claims)
//                .setExpiration(new Date(System.currentTimeMillis() + 3600 * 1000))
//                .compact();
//        System.out.println(jwt);
//    }
//
//    @Test
//    public void signatureValidate() {
//        Claims claims = Jwts.parser()
//                .setSigningKey("itheima")
//                .parseClaimsJws("eyJhbGciOiJIUzI1NiJ9.eyJuYW1lIjoidG9tIiwiaWQiOjEsImV4cCI6MTcwMzI1Nzc1MH0.vv9fEWIetVbTK-eQE6co53La7qgFlbSQWgoSnU3PrBc")
//                .getBody();
//        System.out.println(claims);
//    }

}

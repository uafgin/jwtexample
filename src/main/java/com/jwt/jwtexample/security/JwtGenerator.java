package com.jwt.jwtexample.security;


import com.jwt.jwtexample.model.JwtUser;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import net.minidev.asm.ConvertDate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

@Component
public class JwtGenerator {
    @Autowired
    private Environment environment;
    public String generate(JwtUser jwtUser) {
        Claims claims = Jwts.claims().setSubject(String.valueOf(jwtUser.getId()));
        claims.put("eat", ConvertDate.convertToDate(jwtUser.getEat()));
        claims.put("role", jwtUser.getRole());
        claims.put("contractId", jwtUser.getContractId());
        claims.put("firstName", jwtUser.getFirstName());
        claims.put("lastName", jwtUser.getLastName());

        return Jwts.builder().setClaims(claims).signWith(SignatureAlgorithm.HS512, environment.getProperty("password")).compact();
    }
}

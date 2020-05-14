package com.jwt.jwtexample.security;
import com.jwt.jwtexample.model.JwtUser;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import net.minidev.asm.ConvertDate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;


@Component
public class JwtValidator {

    @Autowired
    private Environment environment;
    public JwtUser validate(String token) {
        JwtUser jwtUser = null;
        try {
            Claims body = Jwts.parser()
                    .setSigningKey(environment.getProperty("password"))
                    .parseClaimsJws(token)
                    .getBody();

            jwtUser = new JwtUser();

            jwtUser.setId(Long.parseLong((String) body.getSubject()));
            jwtUser.setContractId((String)body.get("contractId"));
            jwtUser.setRole((String) body.get("role"));
            jwtUser.setEat(ConvertDate.convertToDate(body.get("eat")));
            jwtUser.setFirstName((String) body.get("firstName"));
            jwtUser.setLastName((String) body.get("lastName"));
        }
        catch (Exception e) {
            System.out.println(e);
        }
        return jwtUser;
    }
}

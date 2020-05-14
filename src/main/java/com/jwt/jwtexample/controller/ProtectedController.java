package com.jwt.jwtexample.controller;
import com.jwt.jwtexample.model.JwtAuthenticationToken;
import com.jwt.jwtexample.model.JwtUser;
import com.jwt.jwtexample.security.JwtValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/info")
public class ProtectedController {
    @Autowired
    private JwtValidator validator;
    @Autowired
    private HttpServletRequest httpServletRequest;
    @PostMapping("/getInfo")
    public JwtUser GetUserInfo() {
        String header = httpServletRequest.getHeader("Authorization");
        String authenticationToken = header.substring(6);
        JwtAuthenticationToken token = new JwtAuthenticationToken(authenticationToken);
        JwtUser jwtUser = validator.validate(token.getToken());
        return jwtUser;
    }
}

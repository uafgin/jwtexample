package com.jwt.jwtexample.controller;
import com.jwt.jwtexample.DAL.DbLayer;
import com.jwt.jwtexample.model.JwtToken;
import com.jwt.jwtexample.model.JwtTokenRequest;
import com.jwt.jwtexample.security.JwtGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/token")
public class TokenController {

    @Autowired
    private Environment environment;
    private JwtGenerator jwtGenerator;

    public TokenController(JwtGenerator jwtGenerator) {
        this.jwtGenerator = jwtGenerator;
    }
    @PostMapping
    public JwtToken generate(@RequestBody final JwtTokenRequest jwtTokenRequest) {
        DbLayer dbLayer = new DbLayer();
        dbLayer.validate(jwtTokenRequest);
        JwtToken reply = new JwtToken();
        reply.setToken(jwtGenerator.generate(dbLayer.validate(jwtTokenRequest)));
        return reply;
    }
}

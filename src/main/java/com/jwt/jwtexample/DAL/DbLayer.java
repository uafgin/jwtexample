package com.jwt.jwtexample.DAL;

import com.jwt.jwtexample.model.JwtTokenRequest;
import com.jwt.jwtexample.model.JwtUser;

import java.util.Calendar;
import java.util.Date;

public class DbLayer {

    static final long ONE_MINUTE_IN_MILLIS=60000;
    static final int SESSION_TIME=20;
    public JwtUser validate(JwtTokenRequest jwtTokenRequest) {
        JwtUser jwtUser = null;
        Calendar date = Calendar.getInstance();
        long t= date.getTimeInMillis();
        if (jwtTokenRequest.getUserName().equals("udi") && jwtTokenRequest.getPassword().equals("Aa123456")) {
            jwtUser = new JwtUser();
            jwtUser.setFirstName("udi");
            jwtUser.setLastName("afgin");
            jwtUser.setId(301401734);
            jwtUser.setContractId("123456789");
            jwtUser.setEat(new Date(t + (SESSION_TIME * ONE_MINUTE_IN_MILLIS)));
        }
        else if (jwtTokenRequest.getUserName().equals("genadi") && jwtTokenRequest.getPassword().equals("Aa123456")) {
            jwtUser = new JwtUser();
            jwtUser.setFirstName("genadi");
            jwtUser.setLastName("zimerman");
            jwtUser.setId(301405732);
            jwtUser.setContractId("32145689");
            jwtUser.setEat(new Date(t + (SESSION_TIME * ONE_MINUTE_IN_MILLIS)));
        }
        if (jwtUser == null) {
            throw new RuntimeException("User or password incorrect");
        }
        return jwtUser;
    }
}

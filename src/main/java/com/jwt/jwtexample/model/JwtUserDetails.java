package com.jwt.jwtexample.model;

import net.minidev.asm.ConvertDate;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.Date;
import java.util.List;

public class JwtUserDetails implements UserDetails {

    private String token;
    private Long id;
    private Date eat;
    private Collection<? extends GrantedAuthority> authorities;

    public JwtUserDetails(long id, String token, Date eat, List<GrantedAuthority> grantedAuthorities) {
        this.id = id;
        this.token = token;
        this.authorities = grantedAuthorities;
        this.eat = eat;

    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return null;
    }

    @Override
    public String getUsername() {
        return null;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return this.eat.getTime() > new Date().getTime();
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    public String getToken() {
        return token;
    }

    public Long getId() {
        return id;
    }

    public void setAuthorities(Collection<? extends GrantedAuthority> authorities) {
        this.authorities = authorities;
    }
}

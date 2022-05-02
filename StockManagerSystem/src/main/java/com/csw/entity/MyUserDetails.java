package com.csw.entity;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

//给SpringSecurity操作的用户实体对象
public class MyUserDetails implements UserDetails {
    String username;
    String password;
    List<? extends GrantedAuthority> authorities;
    boolean enabled;


    public void setAuthorities(List<? extends GrantedAuthority> authorities) {
        this.authorities = authorities;
    }


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    //默认账户不过期
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    //默认账户不锁定
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }
    //默认密码不过期
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return enabled;
    }

    @Override
    public String toString() {
        return "MyUserDetails{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", authorities=" + authorities +
                ", enabled=" + enabled +
                '}';
    }
}

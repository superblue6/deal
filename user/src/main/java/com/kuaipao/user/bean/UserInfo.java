package com.kuaipao.user.bean;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class UserInfo implements UserDetails {
    private Integer id;
    private String userName;
    private String passWord;
    private Boolean enabled;
    private Boolean locked;
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    @Override
    public String getUsername() {
        return userName;
    }
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }
    @Override
    public boolean isAccountNonLocked() {
        return !locked;
    }
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }
    @Override
    public boolean isEnabled() {
        return enabled;
    }
    public void setUsername(String userName) {
        this.userName = userName;
    }
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
//        List<SimpleGrantedAuthority> authorities = new ArrayList<>();
//        for (Role role : roles) {
//            authorities.add(new SimpleGrantedAuthority("ROLE_"+role.getName()));
//        }
        return null;
    }
    @Override
    public String getPassword() {
        return passWord;
    }
    public void setPassword(String passWord) {
        this.passWord = passWord;
    }
    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }
    public void setLocked(Boolean locked) {
        this.locked = locked;
    }
}

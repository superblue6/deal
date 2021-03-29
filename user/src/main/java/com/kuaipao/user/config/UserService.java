package com.kuaipao.user.config;

import com.kuaipao.user.bean.UserInfo;
import com.kuaipao.user.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserService implements UserDetailsService {
    @Autowired
    private UserMapper userMapper;
    @Override
    public UserDetails loadUserByUsername(String id) throws UsernameNotFoundException {
        UserInfo user = userMapper.loadUserByUsername(id);
        if (user == null){
            throw new UsernameNotFoundException("账户不存在");
        }
        return user;
    }
}

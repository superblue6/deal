package com.kuaipao.user.utils;

import com.kuaipao.user.bean.UserInfo;
import org.springframework.stereotype.Component;

@Component
public class UserInfoUtil {
    public UserInfo getUserInfo(){
        Integer id=001;
        String userName="test";
        UserInfo userInfo = new UserInfo();
        userInfo.setId(001);
        userInfo.setUsername(userName);
        return userInfo;
    }
}

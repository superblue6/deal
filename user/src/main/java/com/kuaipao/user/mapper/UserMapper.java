package com.kuaipao.user.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.kuaipao.user.bean.Role;
import com.kuaipao.user.bean.UserInfo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface UserMapper {
    UserInfo loadUserByUsername(String username);
    List<Role> getUserRolesById(Integer id);
    UserInfo getUserById(String id);
}

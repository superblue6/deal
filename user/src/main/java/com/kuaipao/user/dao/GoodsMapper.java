package com.kuaipao.user.dao;

import com.kuaipao.user.bean.Cat;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface GoodsMapper {
    List<Cat> getGoodsCat(String id);
}

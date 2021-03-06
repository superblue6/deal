package com.kuaipao.user.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.kuaipao.user.bean.Cat;
import com.kuaipao.user.bean.DealItem;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
@Mapper
public interface GoodsMapper extends BaseMapper<DealItem> {
    List<Cat> getGoodsCat(String id);

    List<Map<Object, String>> getOldLevel();

    List<Map<String,Integer>> getTop(@Param("number") Integer number);

    List<DealItem> getTopGoods(@Param("ids") List<Integer> ids);
}

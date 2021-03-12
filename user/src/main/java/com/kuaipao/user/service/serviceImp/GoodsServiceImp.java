package com.kuaipao.user.service.serviceImp;

import com.kuaipao.user.bean.Cat;
import com.kuaipao.user.bean.common.Result;
import com.kuaipao.user.dao.GoodsMapper;
import com.kuaipao.user.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GoodsServiceImp implements GoodsService {
    @Autowired
    private GoodsMapper goodsMapper;
    @Override
    public Result getGoodsCat(String id) {
        return new Result(loop("0"));
    }
    public List<Cat> loop(String id) {
        List<Cat> goodsCat = goodsMapper.getGoodsCat(id);
        if (goodsCat != null) {
            for (Cat cat : goodsCat) {
                cat.setChildren(loop(cat.getId()));
            }
        }
        return goodsCat;
    }
}

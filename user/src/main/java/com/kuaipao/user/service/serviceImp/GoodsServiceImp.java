package com.kuaipao.user.service.serviceImp;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.kuaipao.commen.utils.OssTemplate;
import com.kuaipao.user.bean.Cat;
import com.kuaipao.user.bean.DealItem;
import com.kuaipao.user.bean.common.Result;
import com.kuaipao.user.mapper.GoodsMapper;
import com.kuaipao.user.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public  class GoodsServiceImp extends ServiceImpl<GoodsMapper, DealItem> implements GoodsService {
    @Autowired
    private GoodsMapper goodsMapper;
    @Autowired
    private OssTemplate ossTemplate;
    @Override
    public Result getGoodsCat(String id) {
        return new Result(loop("0"));
    }

    @Override
    public Result getOldLevel() {
        List<Map<Object,String>> list= goodsMapper.getOldLevel();
        return new Result(list);
    }
    //递归查询商品分类
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

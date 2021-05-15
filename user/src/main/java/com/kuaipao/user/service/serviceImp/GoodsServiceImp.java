package com.kuaipao.user.service.serviceImp;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.kuaipao.user.bean.Cat;
import com.kuaipao.user.bean.DealItem;
import com.kuaipao.user.bean.DealUserContact;
import com.kuaipao.user.bean.common.Result;
import com.kuaipao.user.mapper.DealUserContactMapper;
import com.kuaipao.user.mapper.GoodsMapper;
import com.kuaipao.user.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public  class GoodsServiceImp extends ServiceImpl<GoodsMapper, DealItem> implements GoodsService {
    @Autowired
    private GoodsMapper goodsMapper;

    @Autowired
    private DealUserContactMapper userContactMapper;

    @Override
    public Result getGoodsCat(String id) {
        return new Result(loop("0"));
    }

    @Override
    public Result getOldLevel() {
        List<Map<Object,String>> list= goodsMapper.getOldLevel();
        return new Result(list);
    }

    @Override
    public Result getTopGoods(Integer number) {
        List<Map<String, Integer>> list = goodsMapper.getTop(number);
        List<Integer> ids = list.stream().map(item -> item.get("id")).collect(Collectors.toList());
        List<DealItem> topGoods = goodsMapper.getTopGoods(ids);
        for (DealItem item : topGoods) {
            String picturesUrls = item.getPicturesUrl();
            String[] url = picturesUrls.split(",");
            item.setPicturesUrl(url[0]);
        }
        return new Result(topGoods);
    }

    @Override
    public Result getGoodsDetail(String id) {
        Map<String, Object> data = new HashMap<>();
        DealItem dealItem = baseMapper.selectById(id);
        DealUserContact userContact = userContactMapper.selectById(dealItem.getSellerId());
        data.put("dalItem",dealItem);
        data.put("userContact",userContact);
        Result<Object> result = new Result<>();
        result.setBean(data);
        return result;
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

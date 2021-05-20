package com.kuaipao.user.service.serviceImp;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.kuaipao.user.bean.*;
import com.kuaipao.user.bean.common.Result;
import com.kuaipao.user.mapper.DealItemScoreMapper;
import com.kuaipao.user.mapper.DealUserContactMapper;
import com.kuaipao.user.mapper.GoodsMapper;
import com.kuaipao.user.mapper.UserMapper;
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

    @Autowired
    private DealItemScoreMapper dealItemSorceMapper;

    @Autowired
    private UserMapper userMapper;

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
            String picturesUrls = item.getPicturesurl();
            String[] url = picturesUrls.split(",");
            item.setPicturesurl(url[0]);
        }
        return new Result(topGoods);
    }

    @Override
    public Result getGoodsDetail(String id) {
        Map<String, Object> data = new HashMap<>();
        DealItem dealItem = baseMapper.selectById(id);
        DealUserContact userContact = userContactMapper.selectById(dealItem.getSellerId());
        DealItemScore itemScore = dealItemSorceMapper.selectById(id);
        itemScore.setItemVisit(itemScore.getItemVisit()+1);
        dealItemSorceMapper.updateById(itemScore);
        UserInfo user = userMapper.getUserById(dealItem.getSellerId());
        Map<String, Object> map = new HashMap<>(2);
        map.put("contact",userContact);
        map.put("userName",user.getUsername());
        data.put("dalItem",dealItem);
        data.put("userContact",map);
        Result<Object> result = new Result<>();
        result.setBean(data);
        return result;
    }

    @Override
    public Result setScore(String id, String number) {
        DealItemScore itemSorce = dealItemSorceMapper.selectById(id);
        float oScore = Float.parseFloat(itemSorce.getItemSorce());
        int time = Integer.parseInt(itemSorce.getItemSorceTime())+1;
        float nu = Float.parseFloat(number);
        float nScore = nu+oScore;
        itemSorce.setItemSorce(String.format("%.1f",nScore)).setItemSorceTime((Integer.parseInt(itemSorce.getItemSorceTime())+1)+"");
        int res = dealItemSorceMapper.updateById(itemSorce);
        if (res>0){
            return new Result("successful");
        }
        Result<Object> result = new Result<>();
        result.setReturnCode("111");
        result.setReturnMessage("更新评分失败");
        return result;
    }

    @Override
    public Result initScore(String id) {
        DealItemScore itemScore = new DealItemScore();
        itemScore.setItemId(Integer.valueOf(id));
        int i = dealItemSorceMapper.insert(itemScore);
        return new Result(i);
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

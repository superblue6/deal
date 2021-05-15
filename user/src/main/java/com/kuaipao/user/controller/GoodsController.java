package com.kuaipao.user.controller;

import com.alibaba.fastjson.JSON;

import com.kuaipao.commen.utils.OssTemplate;
import com.kuaipao.user.bean.DealItem;
import com.kuaipao.user.bean.UserInfo;
import com.kuaipao.user.bean.common.Result;
import com.kuaipao.user.service.GoodsService;
import com.kuaipao.user.utils.UserInfoUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/goods")
public class GoodsController {
    @Autowired
    private GoodsService goodsService;
    @Autowired
    private OssTemplate ossTemplate;
    @Autowired
    private UserInfoUtil userInfoUtil;

    @GetMapping("/getGoodsCat")
    public Result getGoodsCat(){
        return goodsService.getGoodsCat("");
    }
    @GetMapping("/getOldLevel")
    public Result getOldLevel(){
        return goodsService.getOldLevel();
    }
    @PostMapping("/addGoods")
    public Result addGoods(@RequestParam("pictures") MultipartFile[] files,@RequestParam("goods") String json) throws IOException {
        UserInfo userInfo = userInfoUtil.getUserInfo();
        DealItem goods= JSON.parseObject(json,DealItem.class);
        List<String> list=new ArrayList<>();
        if (files!=null&&files.length>0){
            for (MultipartFile item : files) {
                if (!item.isEmpty()){
                    String url = ossTemplate.upload(item.getInputStream(), item.getOriginalFilename());
                    list.add(url);
                }
            }
        };
        String urls = list.stream().collect(Collectors.joining(","));
        goods.setPicturesUrl(urls);
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        goods.setCreateTime(LocalDateTime.now()).setStatus("0").setSellerId(userInfo.getId().toString());
        boolean save = goodsService.save(goods);
        if (save){
            return new Result();
        }else {
            Result result = new Result();
            result.setReturnCode("500");
            result.setReturnMessage("保存商品失败");
            return result;
        }
    }
    @GetMapping("/getTopGoods")
    public Result getTopGoods(@RequestParam("number") Integer number){
        List<Integer> integers = new ArrayList<>();
        return goodsService.getTopGoods(number);
    }
    @GetMapping("/getGoodsDetail")
    public Result getGoodsDetail(@RequestParam("id")String id){
        return goodsService.getGoodsDetail(id);
    }
}

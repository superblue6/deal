package com.kuaipao.user.controller;

import com.kuaipao.user.bean.common.Result;
import com.kuaipao.user.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/goods")
public class GoodsController {
    @Autowired
    private GoodsService goodsService;
    @GetMapping("/getGoodsCat")
    public Result getGoodsCat(){
        return goodsService.getGoodsCat("");
    }
}

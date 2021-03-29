package com.kuaipao.user.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.kuaipao.user.bean.DealItem;
import com.kuaipao.user.bean.common.Result;

public interface GoodsService extends IService<DealItem> {
    Result getGoodsCat(String id);

    Result getOldLevel();
}

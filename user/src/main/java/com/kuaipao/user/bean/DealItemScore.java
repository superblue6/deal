package com.kuaipao.user.bean;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author jiangnan
 * @since 2021-05-18
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class DealItemScore implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 商品id
     */
    @TableId(value = "item_id",type = IdType.NONE)
    private Integer itemId;

    /**
     * 商品被浏览次数
     */
    private Integer itemVisit;

    /**
     * 商品被喜欢次数
     */
    private Integer itemLike;

    /**
     * 商品评分
     */
    private String itemSorce;

    /**
     * 商品被评分次数
     */
    private String itemSorceTime;


}

package com.kuaipao.user.bean;

import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * <p>
 * 商品表
 * </p>
 *
 * @author kuaipao
 * @since 2021-03-26
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class DealItem implements Serializable {

    private static final long serialVersionUID = 1L;

    private String id;

    /**
     * 商品标题
     */
    private String title;

    /**
     * 商品新旧程度
     */
    private Integer oldLevel;

    /**
     * 商品卖点
     */
    private String sellPoint;

    /**
     * 商品价格，单位为：元
     */
    private BigDecimal price;

    /**
     * 库存数量
     */
    private Integer num;

    /**
     * 商品图片
     */
    @TableField("picturesUrl")
    private String picturesUrl;

    /**
     * 所属类目，叶子类目
     */
    @TableField("categoryId")
    private Long categoryId;

    /**
     * 商品状态，1-正常，2-下架，3-删除
     */
    private String status;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 更新时间
     */
    private LocalDateTime updateTime;

    /**
     * 用户id
     */
    private String sellerId;

    /**
     * 描述
     */
    private String des;
}

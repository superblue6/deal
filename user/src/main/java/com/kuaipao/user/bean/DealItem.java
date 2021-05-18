package com.kuaipao.user.bean;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 商品表
 * </p>
 *
 * @author jobob
 * @since 2021-05-16
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class DealItem implements Serializable {

    private static final long serialVersionUID = 1L;
    /**
     * 商品id，同时也是商品编号
     */
    @TableId(value = "id", type = IdType.AUTO)
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
    private String picturesurl;

    /**
     * 所属类目，叶子类目
     */
    @TableField("categoryId")
    private Long categoryid;

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

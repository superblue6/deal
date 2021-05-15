package com.kuaipao.user.bean;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author kuaipao
 * @since 2021-04-12
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("deal_user_contact")
public class DealUserContact implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 用户id
     */
    @TableId("userId")
    private Integer userId;

    /**
     * 用户手机号
     */
    private String phone;

    /**
     * 微信号
     */
    private String wechat;

    /**
     * QQ号
     */
    private String qq;


}

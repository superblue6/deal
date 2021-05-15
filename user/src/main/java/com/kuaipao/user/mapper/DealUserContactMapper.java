package com.kuaipao.user.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.kuaipao.user.bean.DealUserContact;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;


/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author kuaipao
 * @since 2021-04-12
 */
@Repository
@Mapper
public interface DealUserContactMapper extends BaseMapper<DealUserContact> {

}

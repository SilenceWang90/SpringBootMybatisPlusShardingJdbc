package com.wp.mapper;

import com.wp.entity.NoSharding;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * @author wangpeng
 * @description NoShardingMapper
 * @date 2024/11/24 16:24
 **/
public interface NoShardingMapper {
    @Select("select * from no_sharding where id = #{id}")
    NoSharding selectNoSharding(@Param("id") Integer id);
}

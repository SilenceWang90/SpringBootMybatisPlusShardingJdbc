package com.wp.mapper;

import com.wp.entity.NoSharding;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author wangpeng
 * @description NoShardingMapper
 * @date 2024/11/24 16:24
 **/
public interface NoShardingMapper {
    @Select("select * from no_sharding where id = #{id}")
    NoSharding selectNoSharding(@Param("id") Integer id);

    @Select("select no_sharding.* from no_sharding inner join test on test.id = no_sharding.id where test.id = #{id}")
    List<NoSharding> selectWithJoin(@Param("id") Integer id);
}

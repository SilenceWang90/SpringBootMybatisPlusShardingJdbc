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

    // 以下未生效，但是感觉是配置或者是版本的问题，同样的见过生效的
//    @Select("select no_sharding.* from no_sharding left join test on test.id = no_sharding.id and test.id = #{id}")
    @Select("select no_sharding.* from no_sharding inner join test on test.id = no_sharding.id where test.id = #{id}")
    List<NoSharding> selectWithJoin(@Param("id") Integer id);
}

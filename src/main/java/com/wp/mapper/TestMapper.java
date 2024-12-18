package com.wp.mapper;

import com.wp.entity.TestEntity;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * @author wangpeng
 * @description TestMapper
 * @date 2024/11/24 15:52
 **/
public interface TestMapper {
    @Select("select * from test where id = #{id}")
    TestEntity selectById(@Param("id") Integer id);

    @Select("select * from test where name = #{name}")
    TestEntity selectByName(@Param("name") String name);
}

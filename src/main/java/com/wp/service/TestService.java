package com.wp.service;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.wp.entity.TestEntity;
import org.apache.ibatis.annotations.Param;

/**
 * @author wangpeng
 * @description TestService
 * @date 2024/11/24 18:26
 **/
public interface TestService {
    TestEntity selectById(@Param("id") Integer id);
}

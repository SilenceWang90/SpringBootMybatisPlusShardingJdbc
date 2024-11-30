package com.wp.service.impl;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.wp.entity.TestEntity;
import com.wp.mapper.TestMapper;
import com.wp.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author wangpeng
 * @description TestServiceImpl
 * @date 2024/11/24 18:26
 **/
@Service
public class TestServiceImpl implements TestService {
    @Autowired
    private TestMapper testMapper;
    @DS("sharding")
    @Override
    public TestEntity selectById(Integer id) {
        return testMapper.selectById(id);
    }
}

package com.wp.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @author wangpeng
 * @description TestEntity
 * @date 2024/11/24 15:50
 **/
@Data
@TableName("Test")
public class TestEntity {
    @TableId
    private int id;

    private String name;

    private int age;
}

package com.wp.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @author wangpeng
 * @description NoSharding
 * @date 2024/11/24 16:16
 **/
@Data
@TableName("no_sharding")
public class NoSharding {
    private int id;
    private String name;
}

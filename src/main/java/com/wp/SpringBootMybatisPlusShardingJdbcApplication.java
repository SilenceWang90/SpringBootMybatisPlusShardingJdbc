package com.wp;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author wangpeng
 * @description SpringBootMybatisPlusShardingJdbcApplication
 * @date 2024/11/24 09:13
 **/
@SpringBootApplication
@MapperScan("com.wp.mapper")
public class SpringBootMybatisPlusShardingJdbcApplication {
    public static void main(String[] args) {
        SpringApplication.run(SpringBootMybatisPlusShardingJdbcApplication.class, args);
    }
}

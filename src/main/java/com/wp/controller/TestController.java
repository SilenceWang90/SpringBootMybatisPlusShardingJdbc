package com.wp.controller;

import com.wp.entity.NoSharding;
import com.wp.entity.TestEntity;
import com.wp.mapper.NoShardingMapper;
import com.wp.mapper.TestMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author wangpeng
 * @description TestController
 * @date 2024/11/24 12:12
 **/
@RestController
@RequestMapping("test")
public class TestController {
    @Autowired
    private TestMapper testMapper;
    @Autowired
    private NoShardingMapper NoShardingMapper;

    /**
     * 分表的表，用分表字段。只查对应路由的表的信息
     * @param id
     * @return
     */
    @GetMapping("selectById")
    public TestEntity selectById(@RequestParam("id") int id) {
        return testMapper.selectById(id);
    }

    /**
     * 分表的表，但是未用分表字段。全部的表都查一边然后聚合
     * @param name
     * @return
     */
    @GetMapping("selectByName")
    public TestEntity selectByName(@RequestParam("name") String name) {
        return testMapper.selectByName(name);
    }

    /**
     * 对不做分表的表进行查询，且如果shardingjdbc有多个数据源时，一定要配置默认的数据源。除非shardingjdbc的配置中只有一个数据源的时候不需要此配置！！！
     * 因为不分表的表没有分表策略，shardingjdbc不知道多个数据源中用哪个数据源对该表进行查询。
     * spring.shardingsphere.sharding.default-data-source-name=可以设置已经配置的ds1或者ds2
     * @param id
     * @return
     */
    @GetMapping("selectNoSharding")
    public NoSharding selectNoSharding(@RequestParam("id") int id) {
        return NoShardingMapper.selectNoSharding(id);
    }

    /**
     * 分表字段要写在where条件中才会生效，写在on中不生效
     * @param id
     * @return
     */
    @GetMapping("selectWithJoin")
    public List<NoSharding> selectWithJoin(@RequestParam("id") int id){
        return NoShardingMapper.selectWithJoin(id);
    }

}

package com.wp.controller;

import com.baomidou.dynamic.datasource.annotation.DS;
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
     * 不做分表的表查询。一定要配置默认的数据源！！！spring.shardingsphere.sharding.default-data-source-name=可以设置已经配置的ds1或者ds2
     * @param id
     * @return
     */
    @GetMapping("selectNoSharding")
    public NoSharding selectNoSharding(@RequestParam("id") int id) {
        return NoShardingMapper.selectNoSharding(id);
    }

    /**
     * 分表字段在on中也生效，即只要是分表的字段，本例子是test的id字段，无论在where还是join的on条件中，任意地方指明test.id=#{}都可以使得分表策略生效
     * @param id
     * @return
     */
    @GetMapping("selectWithJoin")
    public List<NoSharding> selectWithJoin(@RequestParam("id") int id){
        return NoShardingMapper.selectWithJoin(id);
    }

    /**
     * 范围查询，必须开启allow-range-query-with-inline-sharding: true，否则between > < >= <=等在执行时会报错。
     * in严格意义不算范围查询，是有明确值的。shardingjdbc在处理范围查询的时候是通过union all将所有分表的数据集合起来，效率其实不高，所以尽量避免范围查询sql。
     * @return
     */
    @GetMapping("selectInRange")
    public List<TestEntity> selectInRange(){
        return testMapper.selectInRange();
    }


    @DS("another-db")
    @GetMapping("/selectByDynamicDatasource")
    public List<TestEntity> selectByDynamicDatasource(@RequestParam("id") int id){
        return testMapper.selectAnotherData();
    }
}

package com.mfanw.pear.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.druid.support.json.JSONUtils;
import com.google.common.collect.Maps;
import com.mfanw.pear.biz.IUserBiz;
import com.mfanw.pear.dto.UserDto;

/**
 * <b>第一个测试的Controller</b>
 * <p>
 * 仅仅需要添加 @RestController 即可提供服务<br />
 * 首先启动 @SpringBootApplication 然后请求http://localhost:8080/test
 * </p>
 * 
 * @version 2017年12月8日 上午11:15:42
 * @author mengwei
 */
@RestController
public class TestController {

    @Autowired
    private IUserBiz userBiz;

    @RequestMapping("/test")
    public String hello() {
        return "Hello World! It's a test Controller!";
    }

    @RequestMapping("/getUserList")
    public String getUserList() {
        List<UserDto> users = userBiz.getList(new HashMap<String, Object>());
        return users.toString();
    }

    @RequestMapping("/BoleTool/executeRedis.json")
    @ResponseBody
    public String exe() {
        Map<String, Object> map = Maps.newHashMap();
        map.put("flag", 1);
        map.put("data", "haha");
        return JSONUtils.toJSONString(map);
    }
}

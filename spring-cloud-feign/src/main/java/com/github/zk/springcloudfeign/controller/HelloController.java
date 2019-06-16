package com.github.zk.springcloudfeign.controller;

import com.github.zk.springcloudfeign.remote.EurekaClientFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zhaokai
 * @date 2019/6/15 下午5:57
 */
@RestController
public class HelloController {
    @Autowired
    private EurekaClientFeign eurekaClientFeign;
    @RequestMapping("/hello")
    public String helloMethod(@RequestParam String name) {
        return eurekaClientFeign.sayHiFromClientEureka(name);
    }
}

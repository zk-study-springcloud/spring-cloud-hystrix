package com.github.zk.springcloudeurekaclient.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zhaokai
 * @date 2019/6/9 上午10:18
 */
@RestController
public class HelloController {
    @Value("${server.port}")
    private int port;
    @RequestMapping("/hello")
    public String helloMethod(@RequestParam String name) throws Exception {
        return "hi ," + name + ":I`m port["+ port +"]";
    }
}

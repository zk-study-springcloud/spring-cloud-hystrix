package com.github.zk.springcloudribbon.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author zhaokai
 * @date 2019/6/9 上午10:38
 */
@RestController
public class HelloController {
    @Autowired
    private RestTemplate restTemplate;
    @RequestMapping("/hello")
    @HystrixCommand(fallbackMethod = "helloError" )
    public String helloMethod(@RequestParam String name) {
        String result = restTemplate.getForObject("http://eureka-client/hello?name=" + name, String.class);
        return result;
    }
    public String helloError(String name) {
        return "hi~" + name + ",sorry error";
    }
}

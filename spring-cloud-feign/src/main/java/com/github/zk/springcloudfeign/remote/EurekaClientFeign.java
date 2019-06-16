package com.github.zk.springcloudfeign.remote;

import com.github.zk.springcloudfeign.configuration.FeignConfig;
import com.github.zk.springcloudfeign.hystrix.HiHystrix;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author zhaokai
 * @date 2019/6/15 上午11:40
 */
@FeignClient(value = "eureka-client", configuration = FeignConfig.class, fallback = HiHystrix.class)
public interface EurekaClientFeign {
    @RequestMapping("/hello")
    String sayHiFromClientEureka(@RequestParam(value = "name") String name);
}

package com.github.zk.springcloudfeign.hystrix;

import com.github.zk.springcloudfeign.remote.EurekaClientFeign;
import org.springframework.stereotype.Component;

/**
 * @author zhaokai
 * @date 2019/6/15 下午2:35
 */
@Component
public class HiHystrix implements EurekaClientFeign {
    @Override
    public String sayHiFromClientEureka(String name) {
        return "hi," + name + ",sorry error";
    }
}

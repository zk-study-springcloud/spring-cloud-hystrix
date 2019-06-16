# spring-cloud-hystrix
第 8 章 熔断器 Hystrix，根据Greenwich.SR1版本对本书部分配置作出调整
## 配置Hystrix Dashboard注意
### 1.pom依赖
引入hystrix依赖需要由
```
<dependency>
    <groupId>org.springframework.cloud</groupId>
    <artifactId>spring-cloud-starter-hystrix</artifactId>
</dependency>
```
调整为
```
<dependency>
    <groupId>org.springframework.cloud</groupId>
    <artifactId>spring-cloud-starter-netflix-hystrix</artifactId>
</dependency>
```
引入Hystrix-Dashboard依赖由
```
<dependency>
    <groupId>org.springframework.cloud</groupId>
    <artifactId>spring-cloud-starter-hystrix-dashboard</artifactId>
</dependency>
```
调整为
```
<dependency>
    <groupId>org.springframework.cloud</groupId>
    <artifactId>spring-cloud-starter-netflix-hystrix-dashboard</artifactId>
</dependency>
```
均需要加入netflix
### 2.集成Hystrix Dashboard后无法访问hystrix.stream路径
增加配置类，注入ServletRegistrationBean
```
@Configuration
public class HystrixDashboardConfig {
    @Bean
    public ServletRegistrationBean hystrixMetricsStreamServlet() {
        ServletRegistrationBean registrationBean = new ServletRegistrationBean(new HystrixMetricsStreamServlet());
        registrationBean.setLoadOnStartup(1);
        registrationBean.addUrlMappings("/hystrix.stream");
        return registrationBean;
    }
}
```
### 3.监控界面一直loading
请求带有Hystrix标记的方法，监控界面就会加载出内容了
## 疑惑
官网描述：对特定（有hystrix标记）请求超过一定次数（默认20次），在滑动窗口（默认10s）内，失败率大于阈值（默认50%）时，开启熔断器。
实际情况，只要失败一次就会开启断路器。

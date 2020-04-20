package com.hucheng;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author HuChan
 */
@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
//启动服务降级服务
@EnableHystrix
public class OrderHystrixMain81 {
    public static void main(String[] args) {
        SpringApplication.run(OrderHystrixMain81.class, args);
    }
}

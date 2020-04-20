package com.hucheng.controller;

import com.hucheng.bean.CommonResult;
import com.hucheng.bean.Payment;
import com.hucheng.loadbalance.LoadBalancer;
import com.netflix.discovery.converters.Auto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.List;

/**
 * @author HuChan
 */
@Slf4j
@RequestMapping("/order")
@RestController
public class OrderController {

    public static final String PAYMENT_URL = "http://CLOUD-PAYMENT-SERVICE";

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private DiscoveryClient discoveryClient;

    @Autowired
    LoadBalancer loadBalancer;

//    @GetMapping("/{id}")
//    public CommonResult get(@PathVariable Long id){
//        log.info("-----远程调用支付服务中-----");
//        return restTemplate.getForObject(PAYMENT_URL+"/payment/"+id,CommonResult.class);
//    }
    @GetMapping("/{id}")
    public CommonResult get(@PathVariable Long id){
        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
        if (instances ==null &&instances.size()<0){
            return new CommonResult(200,"",null);
        }
        ServiceInstance instance = loadBalancer.instance(instances);
        URI uri = instance.getUri();
        log.info("-----远程调用支付服务中-----");
        return restTemplate.getForObject(uri+"/payment/"+id,CommonResult.class);
    }

    @PostMapping
    public CommonResult insert( Payment payment){
        log.info("-----远程调用支付服务中-----");
        return restTemplate.postForObject(PAYMENT_URL+"/payment",payment,CommonResult.class);
    }
}

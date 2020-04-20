package com.hucheng.controller;


import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;

import org.springframework.web.bind.annotation.*;

import java.util.UUID;

/**
 * @author HuChan
 */
@Slf4j
@RestController
@RequestMapping("/payment")
public class PaymentController {

    @Value("${server.port}")
    private String port;

    @RequestMapping(value = "/zk")
    public String paymentzk() {
        return "springcloud with zookeeper:" + port + "\t"
                + UUID.randomUUID().toString();
    }
}

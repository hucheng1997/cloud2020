package com.hucheng.controller;

import com.hucheng.bean.CommonResult;
import com.hucheng.bean.Payment;
import com.hucheng.service.PaymentFeignService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author HuChan
 */
@Slf4j
@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    PaymentFeignService paymentFeignService;

    @GetMapping("/{id}")
    public CommonResult get(@PathVariable Long id) {
        log.info("-----feign远程调用支付服务中-----");
        CommonResult result = paymentFeignService.get(id);
        return result;
    }

    @PostMapping
    public CommonResult get(Payment payment) {
        log.info("-----feign远程调用支付服务中-----");
        CommonResult result = paymentFeignService.insert(payment);
        return result;
    }
}



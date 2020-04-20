package com.hucheng.service;

import com.hucheng.bean.CommonResult;
import com.hucheng.bean.Payment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * @author HuChan
 */
@FeignClient("cloud-payment-service")
public interface PaymentFeignService {
    @GetMapping("/payment/{id}")
    CommonResult get(@PathVariable("id") Long id);

    @PostMapping("/payment")
    CommonResult insert(@RequestBody Payment payment);
}

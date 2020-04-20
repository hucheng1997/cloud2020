package com.hucheng.service;

import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

/**
 * @author HuChan
 */
@Component
public class PaymentFallbackService implements FallbackFactory<PaymentService> {
    @Override
    public PaymentService create(Throwable cause) {
        return new PaymentService() {
            @Override
            public String paymentInfo_OK(Integer id) {
                return "paymentInfo_OK()方法远程调用失败，服务降级";
            }

            @Override
            public String paymentInfo_Timeout(Integer id) {
                return "paymentInfo_Timeout()方法远程调用失败，服务降级";
            }
        };
    }
}

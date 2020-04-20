package com.hucheng.controller;

import com.hucheng.bean.CommonResult;
import com.hucheng.bean.Payment;
import com.hucheng.service.IPaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

/**
 * @author HuChan
 */
@Slf4j
@RestController
@RequestMapping("/payment")
public class PaymentController {

    @Autowired
    private IPaymentService paymentService;

    @Value("${server.port}")
    private String port;

    @PostMapping
    public CommonResult insert(@RequestBody Payment payment){
        int result = paymentService.create(payment);
        log.info("****插入结果:" + result);
        if(result > 0){
            return  new CommonResult(200,"插入数据库成功",result);
        } else {
            return new CommonResult(444,"插入数据库失败",null);
        }
    }

    @GetMapping("/{id}")
    public CommonResult get(@PathVariable Long id){
        Payment payment = paymentService.getPaymentById(id);
        Map<String, Object> map = new HashMap<>();
        map.put("payment",payment);
        map.put("port",port);
        log.info("****插入结果:" + payment);
        if(payment != null){
            return  new CommonResult(200,"查询成功",map);
        } else {
            return new CommonResult(444,"没有对应记录，查询ID: " + id,null);
        }
    }

}

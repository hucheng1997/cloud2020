package com.hucheng.service;

import com.hucheng.bean.Payment;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

/**
 * @author HuChan
 */
public interface IPaymentService {
    public int create(Payment payment);

    public Payment getPaymentById(@Param("id") Long id);

}

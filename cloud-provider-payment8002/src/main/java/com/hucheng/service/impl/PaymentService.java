package com.hucheng.service.impl;

import com.hucheng.bean.Payment;
import com.hucheng.dao.PaymentDao;
import com.hucheng.service.IPaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author HuChan
 */
@Service
public class PaymentService implements IPaymentService {

    @Autowired
    private PaymentDao paymentDao;

    @Override
    public int create(Payment payment) {
        return paymentDao.create(payment);
    }

    @Override
    public Payment getPaymentById(Long id) {
        return paymentDao.getPaymentById(id);
    }
}

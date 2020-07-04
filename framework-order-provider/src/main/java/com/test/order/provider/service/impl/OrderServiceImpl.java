package com.test.order.provider.service.impl;

import com.test.common.entities.CommonResult;
import com.test.order.provider.service.OrderService;
import com.test.payment.api.bo.PaymentBo;
import com.test.payment.client.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl implements OrderService {

    // 使用Feign，测试微服务调用
    @Autowired
    private PaymentService paymentService;

    @Override
    public CommonResult get(Long id) {
        PaymentBo paymentBo = new PaymentBo();
        paymentBo.setId(id);
        return paymentService.get(paymentBo);
    }
}

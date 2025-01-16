package com.test.order.provider.service.impl;

import com.test.common.entity.CommonResult;
import com.test.order.provider.service.OrderService;
import com.test.payment.api.dto.PaymentReqDto;
import com.test.payment.client.PaymentClient;
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

        PaymentReqDto paymentReqDto = new PaymentReqDto();
        paymentReqDto.setId(id);

        // 方法一，使用Feign直接调用
//        return paymentService.get(paymentBo);
        // 方法二，使用业务提供的Client调用
        return PaymentClient.get(paymentReqDto);

    }
}

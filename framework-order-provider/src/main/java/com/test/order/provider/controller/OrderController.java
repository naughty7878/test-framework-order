package com.test.order.provider.controller;

import com.test.common.entity.CommonResult;
import com.test.order.api.bo.OrderBo;
import com.test.order.api.service.OrderRemoteService;
import com.test.order.provider.service.OrderService;
import com.test.payment.api.dto.PaymentRespDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController implements OrderRemoteService {

    @Autowired
    private OrderService orderService;
    @Override
    public CommonResult<PaymentRespDto> get(@RequestBody OrderBo orderBo) {
        return orderService.get(orderBo.getId());
    }
}

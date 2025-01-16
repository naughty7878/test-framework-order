package com.test.order.api.service;

import com.test.common.entity.CommonResult;
import com.test.order.api.bo.OrderBo;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

public interface OrderRemoteService {

    @RequestMapping(value = {"consumer/payment/get"}, method = {RequestMethod.POST})
    public CommonResult<?> get(@RequestBody OrderBo orderBo);
}

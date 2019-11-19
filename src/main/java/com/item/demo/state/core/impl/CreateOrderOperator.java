package com.item.demo.state.core.impl;

import com.item.demo.state.AbstractOrderOperator;
import com.item.demo.state.constant.OrderStatusEnum;
import com.item.demo.state.core.annotation.OrderOperator;
import org.springframework.stereotype.Component;

@OrderOperator
@Component
public class CreateOrderOperator extends AbstractOrderOperator {

    public CreateOrderOperator() {
        super.setStatus(1);
    }

    @Override
    public int handleEvent(int orderStatus, OrderStatusEnum orderStatusEnum) {
        if (orderStatus!=OrderStatusEnum.CREATE_EVENT.status && orderStatus!=OrderStatusEnum.ORDER_CANCEL.status){
            throw new IllegalArgumentException(String.format("create operation can't handle the status: %s", orderStatus));
        }
        System.out.println("进入创建订单状态扭转处理器...");
        switch (orderStatusEnum) {
            case CREATE_EVENT:
                return OrderStatusEnum.FORMAL_EVENT.status;
            case ORDER_CANCEL:
                return OrderStatusEnum.ORDER_CANCEL.status;
            default:
                return getStatus();
        }
    }
}

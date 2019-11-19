package com.item.demo.state;

import com.item.demo.state.constant.OrderStatusEnum;
import lombok.Data;

@Data
public abstract class AbstractOrderOperator {

    int status;

    public abstract int handleEvent(int orderStatus, OrderStatusEnum orderStatusEnum);
}

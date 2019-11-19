package com.item.demo.state;

import lombok.Data;

/**
 * 订单处理器
 */
@Data
public abstract class AbstractOrderProcessor {
    int status;
    public abstract boolean process(String orderId, Object... params);
}

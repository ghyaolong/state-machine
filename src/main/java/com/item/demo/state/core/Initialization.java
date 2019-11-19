package com.item.demo.state.core;

import com.item.demo.state.AbstractOrderOperator;
import com.item.demo.state.AbstractOrderProcessor;
import com.item.demo.state.core.annotation.OrderOperator;
import com.item.demo.state.core.annotation.OrderProcessor;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;


@Component
public class Initialization implements BeanPostProcessor {

    @Resource
    OrderStateManager manager;

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        if (bean instanceof AbstractOrderOperator && bean.getClass().isAnnotationPresent(OrderOperator.class) ) {
            AbstractOrderOperator orderState = (AbstractOrderOperator) bean;
            manager.orderOperatorMaps.put(orderState.getStatus(), orderState);
        }

        if (bean instanceof AbstractOrderProcessor && bean.getClass().isAnnotationPresent(OrderProcessor.class) ) {
            AbstractOrderProcessor orderProcessor = (AbstractOrderProcessor) bean;
            manager.orderProcessorMaps.put(orderProcessor.getStatus(), orderProcessor);
        }
        return bean;
    }
}

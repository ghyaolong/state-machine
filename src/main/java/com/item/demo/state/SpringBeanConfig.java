package com.item.demo.state;

import com.item.demo.state.core.Initialization;
import com.item.demo.state.core.OrderStateManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@ComponentScan
@Configuration
public class SpringBeanConfig {
    @Bean
    public Initialization initialization() {
        return new Initialization();
    }

    @Bean
    public OrderStateManager orderStateManager() {
        return new OrderStateManager();
    }
}

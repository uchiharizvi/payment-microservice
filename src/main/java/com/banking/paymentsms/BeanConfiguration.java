package com.banking.paymentsms;

import com.banking.paymentsms.aspects.RestLogAspect;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfiguration {
    @Bean
    public RestLogAspect restLogAspect(){
        return new RestLogAspect();
    }
    @Bean
    public PaymentsService paymentsService(){
        return new PaymentsServiceImpl();
    }
    @Bean
    public PaymentsController paymentsController(){
        return new PaymentsController(paymentsService(),  restLogAspect());
    }
}

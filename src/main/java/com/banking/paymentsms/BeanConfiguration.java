package com.banking.paymentsms;

import com.banking.paymentsms.aspects.LogResponseTimeAspect;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClient;
import org.springframework.web.client.RestTemplate;

@Configuration
public class BeanConfiguration {
    @Bean
    public LogResponseTimeAspect restLogAspect(){
        return new LogResponseTimeAspect();
    }
    @Bean
    public PaymentsService paymentsService(){
        return new PaymentsServiceImpl(restTemplate());
    }
    @Bean
    public PaymentsController paymentsController(){
        return new PaymentsController(paymentsService(),  restLogAspect());
    }
    @Bean
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }
}

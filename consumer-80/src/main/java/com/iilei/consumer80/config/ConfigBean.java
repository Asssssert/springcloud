package com.iilei.consumer80.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class ConfigBean {

    @Bean
    @LoadBalanced //开启ribbon负载均衡，客户端
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}

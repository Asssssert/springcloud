package com.iilei.zuul9527;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.cloud.netflix.zuul.EnableZuulServer;

@EnableEurekaClient
@EnableZuulProxy
@SpringBootApplication
public class Zuul9527Application {

    public static void main(String[] args) {
        SpringApplication.run(Zuul9527Application.class, args);
    }

}

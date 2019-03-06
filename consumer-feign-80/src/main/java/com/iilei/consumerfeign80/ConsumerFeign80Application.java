package com.iilei.consumerfeign80;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

@EnableEurekaClient
@SpringBootApplication
@EnableFeignClients(basePackages = {"com.iilei"})
@ComponentScan("com.iilei")
public class ConsumerFeign80Application {

    public static void main(String[] args) {
        SpringApplication.run(ConsumerFeign80Application.class, args);
    }

}

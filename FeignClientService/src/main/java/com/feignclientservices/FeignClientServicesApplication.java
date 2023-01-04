package com.feignclientservices;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class FeignClientServicesApplication {

    public static void main(String[] args)
    {
        SpringApplication.run(FeignClientServicesApplication.class, args);
    }

}





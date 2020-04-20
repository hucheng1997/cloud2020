package com.hucheng;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author HuChan
 */
@SpringBootApplication
@EnableFeignClients
public class OpenFeignMain80 {
    public static void main(String[] args) {
        SpringApplication.run(OpenFeignMain80.class,args);
    }
}

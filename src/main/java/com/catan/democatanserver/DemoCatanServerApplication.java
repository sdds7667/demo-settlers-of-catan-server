package com.catan.democatanserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class DemoCatanServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoCatanServerApplication.class, args);
    }

}

package com.slef.user.usermanager.config;

import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;

@Configuration
public class Mybaties {
     @Bean
    //@DependsOn({"DefaultSqlSessionFactory","HikariDataSource"})
    public MapperScannerConfigurer autoMapperScanner(){
        MapperScannerConfigurer orgMapperScanner = new MapperScannerConfigurer();
        orgMapperScanner.setBasePackage("com.slef.user.usermanager.dao");
        return orgMapperScanner;
    }
}

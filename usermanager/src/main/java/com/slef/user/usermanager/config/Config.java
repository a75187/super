package com.slef.user.usermanager.config;


import com.zaxxer.hikari.HikariDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class Config {

    @Bean(name = "HikariDataSource")
 public HikariDataSource getHikariDataSource(){
       HikariDataSource hikariDataSource = new HikariDataSource();
     hikariDataSource.setUsername("root");
     hikariDataSource.setPassword("123456");
     hikariDataSource.setJdbcUrl("jdbc:mysql://127.0.0.1:3306/test?useUnicode=true&characterEncoding=utf-8  ");
     hikariDataSource.setDriverClassName("com.mysql.jdbc.Driver");
     return hikariDataSource;
 }



 }

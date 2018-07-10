package com.mshz.jmsmq.basemq;

import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import javax.jms.Queue;

@SpringBootApplication
public class BasemqApplication {
	@Bean
	public Queue queue() {
		return new ActiveMQQueue("sample.queue");
	}


	public static void main(String[] args) {
		SpringApplication.run(BasemqApplication.class, args);
	}
}

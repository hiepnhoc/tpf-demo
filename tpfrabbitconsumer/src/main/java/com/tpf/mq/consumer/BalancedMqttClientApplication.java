package com.tpf.mq.consumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BalancedMqttClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(BalancedMqttClientApplication.class, args);
	}

}


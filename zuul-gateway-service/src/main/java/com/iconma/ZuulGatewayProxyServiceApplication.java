package com.iconma;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@SpringBootApplication
@EnableZuulProxy
public class ZuulGatewayProxyServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ZuulGatewayProxyServiceApplication.class, args);
	}
}

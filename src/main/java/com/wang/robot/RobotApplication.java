package com.wang.robot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@SpringBootApplication
public class RobotApplication {

	public static void main(String[] args) {
        System.setProperty("java.awt.headless", "false");
		SpringApplication.run(RobotApplication.class, args);
	}
}

package com.GH.GH.greenHouse;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages="com.GH.GH")
public class GreenHouseApplication {

	public static void main(String[] args) {
		SpringApplication.run(GreenHouseApplication.class, args);
	}

}

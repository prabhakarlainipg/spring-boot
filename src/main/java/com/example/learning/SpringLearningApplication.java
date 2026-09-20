package com.example.learning;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//@SpringBootConfiguration - marks the class as application configuration.
//@EnableAutoConfiguration- enables Boot to configure features based on your application’s dependencies and settings.
//@ComponentScan - discovers components in this class’s package and its subpackages.

//@SpringBootApplication(scanBasePackages = {
//    "com.example.learning",
//    "com.example.other"
//}) -> IY YOU WANT TO SCAN IN OTHER PACKAGES

@SpringBootApplication
public class SpringLearningApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringLearningApplication.class, args);
	}

}

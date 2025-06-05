package com.example.Book_My_Show_May;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
//import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class BookMyShowMayApplication {

	public static void main(String[] args) {

		SpringApplication.run(BookMyShowMayApplication.class, args);
	}

}

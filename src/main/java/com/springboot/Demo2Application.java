package com.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@SpringBootApplication
public class Demo2Application {

	@RequestMapping(value = "/")
	String home(){
		Map<String,String> map = new HashMap<String,String>();
		map.put("1","1");
		//Assert.isNull(map,"empty"); //isNull 等于 Assert.notNull()
		return "Hello World";
	}

	public static void main(String[] args) {
		SpringApplication.run(Demo2Application.class, args);
	}
}

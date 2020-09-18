package com.study.bulletin.bulletinBoard;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication


public class BulletinBoardApplication {

	public static void main(String[] args) {

		SpringApplication.run(BulletinBoardApplication.class, args);
		//(exclude = {DataSourceAutoConfiguration.class })
	}

}

package com.bmw.wallet.cron;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.client.RestTemplate;

import java.util.Calendar;

@SpringBootApplication
@EnableScheduling
public class ImilesWalletCronSchedulerApplication {

	public static void main(String[] args) {
		SpringApplication.run(ImilesWalletCronSchedulerApplication.class, args);
	}

	@Bean
	public RestTemplate getRestTemplate() {
		return new RestTemplate();
	}
}

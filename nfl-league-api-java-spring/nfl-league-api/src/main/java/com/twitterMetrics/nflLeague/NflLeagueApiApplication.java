package com.twitterMetrics.nflLeague;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class NflLeagueApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(NflLeagueApiApplication.class, args);
	}

}

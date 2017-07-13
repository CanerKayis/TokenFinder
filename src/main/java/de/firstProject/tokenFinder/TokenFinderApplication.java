package de.firstProject.tokenFinder;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TokenFinderApplication {

	private static final Logger log = LoggerFactory.getLogger(TokenFinderApplication.class);

	public static void main(final String[] args) {
		SpringApplication.run(TokenFinderApplication.class, args);
	}
}

package net.muszytowski.WearableInspectionServer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;

/**
 * Entry point for spring boot application.
 * Annotations enable auto configuration,
 * set the source of the properties and allows automatic
 * scan for components.
 * 
 * @author Sebastian Muszytowski
 */
@ComponentScan
@Configuration
@EnableAutoConfiguration
@PropertySources(value = { @PropertySource("classpath:application.properties") })
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
		
	}

}

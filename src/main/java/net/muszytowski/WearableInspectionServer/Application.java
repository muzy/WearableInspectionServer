package net.muszytowski.WearableInspectionServer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.util.ISO8601DateFormat;
import com.fasterxml.jackson.datatype.joda.JodaModule;

@ComponentScan
@Configuration
@EnableAutoConfiguration
@PropertySources(value = { @PropertySource("classpath:application.properties") })
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
		
	}

}

package org.formation;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.openfeign.EnableFeignClients;



/**
 * Run as a micro-service, registering with the Discovery Server (Eureka).
 * <p>
 * Note that the configuration for this application is imported from
 * {@link MembersConfiguration}. This is a deliberate separation of concerns.
 * 
 * @author Paul Chapman
 */
@SpringBootApplication
@EnableFeignClients
@EnableCircuitBreaker
public class MembersServer {



	/**
	 * Run the application using Spring Boot and an embedded servlet engine.
	 * 
	 * @param args
	 *            Program arguments - ignored.
	 */
	public static void main(String[] args) {

		SpringApplication.run(MembersServer.class, args);		
	}
}

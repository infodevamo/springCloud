package org.formation;

import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Service
public class GreetingsListner {

	@StreamListener(GreetingStream.INPUT)
	public void listen(@Payload Greetings greetings) {
		System.out.println("Received greetings : " + greetings);
		System.out.println("message : " + greetings.getMessage());
		System.out.println("Time : " + greetings.getMessage());
	}
}

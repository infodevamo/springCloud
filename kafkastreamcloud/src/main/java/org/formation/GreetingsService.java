package org.formation;

import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.MessageHeaders;
import org.springframework.stereotype.Service;
import org.springframework.util.MimeTypeUtils;

@Service
public class GreetingsService {

	private final GreetingStream greetingStreams;

	public GreetingsService(GreetingStream greetingStreams) {
		this.greetingStreams = greetingStreams;
	}
	
	public void sendGreeting(final Greetings greetings) {
		System.out.println("Envoi");
		MessageChannel messageChannel = this.greetingStreams.outboundGreetings();
		messageChannel.send(MessageBuilder
				.withPayload(greetings)
				.setHeader(MessageHeaders.CONTENT_TYPE, MimeTypeUtils.APPLICATION_JSON)
				.build());
	}
}

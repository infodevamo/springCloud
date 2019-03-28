package org.formation.controller;

import org.springframework.stereotype.Service;

@Service
public class NotificationClientFallback implements NotificationClient {

	@Override
	public String sendMail(Email email) {
		System.out.println("Hystrix circuit break");
		return null;
	}


}

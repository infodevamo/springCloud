package org.formation.controller;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name="notification-service", fallback=NotificationClientFallback.class)
public interface NotificationClient {
	
	@RequestMapping(method = RequestMethod.POST, value = "/sendSimple")
	String sendMail(@RequestBody Email email);

}

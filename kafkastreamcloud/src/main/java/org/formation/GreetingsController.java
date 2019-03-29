package org.formation;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingsController {

	private final GreetingsService greetingsService;
	
	public GreetingsController(GreetingsService greetingsService) {
		this.greetingsService = greetingsService;
	}
	
	@GetMapping("/greetings")
	@ResponseStatus(HttpStatus.ACCEPTED)
	public void greetings(@RequestParam("message") String message) {
		Greetings greetings = new Greetings();
		long time = (new Date()).getTime();
		greetings.setMessage(message + " " + time);
		greetings.setTimestamp(time);
		this.greetingsService.sendGreeting(greetings);
		System.out.println("Message Send " + greetings.getMessage());
	}
	
	@GetMapping("/listen")
	@ResponseStatus(HttpStatus.ACCEPTED)
	public void listenGreetings() {
		//greetingsListner.listen(greetings);
		System.out.println("Received greetings : ");
	}
	
}

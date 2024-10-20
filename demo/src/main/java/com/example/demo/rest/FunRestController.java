package com.example.demo.rest;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
public class FunRestController {
	
	@Value("${coach.name}")
	private String coachName;
	
	@Value("${team.name}")
	private String teamName;
	
	@GetMapping("/")
	public String sayHello() {
		return "Hello World!";
	}
	
	@GetMapping("/testing")
	public String testThis() {
		return "Test completed!";
	}
	
	@GetMapping("/devtools")
	public String autoUpdate() {
		return "This has been auto updated!";
	}
	
	@GetMapping("/workout")
	public String workout() {
		return "Worked out with " +  coachName + " from team " +  teamName;
	}
}

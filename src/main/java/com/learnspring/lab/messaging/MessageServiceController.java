package com.learnspring.lab.messaging;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RequestMapping("MessageServiceController")
@RestController
public class MessageServiceController {
	
	
	@PostMapping("PostMessage")
	public ResponseEntity<String> PostMessage() {
		
		ResponseEntity< String> resp ;
		
		try {
			resp =(ResponseEntity<String>) ResponseEntity.accepted();
			
			
		} catch (Exception e) {
			
			return (ResponseEntity<String>) ResponseEntity.badRequest();
			
		}
		
		return resp ;
		
	}

}

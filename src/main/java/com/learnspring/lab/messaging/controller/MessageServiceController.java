package com.learnspring.lab.messaging.controller;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.learnspring.lab.messaging.service.ActiveMqService;

@RequestMapping("MessageServiceController")
@RestController
public class MessageServiceController {

	@Autowired
	ActiveMqService activeMqService;

	@PostMapping("checkMessageService")
	public ResponseEntity<String> PostMessage(@RequestBody HashMap<String, Object> msg) {

		ResponseEntity<String> resp;

		try {
			System.out.println(msg);
			resp = activeMqService.postMessage(msg);
		} catch (Exception e) {
			return ResponseEntity.badRequest().body("Exception while posting message");
		}

		return resp;

	}

}

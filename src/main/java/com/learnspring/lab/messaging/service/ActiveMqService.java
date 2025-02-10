package com.learnspring.lab.messaging.service;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

import jakarta.jms.Message;

@Component
public class ActiveMqService {

	@Autowired
	JmsTemplate jmsTemplate;

	@Value("${sample.queue.name}")
	private String queueName;

	public ResponseEntity<String> postMessage(HashMap<String, Object> msg) {

		try {
			jmsTemplate.convertAndSend(queueName, msg);
			return ResponseEntity.ok("Message Sent SucessFully");
		} catch (Exception e) {
			return ResponseEntity.internalServerError().body("Internal Server Error");
		}
	}

	@JmsListener(destination = "${sample.queue.name}", containerFactory = "jmsListenerContainerFactory")
	public void consume(HashMap<String, Object> message) {
		try {
			System.out.println("for normal");
			System.out.println(message);
		} catch (Exception e) {
			System.out.println("Error Block");
		}

	}
	
	
	@JmsListener(destination = "${ActiveMQ.Advisory.Connection}" , containerFactory = "jmsListenerContainerFactory")
	public void consumeGroup(Message message) {
		try {
			System.out.println("for topic");
			System.out.println(message);
		} catch (Exception e) {
			System.out.println("Error Block");
		}

	}
	
}

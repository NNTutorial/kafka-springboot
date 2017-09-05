package com.nishant.spring.kafka;

import org.springframework.kafka.annotation.KafkaListener;

public class KafkaReceiver {
	@KafkaListener(id="test",topics = "nishant")
	public void listen(String data) {
		System.out.println("data received is >>>"+data);
	}
}

package com.nishant.spring.kafka;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.kafka.support.SendResult;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;


public class KafkaSender {

	@Autowired
	private KafkaTemplate<Integer, String> kafkaTemplate;
	@Autowired
	private SenderListenerImpl senderListenerImpl;

	public void send(String topic,Integer key,String mesg) {
		Message<String> message = MessageBuilder.withPayload(mesg).setHeader(KafkaHeaders.MESSAGE_KEY, key).setHeader(KafkaHeaders.TOPIC, topic).build();
		kafkaTemplate.setProducerListener(senderListenerImpl);
		ListenableFuture<SendResult<Integer, String>> future = kafkaTemplate.send(message);
		future.addCallback(new ListenableFutureCallback<SendResult<Integer, String>>() {

			@Override
			public void onSuccess(SendResult<Integer, String> result) {
				//
			}

			@Override
			public void onFailure(Throwable ex) {
				//
				ex.printStackTrace();
			}

		});
	}
}

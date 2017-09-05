package com.nishant.spring.kafka;

import org.apache.kafka.clients.producer.RecordMetadata;
import org.springframework.kafka.support.ProducerListenerAdapter;

public class SenderListenerImpl extends ProducerListenerAdapter<Integer, String> {

	public void onSuccess(String topic, Integer partition, Integer key, String value, RecordMetadata recordMetadata) {
		System.out.println("success sender listener: topic->"+topic+"-partition->"+partition+"-Key->"+key+"-Value->"+value+"-RecordMetadata->"+ recordMetadata.toString());
	}

	public void onError(String topic, Integer partition, Integer key, String value, Exception exception) {
		//System.out.println("error sender listener: topic->"+topic+"-partition->"+partition+"-Key->"+key+"-Value->"+value+"-RecordMetadata->"+ exception.getMessage());
	}

	public boolean isInterestedInSuccess() {
		return true;
	}
}

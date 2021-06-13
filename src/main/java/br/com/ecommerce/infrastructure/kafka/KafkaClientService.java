package br.com.ecommerce.infrastructure.kafka;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class KafkaClientService {
	@Autowired
	private KafkaTemplate<String, String> kafkaTemplate;
	
	public void sendMessage(String msg) {
	    kafkaTemplate.send("ECOMMERCE_PRODUTO_NOVO", msg);
	}
}


package br.com.ecommerce.infrastructure.kafka;


import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
class KafkaTopicConfig {

  @Bean
  public NewTopic topic1() {
	 return new  NewTopic("ECOMMERCE_PRODUTO_NOVO", 1, (short) 1);
  }

  @Bean
  public NewTopic topic2() {
	  return new  NewTopic("ECOMMERCE_PRODUTO_ALTERACAO", 1, (short) 1);
  }

}
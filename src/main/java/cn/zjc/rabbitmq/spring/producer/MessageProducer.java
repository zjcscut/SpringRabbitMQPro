package cn.zjc.rabbitmq.spring.producer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Scanner;

/**
 * @author zhangjinci
 * @version 2016/8/9 18:32
 * @function
 */
@Service
public class MessageProducer {

	private Logger logger = LoggerFactory.getLogger(MessageProducer.class);

	@Autowired
	private AmqpTemplate amqpTemplate;

	public void send(Object message) {
		logger.info("producer send message: " + message);
		amqpTemplate.convertAndSend("queueTestKey", message);
	}
}

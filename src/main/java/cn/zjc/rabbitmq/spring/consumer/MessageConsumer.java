package cn.zjc.rabbitmq.spring.consumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageListener;

/**
 * @author zhangjinci
 * @version 2016/8/9 18:45
 * @function
 */
public class MessageConsumer implements MessageListener{
    private Logger logger = LoggerFactory.getLogger(MessageConsumer.class);

    @Override
    public void onMessage(Message message) {
        logger.info("consumer receive message: " + message);
    }
}

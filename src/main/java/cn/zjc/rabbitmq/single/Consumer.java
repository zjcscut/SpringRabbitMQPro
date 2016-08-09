package cn.zjc.rabbitmq.single;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.QueueingConsumer;

/**
 * @author zhangjinci
 * @version 2016/8/9 17:55
 * @function 消息消费者
 */
public class Consumer {
    private final static String QUEUE_NAME = "hello";


    public static void main(String[] args) throws Exception{
        ConnectionFactory factory = new ConnectionFactory();

        factory.setHost("localhost");

        factory.setUsername("guest");

        factory.setPassword("guest");

        Connection connection = factory.newConnection();

        Channel channel = connection.createChannel();

        channel.queueDeclare(QUEUE_NAME, false, false, false, null);

        QueueingConsumer consumer = new QueueingConsumer(channel);

        channel.basicConsume(QUEUE_NAME,true,consumer);

        while (true){

            QueueingConsumer.Delivery delivery = consumer.nextDelivery();
            String msg = new String(delivery.getBody());
            System.out.println("Consumer receive msg ==> " + msg);
        }
    }
}

package cn.zjc.rabbitmq.single;


import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

/**
 * @author zhangjinci
 * @version 2016/8/9 17:55
 * @function 消息生产者
 */
public class Producer {

    private static final String QUEUE_NAME = "hello";

    public static void main(String[] args) throws Exception {
        ConnectionFactory factory = new ConnectionFactory();

        factory.setHost("localhost");

        factory.setUsername("guest");

        factory.setPassword("guest");


        Connection connection = factory.newConnection();

        Channel channel = connection.createChannel();

        channel.queueDeclare(QUEUE_NAME, false, false, false, null);

        String msg = "Hello World!";

        channel.basicPublish("", QUEUE_NAME, null, msg.getBytes());

        System.out.println(" Producer send Msg ==> " + msg);

        channel.close();

        connection.close();
    }
}

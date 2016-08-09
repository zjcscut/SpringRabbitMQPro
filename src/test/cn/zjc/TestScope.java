package cn.zjc;

import cn.zjc.rabbitmq.spring.producer.MessageProducer;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Scanner;

/**
 * @author zhangjinci
 * @version 2016/8/9 18:52
 * @function
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring-config.xml"})
public class TestScope {

	@Autowired
	private MessageProducer messageProducer;


	@Test
	public void TestSend() {
		messageProducer.send("hello world!");
		Scanner scanner = new Scanner(System.in);
		String s = scanner.next();

		System.out.println(s);
	}
}

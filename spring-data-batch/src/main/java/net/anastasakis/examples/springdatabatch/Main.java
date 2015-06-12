package net.anastasakis.examples.springdatabatch;

import java.util.concurrent.TimeUnit;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.google.common.util.concurrent.Uninterruptibles;

public class Main {

	public static void main(String[] args) {
		final ApplicationContext context = new ClassPathXmlApplicationContext("context.xml");
		context.getBean("runner",Runner.class).run();
		Uninterruptibles.sleepUninterruptibly(20, TimeUnit.SECONDS);
	}
}

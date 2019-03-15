package myspring.di.xml.test;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import myspring.di.xml.Hello;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:config/beans.xml")
public class HelloBeanSpringTest {
	@Autowired
	Hello hello;
	@Test
	public void hello() {
		Assert.assertEquals("Hello юса╓©М", hello.sayHello());
	}
	
}

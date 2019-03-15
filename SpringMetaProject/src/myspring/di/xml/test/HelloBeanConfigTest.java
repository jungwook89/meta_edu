package myspring.di.xml.test;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

import myspring.di.xml.Hello;
import myspring.di.xml.Printer;
import myspring.di.xml.config.HelloConfig;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes=HelloConfig.class,loader=AnnotationConfigContextLoader.class)
public class HelloBeanConfigTest {

	@Autowired
	Hello hello;
	
	@Autowired
	@Qualifier("strPrinter")
	Printer printer;
	
	@Test
	public void hello() {
		Assert.assertEquals("Hello 자바컨피그", hello.sayHello());
		hello.print();
		Assert.assertEquals("Hello 자바컨피그", printer.toString());
	}
}

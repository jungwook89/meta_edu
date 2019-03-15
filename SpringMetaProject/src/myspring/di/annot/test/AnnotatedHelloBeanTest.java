package myspring.di.annot.test;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


import myspring.di.annot.Hello;
import myspring.di.annot.Printer;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:config/beans_annot.xml")
public class AnnotatedHelloBeanTest {
	
	@Autowired
	@Qualifier("helloA")
	Hello hello;
	
	@Autowired
	@Qualifier("stringPrinter")
	Printer printer;
	
	@Test @Ignore
	public void hello() {
		Assert.assertEquals("Hello 어노테이션", hello.sayHello());
		hello.print();
		Assert.assertEquals("Hello 어노테이션", printer.toString());
	}
	
	@Test
	public void hello2() {
		Assert.assertEquals("Hello 생성자 어노테이션", hello.sayHello());
	}

}

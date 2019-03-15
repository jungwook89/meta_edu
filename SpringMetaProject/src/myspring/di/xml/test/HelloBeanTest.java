package myspring.di.xml.test;

import static org.junit.Assert.assertEquals;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.GenericXmlApplicationContext;

import myspring.di.xml.Hello;
import myspring.di.xml.Printer;



public class HelloBeanTest {

	@Test
	public void hellobean() {
		//1. Bean Container 생성
		BeanFactory factory = new GenericXmlApplicationContext("config/beans.xml");
		//2. Container가 생성한 Bean을 요청
		Hello hello1 = (Hello)factory.getBean("hello");
		Hello hello2 = factory.getBean("hello",Hello.class);
		//3. Assert.assertSame()을 사용해서 주소비교
		Assert.assertSame(hello1, hello2);
		//4. assertEquals()를 사용해서 값비교
		assertEquals("Hello 임정욱", hello1.sayHello());
		hello1.print();
		
		Printer printer = factory.getBean("sPrinter",Printer.class);
		assertEquals("Hello 임정욱", printer.toString());
		
	}
}

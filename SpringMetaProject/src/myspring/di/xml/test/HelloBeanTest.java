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
		//1. Bean Container ����
		BeanFactory factory = new GenericXmlApplicationContext("config/beans.xml");
		//2. Container�� ������ Bean�� ��û
		Hello hello1 = (Hello)factory.getBean("hello");
		Hello hello2 = factory.getBean("hello",Hello.class);
		//3. Assert.assertSame()�� ����ؼ� �ּҺ�
		Assert.assertSame(hello1, hello2);
		//4. assertEquals()�� ����ؼ� ����
		assertEquals("Hello ������", hello1.sayHello());
		hello1.print();
		
		Printer printer = factory.getBean("sPrinter",Printer.class);
		assertEquals("Hello ������", printer.toString());
		
	}
}

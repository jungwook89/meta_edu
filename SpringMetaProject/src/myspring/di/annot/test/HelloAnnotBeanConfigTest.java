package myspring.di.annot.test;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

import myspring.di.annot.Hello;
import myspring.di.annot.config.HelloAnnotBeanConfig;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes=HelloAnnotBeanConfig.class,loader=AnnotationConfigContextLoader.class)
public class HelloAnnotBeanConfigTest {
	
	@Autowired
	Hello hello;
	
	@Test
	public void test() {
		Assert.assertEquals("Hello 생성자 어노테이션", hello.sayHello());
		hello.print();
		
	}

}

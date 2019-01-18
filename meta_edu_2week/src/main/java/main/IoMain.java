package main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import inputOutput.CountWord;
import inputOutput.Inputable;
import inputOutput.Outputable;

public class IoMain {

	public static void main(String[] args) {
		ApplicationContext context = new GenericXmlApplicationContext("applicationContext.xml");
		CountWord.counting(context.getBean("input",Inputable.class), context.getBean("output",Outputable.class));
	}
}

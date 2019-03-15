package myspring.di.xml.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import myspring.di.xml.ConsolePrinter;
import myspring.di.xml.Hello;
import myspring.di.xml.Printer;
import myspring.di.xml.StringPrinter;

@Configuration
public class HelloConfig {
	@Bean
	public Hello hello() {
		Hello hello = new Hello();
		hello.setName("자바컨피그");
		hello.setPrinter(printer());
		return hello;
	}
	@Bean
	@Qualifier("strPrinter")
	public Printer printer() {
		Printer printer = new StringPrinter();
		return printer;
	}

	@Bean
	@Qualifier("conPrinter")
	public Printer cPrinter() {
		Printer printer = new ConsolePrinter();
		return printer;
	}
}

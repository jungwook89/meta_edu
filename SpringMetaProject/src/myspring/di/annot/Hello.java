package myspring.di.annot;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component("helloA")
public class Hello {
	//@Value("어노테이션")
	String name;
//	@Autowired
//	@Qualifier("stringPrinter")
	Printer printer;
	List<String> names;

	public Hello() {
		System.out.println("Annoted HelloBean default constructor called...");
	}
	@Autowired
	public Hello(@Value("생성자 어노테이션") String name, @Qualifier("consolePrinter") Printer printer) {
		this.name = name;
		this.printer = printer;
	}

	public List<String> getNames() {
		return this.names;
	}

	public void setNames(List<String> list) {
		
		this.names = list;
	}

//	public void setName(String name) {
//		System.out.println("setName() called :"+name);
//		this.name = name;
//	}

//	public void setPrinter(Printer printer) {
//		System.out.println("setPrinter() called :"+printer.getClass().getName());
//		
//		this.printer = printer;
//	}

	public String sayHello() {
		return "Hello " + name;
	}

	public void print() {
		this.printer.print(sayHello());
	}

}

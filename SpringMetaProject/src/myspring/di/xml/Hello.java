package myspring.di.xml;

import java.util.List;

public class Hello {
	String name;
	Printer printer;
	List<String> names;

	public Hello() {
		System.out.println("hello default constructor called...");
	}

	public Hello(String name, Printer printer) {
		this.name = name;
		this.printer = printer;
	}

	public List<String> getNames() {
		return this.names;
	}

	public void setNames(List<String> list) {
		
		this.names = list;
	}

	public void setName(String name) {
		System.out.println("setName() called :"+name);
		this.name = name;
	}

	public void setPrinter(Printer printer) {
		System.out.println("setPrinter() called :"+printer.getClass().getName());
		
		this.printer = printer;
	}

	public String sayHello() {
		return "Hello " + name;
	}

	public void print() {
		this.printer.print(sayHello());
	}

}

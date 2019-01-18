package meta_test;

import java.util.Scanner;

public class InputKeyboard implements Inputable{
	private String contents;
	Scanner scn = new Scanner(System.in);
	
	public InputKeyboard() {
		makeContents();
	}
	
	@Override
	public void makeContents(){
		System.out.print("���ڿ��� �Է����ּ���:");
		contents = scn.nextLine();
	}
	public String getContents(){
		return contents;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Inputable input = new InputKeyboard();
		System.out.println(input.getContents());
	}
}

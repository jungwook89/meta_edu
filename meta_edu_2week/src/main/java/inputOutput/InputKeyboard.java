package inputOutput;

import java.util.Scanner;

public class InputKeyboard implements Inputable{
	private String contents;
	Scanner scn = new Scanner(System.in);
	
	public InputKeyboard() {
		System.out.print("입력해주세요:");
		contents = scn.nextLine();
	}
	public String read(){
		return contents;
	}
	
}

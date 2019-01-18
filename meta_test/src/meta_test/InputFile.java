package meta_test;

import java.util.Scanner;

public class InputFile extends File implements Inputable {
	private String contents;
	Scanner scn = new Scanner(System.in);
	
	public InputFile() {
		makeContents();
	}
	
	@Override
	public void makeContents(){
		System.out.print("입력받을 파일의 경로를 입력하세요 : ");
		String path = scn.nextLine();
		contents = roadFile(path);
	}
	public String getContents(){
		return contents;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Inputable input = new InputFile();
		System.out.println(input.getContents());
	}
}

package meta_test;

import java.util.Scanner;

public class OutputFile extends File implements Outputable{
	
	@Override
	public void write(String contents){
		Scanner scn = new Scanner(System.in);
		System.out.print("������ ������ ��θ� �Է��ϼ��� : ");
		String savePath = scn.nextLine();
		saveFile(contents, savePath);
		scn.close();
	}
}

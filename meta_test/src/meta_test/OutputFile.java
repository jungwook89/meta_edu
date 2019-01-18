package meta_test;

import java.util.Scanner;

public class OutputFile extends File implements Outputable{
	
	@Override
	public void write(String contents){
		Scanner scn = new Scanner(System.in);
		System.out.print("저장할 파일의 경로를 입력하세요 : ");
		String savePath = scn.nextLine();
		saveFile(contents, savePath);
		scn.close();
	}
}

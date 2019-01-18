package mains;

import meta_test.CountWord;
import meta_test.InputFile;
import meta_test.OutputFile;

public class MainFtoF {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println("--------(case4) 파일입력,파일출력--------");
		InputFile inputFile4 = new InputFile();
		OutputFile outputFile4 = new OutputFile();
		CountWord cw4 = new CountWord();
		
		cw4.counting(inputFile4,outputFile4);
	}
}

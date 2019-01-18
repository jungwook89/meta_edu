package mains;

import meta_test.CountWord;
import meta_test.InputFile;
import meta_test.OutputConsole;

public class MainFtoC {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("--------(case3) 파일입력,콘솔출력--------");
		InputFile inputFile3 = new InputFile();
		OutputConsole outputConsole3 = new OutputConsole();
		CountWord cw3 = new CountWord();
		
		cw3.counting(inputFile3,outputConsole3);
	}

}

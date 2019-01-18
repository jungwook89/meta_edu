package mains;

import meta_test.CountWord;
import meta_test.InputKeyboard;
import meta_test.OutputFile;

public class MainKtoF {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		System.out.println("--------(case2) 키보드입력,파일출력--------");
		InputKeyboard inputKeyboard2 = new InputKeyboard();
		OutputFile outputFile2 = new OutputFile();
		CountWord cw2 = new CountWord();
		
		cw2.counting(inputKeyboard2,outputFile2);
	}

}

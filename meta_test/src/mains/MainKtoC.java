package mains;

import meta_test.CountWord;
import meta_test.InputKeyboard;
import meta_test.OutputConsole;

public class MainKtoC {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println("--------(case1) 키보드입력,콘솔출력--------");
		InputKeyboard inputKeyboard1 = new InputKeyboard();
		OutputConsole outputConsole1 = new OutputConsole();
		
		CountWord cw1 = new CountWord();
		cw1.counting(inputKeyboard1,outputConsole1);
	}

}

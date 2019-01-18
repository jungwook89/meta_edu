package inputOutput;

public class CountWord {
	public static void counting(Inputable inputObject,Outputable outputObject){
		String word = inputObject.read();
		int wordCount=0;
		int wordIdx=0;
		int bfIdx=0;
		word = word.trim();
	    if (word.length()>0){
	    	do{
	    		wordIdx=word.indexOf(' ',wordIdx+1);
	    		if (bfIdx+1 != wordIdx)
	    			wordCount++;
	    		bfIdx = wordIdx;
	    	}
			while(wordIdx <word.length() && wordIdx != -1);
	    	//trim공백제거
	    }
	    else{
	    	wordCount=0;
	    }
	    outputObject.write(Integer.toString(wordCount));
		
	}
	
}

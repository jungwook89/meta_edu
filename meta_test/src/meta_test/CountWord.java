package meta_test;

public class CountWord {
	
	
	public void counting(Inputable inputObject,Outputable outputObject){
		String testword = inputObject.getContents();
		int wordCount=0;
		int wordIdx=0;
		int bfIdx=0;
		testword = testword.trim();
	    if (testword.length()>0){
	    	do{
	    		wordIdx=testword.indexOf(' ',wordIdx+1);
	    		
	    		if (bfIdx+1 != wordIdx)
	    			wordCount++;
	    		bfIdx = wordIdx;
	    	}
			while(wordIdx <testword.length() && wordIdx != -1);
	    	//trim������ �ʿ������ �־��
	    }
	    else{
	    	wordCount=0;
	    }
	    outputObject.write(Integer.toString(wordCount));
		
	}
	
}

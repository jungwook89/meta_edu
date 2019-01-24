package bubbleSort;

import java.util.Arrays;
import java.util.Random;

public class BubbleSort {

	public int[] sort(int[] requestArr){
		for(int target=0;target<requestArr.length;target++){
			for(int j=1;j<requestArr.length-target;j++){
				if(requestArr[j]<requestArr[j-1]){
					int tmpData= requestArr[j];
					requestArr[j]=requestArr[j-1];
					requestArr[j-1]=tmpData;
				}
			}
		}
		return requestArr;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[] testArr=new int[10];
		Random random = new Random();
		for(int i=0;i<testArr.length;i++){
			testArr[i] = random.nextInt(100);
		}
		System.out.println(Arrays.toString(testArr));
		BubbleSort bubbleTest = new BubbleSort();
		System.out.println(Arrays.toString(bubbleTest.sort(testArr)));
	}

}

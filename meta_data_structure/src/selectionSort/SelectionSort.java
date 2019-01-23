package selectionSort;

import java.util.Arrays;
import java.util.Random;

public class SelectionSort {
	
	public int[] sort(int[] requestArr){
		
		for(int targetIdx=0;targetIdx<requestArr.length;targetIdx++){
			int minDataIdx=0;
			int tmpData = 0;
			int minData = 100;
			for (int i = targetIdx;i<requestArr.length;i++){
				
				if(minData<requestArr[i]){
					minData = requestArr[i];
					minDataIdx=i;
				}
			}
			tmpData = requestArr[minDataIdx];
			requestArr[minDataIdx]=requestArr[targetIdx];
			requestArr[targetIdx]=tmpData;
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
		SelectionSort testSort = new SelectionSort();
		Arrays.toString(testSort.sort(testArr));
	}

}

package binarySearch;

import java.util.Arrays;
import java.util.Random;

public class BinarySearch {
	public void search(int[] requestArr,int sNum){
		//get middle
			int[] newArray;
			int midIdx = (int)Math.floor(requestArr.length/2);
			System.out.println(midIdx);
			if(sNum==requestArr[midIdx]){
				System.out.println(sNum+"을 찾았습니다.");
				return;
			}else if(sNum>requestArr[midIdx]){
				newArray= Arrays.copyOfRange(requestArr, midIdx, requestArr.length);
			}else{
				newArray= Arrays.copyOfRange(requestArr, 0, midIdx);
			}
			if(midIdx==0){
				System.out.println(sNum+"을(를) 못 찾았습니다.");
				return;
			}
			search(newArray, sNum);
			return;
			
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] testArr=new int[100];
		Random random = new Random();
		for(int i=0;i<testArr.length;i++){
			testArr[i] = random.nextInt(100);
		}
		Arrays.sort(testArr);
		BinarySearch binarySearch = new BinarySearch();
		System.out.println(Arrays.toString(testArr));
		binarySearch.search(testArr, 1);
	}

}

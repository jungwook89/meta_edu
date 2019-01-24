package insertionSort;

import java.util.LinkedList;

public class InsertionSort {
	public LinkedList<Integer> sort(LinkedList<Integer> requestList){
		for(int targetIdx = 1;targetIdx < requestList.size(); targetIdx++){
			for(int i =targetIdx;i>=0;i--){
				if(requestList.get(i)<requestList.get(targetIdx)){
					requestList.add(i,requestList.get(targetIdx));
					requestList.remove(i+1);
					break;
				}else
					break;
			}
		}
		return requestList;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LinkedList<Integer> testList = new LinkedList<>();
		testList.add(3);
		testList.add(10);
		testList.add(1);
		testList.add(8);
		testList.add(2);
		testList.add(4);
		testList.add(7);
		testList.add(6);
		testList.add(5);
		testList.add(9);
		System.out.println(testList);
		System.out.println(new InsertionSort().sort(testList));
		System.out.println(testList.size());
		
	}

}

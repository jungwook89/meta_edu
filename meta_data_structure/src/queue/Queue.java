package queue;

import linkedList.Node;

public class Queue {
		private int size;
		private int curSize;
		private Node front;
		private Node rear;
		
	public Queue(int size){
		this.size=size;
		this.front = null;
		this.rear = null;
		this.curSize=0;
		
	}
	public boolean isEmpty(){
		return (front==null)&&(rear==null);
	}
	public void enQue(String data){
		if(isEmpty()){
			rear= new Node(data);
			front = rear;
			curSize+=1;
		}else{
			if(size==curSize){
				System.out.println("큐가 가득찼습니다.");
			}else{
				Node tpNode = new Node(data);
				rear.setPostNode(tpNode);
				rear = tpNode;
				curSize+=1;
			}
		}
	}
	public void deQue(){
		if(front==rear){
			System.out.println("큐가 비었습니다");
		}else{
			System.out.println(front.getData());
			front = front.getPostNode();
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Queue test1 = new Queue(5);
		test1.enQue("1");
		test1.enQue("2");
		test1.deQue();
		test1.enQue("3");
		test1.enQue("4");
		test1.enQue("5");
		test1.enQue("6");
		test1.deQue();
		test1.deQue();
		test1.deQue();
		test1.deQue();
		test1.deQue();
		test1.deQue();
	}
}

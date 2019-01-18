package stack;
import linkedList.*;

public class Stack {
	int size;
	int top;
	Node topNode;
	Node addedNode;
	public Stack(){
		top =0;
		topNode = new Node();
	}
	public Stack(int size){
		top =0;
		this.size=size;
	}
	public void pop(){
		if(isEmpty()){
			topNode=null;
			System.out.println("스택이 비어있습니다.");
		}else{
			System.out.println(topNode.getData());
			topNode= topNode.getPostNode();
			top-=1;
		}
	}
	public void push(String data){
		if(isEmpty()){
			topNode.setData(data);
			top+=1;
		}else{
			addedNode = new Node(data);
			addedNode.setPostNode(topNode);
			topNode=addedNode;
			top+=1;
		}
	}
	public boolean isEmpty(){
		return this.top==0;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Stack test1 = new Stack();
		test1.push("1");
		test1.push("2");
		test1.push("3");
		test1.push("4");
		test1.push("6");
		test1.pop();
		test1.pop();
		test1.pop();
		test1.pop();
		test1.pop();
		test1.pop();
	}

}

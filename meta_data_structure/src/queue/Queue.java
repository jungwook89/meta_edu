package queue;

public class Queue {
		private int size;
		private Node front;
		private Node rear;
	public Queue(int size){
		this.size=size;
		public void enQue(String data){
			
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Queue test1 = new Queue(4);
		test1.enQue(1);
		test1.enQue(2);
		test1.deQue();
		test1.enQue(3);
		test1.enQue(4);
		test1.deQue();
		test1.deQue();

}

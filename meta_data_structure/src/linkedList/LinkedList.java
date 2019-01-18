package linkedList;

public class LinkedList {
	Node startNode;
	Node currentNode;
	public LinkedList(){
		startNode = new Node();
		currentNode = startNode;
	}	
	public void add(String data){
		currentNode.setData(data);
		currentNode.setPostNode(new Node());
		currentNode=currentNode.getPostNode();
	}
	public void add(int idx,String data){
		Node crNode = nodeFinder(idx);
		Node tmpNode = crNode.getPostNode();
		crNode.setPostNode(new Node(data,tmpNode));
	}
	public void delete(int idx){
		nodeFinder(idx-1).setPostNode(nodeFinder(idx+1));
	}
	public Node nodeFinder(int idx){
		Node crNode = startNode;
		for(int i = 1; i<idx;i++){
			crNode = crNode.getPostNode();
		}
		return crNode;
	}
	public void printAll(){
		for(Node crNode = startNode; crNode.getPostNode()!=null; crNode = crNode.getPostNode()){
			System.out.print(crNode.getData()+' ');
		}
	}
	public static void main(String[] args) {
		LinkedList test1 = new LinkedList();
		test1.add("1");
		test1.add("2");
		test1.add("3");
		test1.add("4");
		test1.add("5");
		test1.add("6");
		test1.add("7");
		test1.add("8");
//		test1.add(3,"0");
//		test1.delete(3);
		System.out.println(test1.nodeFinder(3).getData());
		test1.printAll();
	}
}

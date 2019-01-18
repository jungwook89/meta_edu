package linkedList;

public class Node {
	private String data;// 노드 데이터
	private Node postNode;//다음 노드 객체
	public Node(){
		this.postNode =null;
	}
	public Node(String data){
		this.postNode =null;
		this.data=data;
	}
	public Node(String data,Node postNode){
		this.postNode =postNode;
		this.data=data;
	}
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	public Node getPostNode() {
		return postNode;
	}
	public void setPostNode(Node postNode) {
		this.postNode = postNode;
	}
}

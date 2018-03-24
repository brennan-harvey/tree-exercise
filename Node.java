import java.util.LinkedList;

public class Node {
	
	private String name;
	private LinkedList<Node> children;
	
	public Node(String name) {
		this.name = name;
		this.children = new LinkedList<Node>();
		this.children.add(0, null);
		this.children.add(1, null);
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getName() {
		return this.name;
	}
	
	public void setChildren(Node left, Node right) {
		this.children.add(0, left);
		this.children.add(1, right);
	}
	
	public LinkedList<Node> getChildren(){
		return this.children;
	}
	
}

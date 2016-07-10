
public abstract class Tree <T> extends LinkedList<T>{
	Node<T> root;
	public Tree(T key){
		super(key);
		root = new Node<T>(null, null, head.data, null);
	}
	
	public Tree(){
		super();
		root = null;
	}
	
	public abstract Node<T> find();
	
	public abstract void add(T key);
	
	public void replace(Node<T> rNode, T key){
		rNode.data = key;
	}
	
	public void insert(Node<T> rNode, T data){
		Node<T> newNode = new Node(null, null, data, null);
		newNode.parent = rNode.parent;
		if(rNode.parent.right == rNode){
			rNode.parent.right = newNode;
			newNode.right = rNode;
		}else{
			rNode.parent.left = newNode;
			newNode.left = rNode;
		}
		rNode.parent = newNode;
	}
	
	public void addLeft(T key, Node<T> parent){
		Node<T> newNode = new Node<T>(parent, null, key, null);
		parent.left = newNode;
	}
	
	public void addRight(T key, Node<T> parent){
		Node<T> newNode = new Node<T>(parent, null, key, null);
		parent.right = newNode;
	}
	@SuppressWarnings("hiding")
	public class Node<T> extends LinkedList.Node<T>{
		Node<T> parent;
		Node<T> left;
		Node<T> right;
		public Node(Node<T> parent, Node<T> left, T data, Node<T> right){
			super(left, data, right);
			this.left = (Node<T>) super.prev;
			this.right = (Node<T>) super.next;
			this.parent = parent;
		}
	}
	
}

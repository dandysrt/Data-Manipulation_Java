
public class LinkedList<T>{
	Node<T> head;
	Node<T> tail;
	public LinkedList(T key){
		head = new Node<T>(null, key, null);
		tail = head;
	}
	
	public LinkedList(){
		head = null;
		tail = head;
	}
	
	public Node<T> find(T key){
		
		Node<T> searchNode = head;
		if(searchNode != null){
			while(searchNode.data != null & !searchNode.data.equals(key) 
				&& searchNode.next != null){
				searchNode = searchNode.next;
			}
			return searchNode.data == key ? searchNode : null;
		}
		return null;
	}
	
	public void add(T key){
		if(head == null){
			head = new Node<T>(null, key, tail);
			tail = head;
			return;
		}
		Node<T> newNode = new Node<T>(tail, key, null);
		tail.next = newNode;
		tail = newNode;
	}
	
	public void remLast(){
		tail = tail.prev;
		tail.next = null;
	}
	
	public void insert(T prevKey, T key){
		Node<T> prev = find(prevKey);
		Node<T> newNode = new Node<T>(prev, key, prev.next);
		prev.next = newNode;
	}
	
	public void remove(T key){
		Node<T> removeNode = find(key);
		
		if(removeNode.prev != null)
			removeNode.prev.next = removeNode.next;
		if(removeNode.next != null)
			removeNode.next.prev = removeNode.prev;
		if(removeNode.equals(head))
			this.head = removeNode.next;
		
		
	}
	
	public void printList(){
		Node<T> printNode = head;
		if(printNode != null){
			while(printNode.next != null){
				System.out.printf("%s, ", printNode.data.toString());
				printNode = printNode.next;
			}
			System.out.printf("%s\n", printNode.data.toString());
		}
	}
	
	public static class Node<T>{
		public Node<T> prev;
		public Node<T> next;
		public T data;
		public Node(Node<T> prev, T data, Node<T> next){
			this.prev = prev;
			this.data = data;
			this.next = next;
		}
	}
}


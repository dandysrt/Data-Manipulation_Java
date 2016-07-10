public class HashTable<T>{
	private List<T>[] hashList;
	private int listMod;
	
	@SuppressWarnings("unchecked")
	public HashTable(int size){
		hashList = new List[size];
		for(int i = 0; i < hashList.length; i++)
			hashList[i] = new List<T>();
		listMod = size;
	}
	
	
	//can be a rapid shortcut for retrieving data if key has no collisions
	public T get(int key){
		List<T> output = hashList[key%listMod];
		if(output != null){
			if(output.head == null){
				return null;
			}else if(output.head.next != null){
				System.out.printf("Multiple values detected at %s, "
						+ " please specify the data you wish to retrieve"
						+ " USAGE: 'get(key, data)\n", key);
				return null;
			}else{
				return output.head.data;
			}
		}
		return null;
		
	}
	
	//longest search method if key is unknown O(n^2) at worst
	public T get(T data){
		for(int i = 0; i < hashList.length; i++){	
			List.Node<T> output = (List.Node<T>) hashList[i].find(data);
			if(output != null)
				if(output.data != null)
					return output.data;
				
		}
		return null;
	}
	
	//most rapid search if key is known
	public T get(int key, T data){
		return hashList[key%listMod].find(data).data;
	}
	
	public void add(int key, T data){
		hashList[key%listMod].add(key, data);
	}
	
	public void remove(int key, T data){
		hashList[key%listMod].remove(data);
	}
	
	//unused will be implemented for dynamic list
	private void updateListMod(){
		listMod = hashList.length;
	}
	
	public void printTable(){
		for(int i = 0; i < hashList.length; i++){
			if(hashList[i] != null){
				if(hashList[i].head != null) System.out.printf("%s: ", i);
				hashList[i].printList();
			}
		}
	}
	
	/*======================SUBCLASSES====================*/
	
	
	public static class List<T> extends LinkedList<T>{
		public void add(int key, T data){
			if(super.head == null){
				super.head = new Node<T>(null, key, data, (Node<T>)super.tail);
				super.tail = super.head;
				return;
			}
			Node<T> newNode = new Node<T>((Node<T>)super.tail, key, data, null);
			super.tail.next = newNode;
			super.tail = newNode;
		}
		
		public static class Node<T> extends LinkedList.Node<T>{
			public int key;
			public Node(Node<T> prev, int key, T data, Node<T> next){
				super(prev, data, next);
				this.key = key;
			}
		}
	}
	


}

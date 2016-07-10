
public class TestClass {
	
	public void testLinkList(){
		//Add Test
		LinkedList<Integer> myList = new LinkedList<Integer>();
		for(int i = 0; i < 10; i++){
		myList.add(i + 1);	
		}
		System.out.println("Add Successful.");
		//Search Test
		int find = 5;
		int found = 0;
		LinkedList.Node<Integer> tempNode = myList.find(find);
		if(tempNode != null)
			found = tempNode.data;
		if(found == find){
			System.out.println("Search Successful");
		}else{
			System.out.println("Search Unsuccessful");
		}
		//remLast Test
		System.out.print("Before Removal: ");
		myList.printList();
		myList.remLast();
		System.out.printf("Tail Removal Successful %d is now the tail value\n", myList.tail.data);
		System.out.print("After Removal: ");
		myList.printList();
		//insert Test
		myList.insert(3, 12);
		System.out.println("Insert Successful");
		//remove Test
		System.out.print("Before Removal: ");
		myList.printList();
		myList.remove(12);
		System.out.println("Remove Successful");
		System.out.print("After Removal: ");
		myList.printList();
	}
	
	public void testArrayList(){
		//Array Constructor & get() Test
		Integer[] testArray = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
		ArrayList<Integer> myList = new ArrayList<Integer>(testArray);
		if(myList.get(3) == 4){
			System.out.println("Constructor1 test successful");
		}else{
			System.out.println("Constructor1 test unsuccessful");
		}
		//Size Constructor & get() test
		myList = new ArrayList<Integer>(6);
		if(myList.list.length == 6){
			System.out.println("Constructor 2 test successful");
		}else{
			System.out.println("Constructor 2 test unsuccessful");
		}
		//Add & indexOf() test
		myList = new ArrayList<Integer>();
		myList.add(12);
		if(myList.get(myList.indexOf(12)) == 12){
			System.out.println("Add successful");
		}else{
			System.out.println("Add unsuccessful");
		}
		//Remove test
		myList.remove(myList.indexOf(12));
		if(myList.size() == 0){
			System.out.println("Remove successful");
		}else{
			System.out.println("Remove unsuccessful");
		}
		//grow test
		for(int i = 0; i < 10; i++){
			myList.add(i + 1);
		}
		if(myList.indexOf(10) == 9){
			System.out.println("Grow successful");
		}else{
			System.out.println("Grow unsuccessful");
		}
		//addAll() & contains test
		Integer[] tempArray = {11, 12, 13, 14, 15, 16, 17, 18, 19, 20};
		myList.addAll(tempArray);
		if(myList.contains(15)){
			System.out.println("Add all successful");
		}else{
			System.out.println("Add all unsuccessful");
		}
		//removeRange() test
		myList.removeRange(14, 20);
		if(!myList.contains(15)){
			System.out.println("Remove Range successful");
		}else{
			System.out.println("Remove Range unsuccessful");
		}
		//add Insert test
		myList.add(13, 15);
		if(myList.contains(15)){
			System.out.println("Add Insert successful");
		}else{
			System.out.println("Add Insert unsuccessful");
			System.out.printf("Value at %d is: %d\n", 13, myList.get(13));
		}
		//set test
		myList.set(9, 9);
		if(!myList.contains(10)){
			System.out.println("Set successful");
		}else{
			System.out.println("Set unsuccessful");
		}
	}

	public void testQueueList(){
		QueueList<Integer> myQueue = new QueueList<Integer>(5);
		// Queue Test
		for(int i = 0; i < 5; i++){
			myQueue.queue(i + 1);
		}
		System.out.println("Queue Successful");
		// Grow Test
		for(int j = 4; j < 10; j++){
			myQueue.queue(j + 1);
		}
		System.out.println("Grow Successful");
		// Dequeue Test
		myQueue.dequeue();
		System.out.println("Dequeue Successful");
	}
	
	public void testStackList(){
		StackList<Integer> myStack = new StackList<Integer>(10);
		// test Push
		for(int i = 0; i < 7; i++){
			myStack.push(i+1);
		}
		System.out.println("Push successful");
		// test peek
		
		if(myStack.peek() == 7){
			System.out.println("Peek successful");
		}else{
			System.out.println("Peek unsuccessful");
		}
		// test pop
		myStack.pop();
		if(myStack.peek() == 6){
			System.out.println("Pop successful");
		}else{
			System.out.println("Pop unsuccessful");
		}
	}
	
	public void testHashTable(){
		HashTable<String> myHash = new HashTable<String>(30);
		
		myHash.add(3, "Barbara Buchanan");
		myHash.add(77, "Susan Sarandon");
		myHash.add(28, "Alan Alda");
		myHash.add(83, "David Duchovney");
		myHash.add(23, "Keira Knightly");
		
		if(myHash.get(23) == null)
			System.out.println("Short get() error successful");
		else
			System.out.println("Short get() error unsuccessful");
		
		if(myHash.get(3).equals("Barbara Buchanan"))
			System.out.println("Short get() successful");
		else
			System.out.println("Short get() unsuccessful");
		
		if(myHash.get(23, "Keira Knightly").equals("Keira Knightly"))
			System.out.println("Rapid get() successful");
		else
			System.out.println("Rapid get() unsuccessful");
		
		if(myHash.get("Alan Alda").equals("Alan Alda"))
			System.out.println("Slow get() successful");
		else
			System.out.println("Slow get() unsuccessful");
		
		myHash.remove(23, "David Duchovney");
		if(myHash.get(23) != null)
			System.out.println("remove() successful");
		else
			System.out.println("remove() unsuccessful");
		
		myHash.printTable();
	}
	
	public static void main(String[] args) {
		TestClass myTest = new TestClass();
		System.out.println("\n========LinkedList Test========");
		myTest.testLinkList();
		System.out.println("\n========ArrayList Test========");
		myTest.testArrayList();
		System.out.println("\n========QueueList Test========");
		myTest.testQueueList();
		System.out.println("\n========StackList Test========");
		myTest.testStackList();
		System.out.println("\n========HashTable Test========");
		myTest.testHashTable();
	}

}

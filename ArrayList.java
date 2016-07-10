
public class ArrayList<T>{
	protected Object[] list;
	private int currentPos = 0;
	private int size = 2;
	@SuppressWarnings("unchecked")
	public ArrayList(){
		this.list = (T[]) new Object[size];
	}
	
	public ArrayList(int size){
		this.list = new Object[size];
	}
	
	public ArrayList(T[] list){
		this.list = list;
		currentPos = list.length;
		grow();
	}
	
	private void shrink(){
		int count = 0;
		int length = currentPos < list.length ? currentPos : list.length;
		for(int i = 0; i < length; i++){
			if(list[i] == null){
				for(int j = i; j < length - 1; j++){
					list[j] = list[j + 1];
				}
				count++;
			}
		}
		currentPos -= count;
	}
	
	@SuppressWarnings("unchecked")
	private void grow(){
		T[] tempList = (T[]) new Object[(list.length * 2)];
		int length = currentPos < list.length ? currentPos : list.length;
		for(int i = 0; i < length; i++){
			tempList[i] = (T) list[i];
		}
		list = tempList;
	}
	
	@SuppressWarnings("unchecked")
	private void grow(int size){
		T[] tempList = (T[]) new Object[(list.length + size)];
		int length = currentPos < list.length ? currentPos : list.length;
		for(int i = 0; i < length; i++){
			tempList[i] = (T) list[i];
		}
		list = tempList;
	}
	
	public boolean add(T data){
		try{
			if(currentPos < list.length){
				list[currentPos] = data;
			}else{
				grow();
				list[currentPos] = data;
			}
			currentPos++;
			return true;
		}catch(Exception e){
			return false;
		}
	}
	
	@SuppressWarnings("unchecked")
	public void add(int index, T data){
		try{
			if(index >= list.length || currentPos >= list.length)
				grow();
			Object[] temp = new Object[(currentPos - index)];
			for(int i = 0; i < temp.length; i++){
				temp[i] = list[index + i];
			}
			list[index] = data;
			addAll((T[]) temp);
		}catch(IndexOutOfBoundsException e){
			System.err.println("Index out of Bounds");
			e.printStackTrace();
		}
	}
	
	public boolean addAll(T[] listData){
		try{
			grow(listData.length);
			for(int i = 0; i < listData.length; i++){
				list[currentPos + i] = listData[i];
			}
			currentPos += listData.length;
			return true;
		}catch(NullPointerException e){
			System.err.println("Provided Array is Null Pointer");
			e.printStackTrace();
			return false;
		}
	}
	
	@SuppressWarnings("unchecked")
	public void clear(){
		list = (T[]) new Object[this.size];
	}
	
	@SuppressWarnings("unchecked")
	public T get(int pos){
		try{
			return (T) list[pos];
		}catch(IndexOutOfBoundsException e){
			e.printStackTrace();
			return null;
		}
	}
	
	public int indexOf(T data){
		int length = currentPos < list.length ? currentPos : list.length;
		for(int i = 0; i < length; i++){
			if(list[i].equals(data))
				return i;
		}
		return -1;
	}
	
	public int lastIndexOf(T data){
		int length = currentPos < list.length ? currentPos : list.length;
		int lastKnown = -1;
		for(int i = 0; i < length; i++){
			if(list[i].equals(data)){
				lastKnown = i;
			}
		}
		return lastKnown;
	}
	
	@SuppressWarnings("unchecked")
	public T remove(int index){
		try{
			T out = (T) list[index];
			list[index] = null;
			shrink();
			return out;
		}catch(IndexOutOfBoundsException e){
			System.err.println("Index is out of Bounds");
			e.printStackTrace();
			return null;
		}
	}
	
	protected void removeRange(int startIndex, int endIndex){
		try{
			for(int i = startIndex; i < endIndex; i++){
				list[i] = null;
			}
			shrink();
		}catch(IndexOutOfBoundsException e){
			System.err.println("Range is out of Bounds");
			e.printStackTrace();
		}
	}
	
	@SuppressWarnings("unchecked")
	public T[] clone(){
		return (T[]) list;
	}
	
	boolean contains(T data){
		if(indexOf(data)!= -1)
			return true;
		return false;
	}
	
	@SuppressWarnings("unchecked")
	public T set(int index, T data){
		try{
			list[index] = data;
			return (T) list[index];
		}catch(IndexOutOfBoundsException e){
			System.err.println("Index out of Bounds");
			e.printStackTrace();
			return null;
		}
	}
	
	public int size(){
		return this.size = currentPos < list.length ? currentPos : list.length;
	}
	
	@SuppressWarnings("unchecked")
	public T[] toArray(){
		try{
			T[] tempArray = (T[]) new Object[list.length];
			for(int i = 0; i < list.length; i++){
				tempArray[i] = (T) list[i];
			}
			return tempArray;
		}catch(NullPointerException e){
			System.err.println("Array Pointer is null");
			e.printStackTrace();
			return null;
		}
	}
	@SuppressWarnings("unchecked")
	public T[] toArray(T[] array){
		try{
			T[] tempArray = (T[]) new Object[array.length];
			for(int i = 0; i < array.length; i++){
				tempArray[i] = (T) list[i];
			}
			return tempArray;
		}catch(NullPointerException e){
			System.err.println("Array Pointer is null");
			e.printStackTrace();
			return null;
		}
	}
	
	@SuppressWarnings("unchecked")
	public void trimToSize(){
		T[] tempArray = (T[]) new Object[size()];
		for(int i = 0; i < size(); i++){
			tempArray[i] = (T) list[i];
		}
		list = tempArray;
	}


}

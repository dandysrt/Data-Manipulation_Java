
public class QueueList<T>{
	Object[] qArray;
	
	int qPointer = 0;
	int dqPointer = 0;
	
	@SuppressWarnings("unchecked")
	public QueueList(int size){
		qArray = (T[]) new Object[size];
	}
	
	@SuppressWarnings("unchecked")
	private void grow(){
		T[] tempList = (T[]) new Object[(qArray.length * 2)];
		for(int i = 0; i < qArray.length; i++){
			tempList[i] = (T) qArray[i];
		}
		qArray = tempList;
	}
	
	public boolean queue(T data){
		try{
			if(dqPointer != qPointer + 1 && qPointer < qArray.length){ // do nothing
			}else if(dqPointer != 0 && qPointer >= qArray.length){
				qPointer = 0;
			}else{
				grow();
			}
			qArray[qPointer++] = data;
			return true;
		}catch(IndexOutOfBoundsException e){
			System.err.println("Index out of Bounds");
			e.printStackTrace();
			return false;
		}
	}
	
	@SuppressWarnings("unchecked")
	public T dequeue(){
		try{
			if(dqPointer != qPointer && dqPointer < qArray.length){
				return (T) qArray[dqPointer++];
			}else if(qPointer != 0 && dqPointer >= qArray.length){
				dqPointer = 0;
				return (T) qArray[dqPointer++];
			}
			return null;
		}catch(IndexOutOfBoundsException e){
			System.err.println("Index out of Bounds");
			e.printStackTrace();
			return null;
		}
	}

}

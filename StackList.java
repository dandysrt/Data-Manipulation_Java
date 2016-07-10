
public class StackList<T>{
	Object[] stackArray;
	int pointer = 0;
	
	@SuppressWarnings("unchecked")
	public StackList(int size){
		stackArray = (T[]) new Object[size];
	}
	
	public boolean push(T data){
		try{
			if(pointer < stackArray.length){
				stackArray[pointer++] = data;
				return true;
			}else{
				return false;
			}
		}catch(IndexOutOfBoundsException e){
			System.err.println("Index out of bounds");
			e.printStackTrace();
			return false;
		}
	}
	
	@SuppressWarnings("unchecked")
	public T pop(){
		try{
			if(pointer >= 0 && pointer < stackArray.length){
				return (T) stackArray[pointer--];
			}else{
				return null;
			}
		}catch(IndexOutOfBoundsException e){
			System.err.println("Index out of bounds");
			e.printStackTrace();
			return null;
		}
	}
	
	@SuppressWarnings("unchecked")
	public T peek(){
		try{
			if(pointer >= 0 && pointer < stackArray.length){
				return (T) stackArray[pointer - 1];
			}else{
				return null;
			}
		}catch(IndexOutOfBoundsException e){
			System.err.println("Index out of bounds");
			e.printStackTrace();
			return null;
		}
	}
}

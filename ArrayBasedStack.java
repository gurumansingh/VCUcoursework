package cmsc256;
import java.util.*;

public class ArrayBasedStack<T> implements StackInterface<T> {

	private T[] data;
	private int topOfStack;
	private static final int INITIAL_CAPACITY = 5; 
	
	public ArrayBasedStack(int capacity){
		if(capacity<=0) {
			throw new IllegalArgumentException("Array initial size error.");
		}
		@SuppressWarnings("unchecked")
		T[] tempStack=(T[])new Object[capacity];
	    data = tempStack;
	    topOfStack = -1;
	}
	
	public ArrayBasedStack(){
		topOfStack=-1;
	    data = (T[])new Object[INITIAL_CAPACITY]; 
	}
	
	

	private void expandArray(){
		int size = data.length*2;
	    T[] temp = Arrays.copyOf(data,size);
	    data = temp; 
	}
	
	 private boolean isArrayFull(){
		 if(topOfStack >= data.length) {
			 return true;
		 }else {                
	    	 return false;
		 }
	 }
	  
	 @Override
	public void push(T newEntry){
		if(isArrayFull()) {
			expandArray(); 
		}else {
			int newIndex = ++topOfStack;
			if(newIndex > data.length - 1) {
				expandArray();
				data[newIndex] = newEntry; 
			}else {
				data[newIndex] = newEntry; 
			}
		}
	}
	 
	@Override
	public T pop() {
		if(isEmpty())  {
			throw new EmptyStackException();
		}
	        
			T element = data[topOfStack--];
	        return element;   
	}
	
	@Override
	public T peek() {
		if(isEmpty()) {
			throw new EmptyStackException();
		}
	        T element = data[topOfStack];
	        return element;  
	}

	@Override
	public boolean isEmpty() {
		return topOfStack < 0;
	}

	@Override
	public void clear() {
		//for(int i=0;i<data.length;i++) 
			//pop();
		@SuppressWarnings("unchecked")
		T[] tempStack = (T[])new Object[INITIAL_CAPACITY];
		data = tempStack;
		topOfStack = -1;

	}

}

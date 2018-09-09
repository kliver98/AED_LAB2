package model;

public interface IStack<T>{

	public T pop();
	
	public T last();

	public void removeLastElement();
	
	public void push(T value);

	public boolean isEmpty();
	
	public int size();


}

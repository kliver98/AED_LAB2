package model;

public interface IQueue<T> {

	public void offer(T e);
	
	public void removeFirstElement();
	
	public T poll();

	public T element();

	public T first();
	
	public int size();

	public boolean isEmpty();
	

}

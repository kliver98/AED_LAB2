package model;

public class List<T> implements IQueue<T>, IStack<T>{
	
	
	private Node<T> peek;
	private Node<T> first;
	private Node<T> last;
	private int size;
	
	public List() {
		size = 0;
	}

	public void offer(T e) {
		if (isEmpty()) {
			first = new Node<T>(e);
			last = first;
			size++;
		}
		else {
			Node<T> temp = new Node<T>(e);
			last.setNext(temp);
			temp.setBack(last);
			last = temp;
			size++;
		}
	}


	public T poll() {
		T rsT = null;
		if (!isEmpty()) {
			rsT = first();
			removeFirstElement();
		}
		return rsT;
	}


	public T element() {
		return first();
	}


	public int size() {
		return size;
	}


	public T pop() {
		T rst = null;
		if (!isEmpty()) {
			rst = last();
			removeLastElement();
			size--;
		}
		return rst;
	}


	public T first() {
		return (isEmpty())?null:first.getValue();
	}
	

	public T last() {
		return (isEmpty())?null:peek.getValue();
	}


	public void push(T value) {
		if (size==0) {
			peek = new Node<T>(value);
			size++;
		}
		else {
			peek.setNext(new Node<T>(value));
			peek.getNext().setBack(peek);
			peek = peek.getNext();
			size++;
		}
	}

	public boolean isEmpty() {
		return (size==0)?true:false;
	}


	public void removeLastElement() {
		if (size>1) {
			peek = this.peek.getBack();
			peek.setNext(null);
			
			size--;
		}
		else {
			peek = null;
			size--;
		}
	}

	public void removeFirstElement() {
		if (size>1) {
			first.getNext().setBack(null);
			first = first.getNext();
			size--;
		}
		else {
			first = null;
			last = null;
			size--;
		}
	}
	
	

}

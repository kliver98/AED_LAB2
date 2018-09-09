package estructurasDeDatos;

public class List<T> implements IStack<T>, IQueue<T>{
	
	private Nodo<T> peek;
	private Nodo<T> first;
	private Nodo<T> last;
	private int size;
	
	public List() {
		size = 0;
	}

	@Override
	public void offer(T e) {
		if (isEmpty()) {
			first = new Nodo<T>(e);
			last = first;
			size++;
		}
		else {
			Nodo<T> temp = new Nodo<T>(e);
			last.setNext(temp);
			temp.setBack(last);
			last = temp;
			size++;
		}
	}

	@Override
	public T poll() {
		T rsT = null;
		if (!isEmpty()) {
			rsT = first();
			removeFirstElement();
		}
		return rsT;
	}

	@Override
	public T element() {
		return first();
	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public T pop() {
		T rst = null;
		if (!isEmpty()) {
			rst = last();
			removeLastElement();
			size--;
		}
		return rst;
	}

	@Override
	public T first() {
		return (isEmpty())?null:first.getValue();
	}
	
	@Override
	public T last() {
		return (isEmpty())?null:peek.getValue();
	}

	@Override
	public void push(T value) {
		if (size==0) {
			peek = new Nodo<T>(value);
			size++;
		}
		else {
			peek.setNext(new Nodo<T>(value));
			peek.getNext().setBack(peek);
			peek = peek.getNext();
			size++;
		}
	}

	@Override
	public boolean isEmpty() {
		return (size==0)?true:false;
	}

	@Override
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

	@Override
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

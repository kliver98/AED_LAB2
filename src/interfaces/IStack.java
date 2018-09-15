package interfaces;

public interface IStack<T> {
	
	/**
	* Returns a T element, and then removes it from the list.
	* @return T. Generic data type
	*/
	public T pop();
	
	/**
	 * Returns an element T
	 * @return T. generic data type.
	 */
	public T last();
	
	/**
	 * Remove the last element that is in the list.
	 */
	public void removeLastElement();
	
	/**
	 * Add an item in the last position of the list.
	 * @param value
	 */
	public void push(T value);
	
	/**
	 * Check if the list is empty or not.
	 * @return boolean, True If empty. False otherwise
	 */
	public boolean isEmpty();
	
	/**
	 * Returns the size of the list.
	 * @return Integer. 0 if this taint, Any other number depending on the elements
	 */
	public int size();
}
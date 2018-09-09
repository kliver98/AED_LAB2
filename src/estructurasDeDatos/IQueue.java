package estructurasDeDatos;

public interface IQueue<T> {
	
	/**
	 * Add an element in the first position.
	 * @param e, Element to insert. Generic data
	 */
	public void offer(T e);
	
	/**
	 * Remove the first element that is in the list.
	 */
	public void removeFirstElement();
	
	/**
	 * Returns the T object, and then removes it
	 * @return T, generic data type
	 */
	public T poll();
	
	/**
	* Returns element T.
	* @return T, Generic data type.
	 */
	public T element();

	/**
	 * Returns the first element that is in the list.
	 * @return T, generic data type.
	 */
	public T first();
	
	/**
	 * Returns the size of the list.
	 * @return int, Total size.
	 */
	public int size();
	
	/**
	 * Returns a boolean depending on whether the list is empty or not.
	 * @return boolean, True if empty. False otherwise.
	 */
	public boolean isEmpty();
	
}
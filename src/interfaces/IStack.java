package interfaces;

public interface IStack<T> {
	
	/**
	 * Retorna un elemento T, para luego eliminarlo de la lista.
	 * @return T. Tipo de dato generico
	 */
	public T pop();
	
	/**
	 * Retorna un elemento T
	 * @return T. tipo de dato generico.
	 */
	public T last();
	
	/**
	 * Elimina el ultimo elemento que se encuentra en la lista.
	 */
	public void removeLastElement();
	
	/**
	 * Agrega un elemeto en la ultima pocision de la lista.
	 * @param value
	 */
	public void push(T value);
	
	/**
	 * Verifica si la lista se encuentra vacia o no.
	 * @return boolean, True Si esta vacia. False de lo contrario
	 */
	public boolean isEmpty();
	
	/**
	 * Retorna el tamaño de la lista.
	 * @return Integer. 0 si esta vicia, Cualquier otro numero dependiendo de los elementos
	 */
	public int size();

}

package estructurasDeDatos;

public interface IQueue<T> {
	
	/**
	 * Agrega un elemento en la primera pocision.
	 * @param e, Elemento a insertar. Dato generico
	 */
	public void offer(T e);
	
	/**
	 * Elimina el primer elemento que se encuentra en la lista.
	 */
	public void removeFirstElement();
	
	/**
	 * Retorna el objeto T, y luego lo elimina
	 * @return T, tipo de dato generico
	 */
	public T poll();
	
	/**
	 * Retorna el elemento T.
	 * @return T, Tipo de dato generico.
	 */
	public T element();

	/**
	 * Retorna el primer elemento que se encuentra en la lista.
	 * @return T, tipo de dato generico.
	 */
	public T first();
	
	/**
	 * Retorna el tamaño de la lista.
	 * @return int, Tamaño total.
	 */
	public int size();
	
	/**
	 * Retorna un boolean dependiedo de si la lista esta vacia o no.
	 * @return boolean, True si esta vacia. False de lo contrario.
	 */
	public boolean isEmpty();
	
}
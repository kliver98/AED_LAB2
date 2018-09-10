package interfaces;

public interface ITable<K,V> {
	
	/**
	 * Returns the value to which the specified key is mapped, or null if this map contains no mapping for the key.<br>
	 * @param key - the key whose associated value is to be returned<br>
	 * @return the value to which the specified key is mapped, or null if this map contains no mapping for the key<br>
	 */
	public V get(Object key);
	
	/**
	 * Returns the hash code value for the key specified.<br>
	 * @param key - to be transform<br>
	 * @return the hash code value for this map<br>
	 */
	public int hashCode(Object key);
	
	/**
	 * Returns true if this map contains no key-value mappings.<br>
	 * @return true if this map contains no key-value mappings<br>
	 */
	public boolean isEmpty();
	
	/**
	 * Associates the specified value with the specified key in this map.<br>
	 * If the map previously contained a mapping for the key, the old value is replaced by the specified value.<br>
	 * @param key - key with which the specified value is to be associated<br>
	 * @param value - value to be associated with the specified key<br>
	 * @return true if it was possible to put the value into the data array of the table<br>
	 */
	public boolean put(K key,V value);
	
	/**
	 * Removes the mapping for a key from this map if it is present.<br>
	 * If this map permit null keys, then it will be deleted that one.<br>
	 * @param key - key whose mapping is to be removed from the map<br>
	 * @return true if it was possible to remove the element(s) with the specified key (May be a list of elements with the same key).<br>
	 */
	public boolean remove(Object key);
	
	/**
	 * Returns the number of key-value mappings in this map.<br>
	 * If the map contains more than Integer.MAX_VALUE elements, returns Integer.MAX_VALUE.<br>
	 * @return the number of key-value mappings in this map<br>
	 */
	public int size();
	
	/**
	 * Removes all of the mappings from this map.<br>
	 * @return true is the table is empty after this operation<br>
	 */
	public boolean clear();
	
}

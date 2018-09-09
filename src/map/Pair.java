package map;

public class Pair<K,V> {

	/**
	 * Attribute that represents the key of the pair<br>  
	 */
	private K key;
	
	/**
	 * Attribute that represents the value of the pair<br>
	 */
	private V value;
	
	/**
	 * Construct a new Pair<br>
	 * @param key - key of the pair<br>
	 * @param value - value of the pair<b>
	 */
	public Pair(K key, V value) {
		this.key = key;
		this.value = value;
	}

	/**
	 * Returns the key<br>
	 * @return key of this pair<br>
	 */
	public K getKey() {
		return key;
	}

	/**
	 * Returns the value<br>
	 * @return value of this pair<br>
	 */
	public V getValue() {
		return value;
	}
	
	@Override
	public boolean equals(Object o) {
		boolean rst = true;
		if ( o instanceof Pair  ) {
			@SuppressWarnings("unchecked")
			Pair<K,V> tmp = (Pair<K, V>) o;
			if ( !this.key.equals(tmp.key) && !this.value.equals(tmp.value) )
				rst = false;
			
		} else {
			rst = false;
		}
		return rst;
	}
	
}

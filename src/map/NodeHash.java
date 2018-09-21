package map;

public class NodeHash<K,V> {

	/**
	 * Attribute that represents the key of the pair<br>  
	 */
	private K key;
	
	/**
	 * Attribute that represents the value of the pair<br>
	 */
	private V value;
	
	/**
	 * Attribute that represents the data array if collisions happen<br>
	 */
	private NodeHash<K,V>[] data;
	
	/**
	 * Attribute that represents the size of slots occupied in the data array<br>
	 */
	private int size;
	
	/**
	 * Attribute that represents the total length of the array data<br>
	 */
	private int length;
	
	/**
	 * Construct a new Pair<br>
	 * @param key - key of the pair<br>
	 * @param value - value of the pair<b>
	 */
	public NodeHash(K key, V value) {
		this.key = key;
		this.value = value;
		this.length = 0;
	}
	
	/**
	 * Method that create an array of 1000 slots to store new data with the same hash code key of this<br>
	 */
	@SuppressWarnings("unchecked")
	public void createDataArray() {
		size = 1000;
		data = new NodeHash[size];
	}
	
	/**
	 * Method that increment the array data created with this hash code key increasing two times the actual size<br>
	 */
	@SuppressWarnings("unchecked")
	private void incrementDataArray() {
		size *= 2;
		NodeHash<K,V>[] copy = new NodeHash[size];
		for (int i = 0; i < data.length; i++) {
			copy[i] = data[i];
		}
		data = new NodeHash[size];
		data = copy;
	}
	
	/**
	 * Method that add a NodeHash into this NodeHash<br>
	 * @param add - NodeHash to be added<br>
	 */
	public void addExtra(NodeHash<K,V> add) {
		if ( length-1 >= size )
			incrementDataArray();
		if ( length <= Integer.MAX_VALUE ) {
			data[length] = add;
			length++;
		}
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
	
	/**
	 * Method that search a NodeHash into this NodeHash<br>
	 * @param key - key to look<br>
	 * @return value of the key<br>
	 */
	public V searchNodeHash(Object key) {
		V rst = null;
		int i = 0;
		if ( data!=null ) {
			for (i = 0; i < data.length && rst==null; i++) {
				if ( data[i]!=null && key.toString().equals(data[i].getKey().toString()) )
					rst = data[i].getValue();
			}
		}
		return rst;
	}
	
	/**
	 * Method that delete a NodeHash into this NodeHash<br>
	 * @param key - key to delete the NodeHash<br>
	 * @return true if it was deleted the NodeHash<br>
	 */
	public boolean deleteNodeHash(Object key) {
		boolean rst = false;
		int i = 0;
		for (i = 0; i < data.length && !rst; i++) {
			if ( key.toString().equals(data[i].getKey().toString()) ) {
				rst = true;
				data[i] = null;
				length--;
			}
		}
		for (int j = i; j < data.length-1 && rst; j++) {
			data[j] = data[j+1];
		}
		if ( rst )
			data[data.length-1] = null;
		return rst;
	}
	
	@Override
	public boolean equals(Object o) {
		boolean rst = true;
		if ( o instanceof NodeHash  ) {
			@SuppressWarnings("unchecked")
			NodeHash<K,V> tmp = (NodeHash<K, V>) o;
			if ( !this.key.equals(tmp.key) && !this.value.equals(tmp.value) )
				rst = false;
			
		} else {
			rst = false;
		}
		return rst;
	}

	/**
	 * Method that returns the length of elements = {key,value} stored<br>
	 * @return length of the slots occupied<br>
	 */
	public int getSize() {
		return length;
	}

	/**
	 * Method that returns the array of data stores with the same has code of this key<br>
	 * @return
	 */
	public NodeHash<K, V>[] getData() {
		return data;
	}

	/**
	 * Method that put a new Key on this element<br>
	 * @param key - new key to be replaced<br>
	 */
	public void setKey(K key) {
		this.key = key;
	}

	/**
	 * Method that put a new value in this element<br>
	 * @param value - new vaue to be put in this element<br>
	 */
	public void setValue(V value) {
		this.value = value;
	}
	
}

package map;

import interfaces.ITable;

@SuppressWarnings("unchecked")
public class HashTable<K,V> implements ITable<K,V> {

	/**
	 * Attribute that represents all the elements stored in the hash table<br>
	 */
	private Pair<K,V>[] data;
	
	/**
	 * Attribute that represents the keys stored in the hash table<br>
	 */
	private int size;
	
	/**
	 * Attribute that represents the length of slots in the hash table<br> 
	 */
	private int length;
	
	/**
	 * Attribute that represents the percent of capacity available used of slots in the data array<br>
	 */
	private double capacity;
	
	/**
	 * Attribute that represents the lengths of the slots in the table - This values will help to do rehashing<br>
	 */
	private static int[] LENGTHS = {23,29,37,43,47,53,59,67,73,79,83,89,97,103,107,113,127,137,149,157,167,179,211,227,239,251,263,277,293,311,997};
	
	/**
	 * Construct a new HashTable<br>
	 * @param size - size of the HashMap<br>
	 */
	public HashTable() {
		length = LENGTHS[0];
		data = new Pair[length];
		size = 0;
		capacity = 0;
	}
	
	@Override
	public boolean put(K key, V value) {
		boolean succed = false;
		int i = hashCode(key);
		if ( i != -1 ) {
			data[i] = new Pair<K,V>(key,value);
			succed = true;
			size+=1;
		}
		calculateCapacity();
		return succed;
	}
	
	@Override
	public int hashCode(Object key) {
		int k = 0;
		k = (Integer.parseInt(key.toString()) & 0x7fffffff) % size;
		return k;
	}
	
	@Override
	public V remove(Object key) {
		int i = hashCode(key);
		V deleted = null;
		if ( i!=-1 ) {
			deleted = data[i].getValue();
			data[i] = null;
			size-=1;
		}
		calculateCapacity();
		return deleted;
	}
	
	@Override
	public int size() {
		return size;
	}

	@Override
	public V get(Object key) {
		int i = hashCode(key);
		V rst = null;
		if ( i != -1 )
			rst = data[i].getValue();
		return rst;
	}

	@Override
	public boolean isEmpty() {
		return size==0 ? true:false;
	}
	
	@Override
	public boolean equals(Object o) {
		boolean rst = true;
		if ( o instanceof HashTable ) {
			HashTable<K,V> tmp = (HashTable<K,V>)o;
			if ( !(this.data.equals(tmp.data)) )
				rst = false;
		} else {
			rst = false;
		}
		return rst;
	}

	@Override
	public boolean clear() {
		length = LENGTHS[0];
		data = new Pair[length];
		size = 0;
		capacity = 0;
		return isEmpty();
	}
	
	/**
	 * Calculate the percentage of slots in the array that are being used<br>
	 */
	private void calculateCapacity() {
		double newCapacity = (double)size()/length;
		this.capacity = newCapacity;
	}
	
	/**
	 * Returns the percentage of capacity that are being used in the array (the slots)<br>
	 * @return capacity used<br>
	 */
	public double getCapacity() {
		return capacity;
	}
	
	/**
	 * Method that copy all the data into a new array larger<br>
	 * @return true if it was possible expand the array<br>
	 */
	public boolean reHashing() {
		int newLength = 0;
		boolean entered = false;
		for (int i = 0; i < LENGTHS.length-1 && !entered; i++) {
			if ( length == LENGTHS[i] ) {
				newLength = LENGTHS[i+1];
				entered = true;
			}
		}
		if ( entered ) { //Copy the data to the new array
			length = newLength;
			Pair<K,V>[] tmp = data;
			data = new Pair[length];
			for (int i = 0; i < tmp.length; i++) {
				data[i] = tmp[i];
			}
		}
		return entered;
	}
	
}

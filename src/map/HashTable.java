package map;

import interfaces.ITable;

@SuppressWarnings("unchecked")
public class HashTable<K,V> implements ITable<K,V> {

	/**
	 * Attribute that represents all the elements stored in the hash table<br>
	 */
	private NodeHash<K,V>[] data;
	
	/**
	 * Attribute that represents the maximum value percentage that data array must have to not do re-hashing<br> 
	 */
	private double maxUtilPercentage = 70;
	
	/**
	 * Attribute that represents the slots stored in the hash table (Not the number of keys because it may be collisions)<br>
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
		data = new NodeHash[length];
		size = 0;
		capacity = 0;
	}
	
	@Override
	public boolean put(K key, V value) {
		int i = hashCode(key), j = 0;
		boolean rst = false;
		if ( data[i] == null ) {
			data[i] = new NodeHash<K,V>(key,value);
			size+=1;
			rst = true;
		}else {
			if (data[i].getSize() == 0)
				data[i].createDataArray();
			data[i].addExtra(new NodeHash<K,V>(key,value));
			j = data[i].getSize()-1;
			rst = data[i].getData()[j].getValue().equals(value);
		}
		calculateCapacity();
		if ( capacity > maxUtilPercentage )
			reHashing();
		return rst;
	}
	
	@Override
	public int hashCode(Object key) {
		int k = 0;
		char[] chars = key.toString().toCharArray();
		for (int i = 0; i < chars.length; i++) {
			k += Character.getNumericValue(chars[i]);
			if ( k > length*5 ) {
				k = k % size;
			}
		}
		if ( k > length-1 )
			k = k % size;
		return (k & 0x7fffffff);
	}
	
	@Override
	public boolean remove(Object key) {
		int i = hashCode(key);
		boolean rst = false;
		if ( data[i].getKey().toString().equals(key.toString()) ) {
			data[i] = null;
			size-=1;
			calculateCapacity();
			rst = true;
		}else { //If was not the same key lexicographically
			rst = data[i].deleteNodeHash(key);
		}
		return rst;
	}
	
	@Override
	public int size() {
		return size;
	}

	@Override
	public V get(Object key) {
		int i = hashCode(key);
		V tmp = null;
		if ( data[i].getValue().toString().equals(key.toString()) )
			tmp = data[i].getValue();
		else {
			tmp = data[i].searchNodeHash(key);
		}
		return tmp;
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
		data = new NodeHash[length];
		size = 0;
		capacity = 0;
		return isEmpty();
	}
	
	/**
	 * Calculate the percentage of slots in the array that are being used<br>
	 */
	private void calculateCapacity() {
		double newCapacity = (double)size/length;
		this.capacity = newCapacity*100;
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
	private boolean reHashing() {
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
			NodeHash<K,V>[] tmp = new NodeHash[length];
			for (int i = 0; i < data.length; i++) {
				tmp[i] = data[i];
			}
			data = new NodeHash[length];
			data = tmp;
		}
		return entered;
	}
	
}

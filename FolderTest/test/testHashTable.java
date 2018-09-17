package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Random;

import org.junit.jupiter.api.Test;

import map.HashTable;

public class testHashTable {

	private HashTable<Object,Integer> table;
	private String generalKey;
	private Integer untilValue;
	
	private void setupEscenario1() {
		table = new HashTable<Object,Integer>();
		generalKey = "Test";
		untilValue = 90;
		for (int i = 1; i <= untilValue; i++) {
			table.put(generalKey,i);
		}
	}
	
	private void setupEscenario2() {
		table = new HashTable<Object,Integer>();
		generalKey = "Test";
		for (int i = 0; i < 10; i++) {
			table.put(generalKey+i,i);
		}
	}

	private void setupEscenario3() {
		table = new HashTable<Object,Integer>();
		generalKey = "Test";
		table.put(generalKey,0);
	}

	private void setupEscenario4() {
		table = new HashTable<Object,Integer>();
	}

	@Test
	public void testGet() {
		setupEscenario1();
		assertEquals(untilValue,table.get(generalKey));
	}
	
	@Test
	public void testHashCode() {
		setupEscenario4();
		char var = 'A';
		int value = table.hashCode(var);
		assertTrue(Character.getNumericValue(var)==value);
	}
	
	@Test
	public void testIsEmpty() {
		setupEscenario3();
		assertFalse(table.isEmpty());
	}
	
	@Test
	public void testPut() {
		setupEscenario1();
		Random r = new Random(System.currentTimeMillis());
		int actualSize = table.size();
		int k = r.nextInt(5);
		for (int i = 0; i < k; i++) {			
			table.put(new Integer(i),0);
		}
		actualSize += k;
		assertEquals(actualSize,table.size());
	}
	
	@Test
	public void testRemove() {
		setupEscenario3();
		int actualSize = table.size();
		table.remove(generalKey);
		actualSize -= 1;
		assertEquals(actualSize,table.size());
	}
	
	@Test
	public void testSize() {
		setupEscenario4();
		Random r = new Random(System.currentTimeMillis());
		int k = r.nextInt(5);
		for (int i = 0; i < k; i++) {
			table.put(generalKey+"-"+i,i);
		}
		assertEquals(table.size(),k);
	}
	
	@Test
	public void testClear() {
		setupEscenario2();
		int actual_size = table.size();
		table.clear();
		assertFalse(table.size()==actual_size);
	}
	
}

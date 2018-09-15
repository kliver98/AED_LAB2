package test;

import static org.junit.Assert.fail;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import collection.*;
import interfaces.*;

public class testQueue {
	
	private IStack<Object> lista;
	
	private void setupEscenario1() {
		lista = new List<Object>();
		
		for (int i = 0; i < 100; i++) {
			lista.push(i*2);
			lista.push(i+2);
		}
	}
	
	private void setupEscenario2() {
		lista = new List<Object>();
		
		for (int i = 0; i < 200; i++) {
			lista.push((i*2)+1);
			lista.push((i+2)*5);
		}
	}
	
	private void setupEscenario3() {
		lista = new List<Object>();
		
		for (int i = 0; i < 200; i++) {
			lista.push((Math.pow(i, Math.sqrt(i)))+1);
		}
	}
	
	private void setupEscenario4() {
		lista = new List<Object>();
	}
	
	@Test
	public void testPop() {
		setupEscenario1();
		
		int i = 99;
		while (!lista.isEmpty()) {
			assertEquals((i+2),(int) lista.pop());
			assertEquals((i*2),(int) lista.pop());
			i--;
		}
		
		if (!lista.isEmpty()) 
			fail();
	}
	
	@Test
	public void testLast() {
		setupEscenario2();
		
		int i = 199;
		while (!lista.isEmpty()) {
			assertEquals((i+2)*5,(int) lista.pop());
			assertEquals((i*2)+1,(int) lista.pop());
			i--;
		}
		
		if (!lista.isEmpty()) 
			fail();
	}
	
	@Test
	public void testRemoveLastElement() {
		setupEscenario3();
		int i = 198;
		int size = lista.size();
		lista.removeLastElement();
		
		assertEquals((Math.pow(i, Math.sqrt(i)))+1, lista.last());
		
		if (size == lista.size()) 
			fail();
		
		if (lista.isEmpty()) 
			fail();
	}
	
	@Test
	public void testPush() {
		setupEscenario4();
		
		for (int i = 2; i < Math.pow(25, 2); i *= i) 
			lista.push(i*Math.sqrt(18));

		assertEquals(4, lista.size());
		if (lista.isEmpty()) 
			fail();
		
		for (int i = 256; i > 1; i = (int) Math.sqrt(i)) {
			double x = (double) lista.last();
			assertEquals(x, i*Math.sqrt(18));
			lista.removeLastElement();
		}
	}
	
	@Test
	public void testIsEmpty() {
		setupEscenario2();
		
		if (lista.isEmpty()) 
			fail();
		
		while(!lista.isEmpty()) 
			lista.removeLastElement();
		
		if (!lista.isEmpty()) 
			fail();
	}
	
	@Test
	public void testSize() {
		setupEscenario4();
		assertEquals(0, lista.size());
		
		setupEscenario2();
		assertEquals(400, lista.size());
		
		setupEscenario1();
		assertEquals(200, lista.size());
	}
	
}

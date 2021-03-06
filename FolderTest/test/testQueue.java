package test;

import static org.junit.Assert.fail;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import collection.*;
import interfaces.*;

public class testQueue {
	
	private IQueue<Object> lista;
	
	private void setupEscenario1() {
		lista = new List<Object>();
		
		for (int i = 0; i < 100; i++) {
			lista.offer(i*2);
			lista.offer(i+2);
		}
	}
	
	private void setupEscenario2() {
		lista = new List<Object>();
		
		for (int i = 0; i < 200; i++) {
			lista.offer((i*2)+1);
			lista.offer((i+2)*5);
		}
	}
	
	private void setupEscenario3() {
		lista = new List<Object>();
		
		for (int i = 0; i < 200; i++) {
			lista.offer((Math.pow(i, Math.sqrt(i)))+1);
		}
	}
	
	private void setupEscenario4() {
		lista = new List<Object>();
	}
	
	@Test
	public void testPoll() {
		setupEscenario1();
		
		int i = 0;
		while (!lista.isEmpty()) {
			assertEquals((i*2),(int) lista.poll());
			assertEquals((i+2),(int) lista.poll());
			i++;
		}
		
		if (!lista.isEmpty()) 
			fail();
	}
	
	@Test
	public void testFirst() {
		setupEscenario2();
		
		int i = 0;
		while (!lista.isEmpty()) {
			assertEquals((i*2)+1,(int) lista.poll());
			assertEquals((i+2)*5,(int) lista.poll());
			i++;
		}
		
		if (!lista.isEmpty()) 
			fail();
	}
	
	@Test
	public void testRemoveFirstElement() {
		setupEscenario3();
		int i = 0;
		int size = lista.size();
		lista.removeFirstElement();
		
		assertEquals((Math.pow(i, Math.sqrt(i)))+1, lista.first());
		
		if (size == lista.size()) 
			fail();
		
		if (lista.isEmpty()) 
			fail();
	}
	
	@Test
	public void testOffer() {
		setupEscenario4();
		
		for (int i = 2; i < Math.pow(25, 2); i *= i) 
			lista.offer(i*Math.sqrt(18));

		assertEquals(4, lista.size());
		if (lista.isEmpty()) 
			fail();
		
		for (int i = 2; i < Math.pow(25, 2); i *= i) {
			double x = (double) lista.first();
			assertEquals(x, i*Math.sqrt(18));
			lista.removeFirstElement();
		}
	}
	
	@Test
	public void testIsEmpty() {
		setupEscenario2();
		
		if (lista.isEmpty()) 
			fail();
		
		while(!lista.isEmpty()) 
			lista.removeFirstElement();
		
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

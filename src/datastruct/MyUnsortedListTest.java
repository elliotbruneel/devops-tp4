package datastruct;

import org.junit.*;
import static org.junit.Assert.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import org.junit.jupiter.api.Assertions;

class MyUnsortedListTest {
	protected UnsortedList<Integer> integers;
	protected UnsortedList<String> strings;
	protected UnsortedList<Integer> empty;
	
	@BeforeEach
	void setUp() throws Exception {
		integers = MyUnsortedList.of(1, 2, 3, 4);
		strings = MyUnsortedList.of("Hello","World");
		empty = MyUnsortedList.of();
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testIsEmpty() {
		assertTrue("Is empty list empty",empty.isEmpty());
		empty.append(1);
		assertFalse("Is non empty list empty",empty.isEmpty());
		empty.pop();
		assertTrue("Is empty list after pop empty",empty.isEmpty());
	}
	
	@Test
	void testSize() {
		assertEquals("Size list empty",0,empty.size());
		assertEquals("Size list integers",4,integers.size());
		assertEquals("Size list strings",2,strings.size());
		integers.append(5);
		assertEquals("Size list integers after append",5,integers.size());
		integers.prepend(0);
		assertEquals("Size list integers after prepend",6,integers.size());
		integers.insert(5,6);
		assertEquals("Size list integers after insert",7,integers.size());
		integers.pop();
		assertEquals("Size list integers after pop",6,integers.size());
		integers.remove(5);
		// On a detecte ici que remove ne mettait pas a jour la taille
		assertEquals("Size list integers after remove",5,integers.size());
		integers.popLast();
		assertEquals("Size list integers after popLast",4,integers.size());
	}
	
	@Test
	void testPrepend() {
		UnsortedList<Integer> integers2 = MyUnsortedList.of(0, 1, 2, 3, 4);
		UnsortedList<String> strings2 = MyUnsortedList.of("Hey","Hello","World");
		UnsortedList<Integer> empty2 = MyUnsortedList.of(0);
		integers.prepend(0);
		strings.prepend("Hey");
		empty.prepend(0);
		assertEquals("List of integers after prepend",integers2,integers);
		assertEquals("List of string after prepend",strings2,strings);
		assertEquals("List of (previously empty) integers after prepend",empty2,empty);
	}
	
	@Test
	void testAppend() {
		UnsortedList<Integer> integers2 = MyUnsortedList.of(1, 2, 3, 4, 5);
		UnsortedList<String> strings2 = MyUnsortedList.of("Hello","World","!");
		UnsortedList<Integer> empty2 = MyUnsortedList.of(0);
		integers.append(5);
		strings.append("!");
		empty.append(0);
		assertEquals("List of integers after append",integers2,integers);
		assertEquals("List of string after append",strings2,strings);
		assertEquals("List of (previously empty) integers after append",empty2,empty);
	}
	
	@Test
	void testInsert(){
		UnsortedList<Integer> integers1 = MyUnsortedList.of(1, 2, 3, 4, 5);
		UnsortedList<Integer> integers2 = MyUnsortedList.of(0, 1, 2, 3, 4, 5);
		UnsortedList<Integer> integers3 = MyUnsortedList.of(0, 1, 2, 6, 3, 4, 5);
		UnsortedList<String> strings1 = MyUnsortedList.of("Hello","World","!");
		UnsortedList<String> strings2 = MyUnsortedList.of("Hey","Hello","World","!");
		UnsortedList<String> strings3 = MyUnsortedList.of("Hey",",","Hello","World","!");
		UnsortedList<Integer> empty2 = MyUnsortedList.of(0);
		
		integers.insert(5,4);
		strings.insert("!",2);
		empty.insert(0,0);
		assertEquals("List of integers after insert to the end",integers1,integers);
		assertEquals("List of string after insert to the end",strings1,strings);
		assertEquals("List of (previously empty) integers after insert",empty2,empty);
		
		integers.insert(0,0);
		strings.insert("Hey",0);
		assertEquals("List of integers after insert to the start",integers2,integers);
		assertEquals("List of string after insert to the start",strings2,strings);
		
		integers.insert(6,3);
		strings.insert(",",1);
		assertEquals("List of integers after insert into",integers3,integers);
		assertEquals("List of string after insert into",strings3,strings);
		
		Assertions.assertThrows(IndexOutOfBoundsException.class, () -> integers.insert(6,33));
		Assertions.assertThrows(IndexOutOfBoundsException.class, () -> integers.insert(6,-5));
		Assertions.assertThrows(IndexOutOfBoundsException.class, () -> integers.insert(6,8));
		Assertions.assertThrows(IndexOutOfBoundsException.class, () -> integers.insert(6,-1));
	}
	
	@Test
	void testPop() {
		UnsortedList<Integer> integers2 = MyUnsortedList.of(2, 3, 4);
		UnsortedList<String> strings2 = MyUnsortedList.of("World");
		integers.pop();
		strings.pop();
		assertEquals("List of integers after pop",integers2,integers);
		assertEquals("List of strings after pop",strings2,strings);
		Assertions.assertThrows(EmptyListException.class, () -> empty.pop());
	}
	
	@Test
	void testPopLast() {
		UnsortedList<Integer> integers2 = MyUnsortedList.of(1, 2, 3);
		UnsortedList<String> strings2 = MyUnsortedList.of("Hello");
		integers.popLast();
		strings.popLast();
		assertEquals("List of integers after popLast",integers2,integers);
		assertEquals("List of strings after popLast",strings2,strings);
		Assertions.assertThrows(EmptyListException.class, () -> empty.pop());
	}
	
	@Test
	void testRemove(){
		UnsortedList<Integer> integers1 = MyUnsortedList.of(2, 3, 4);
		UnsortedList<Integer> integers2 = MyUnsortedList.of(2, 4);
		UnsortedList<Integer> integers3 = MyUnsortedList.of(2);
		UnsortedList<String> strings1 = MyUnsortedList.of("Hello","!");
		UnsortedList<String> strings2 = MyUnsortedList.of("Hello");
		UnsortedList<String> strings3 = MyUnsortedList.of();
		strings.append("!");
		
		Assertions.assertThrows(IndexOutOfBoundsException.class, () -> integers.remove(33));
		Assertions.assertThrows(IndexOutOfBoundsException.class, () -> integers.remove(-5));
		Assertions.assertThrows(IndexOutOfBoundsException.class, () -> integers.remove(-1));
		Assertions.assertThrows(IndexOutOfBoundsException.class, () -> integers.remove(integers.size()));
		
		integers.remove(0);
		strings.remove(1);
		assertEquals("List of integers after remove to the start",integers1,integers);
		assertEquals("List of string after remove inside",strings1,strings);
		
		integers.remove(1);
		strings.remove(1);
		assertEquals("List of integers after remove inside",integers2,integers);
		assertEquals("List of string after remove to the end",strings2,strings);
		
		integers.remove(1);
		strings.remove(0);
		assertEquals("List of integers after remove at the end",integers3,integers);
		assertEquals("List of string after remove",strings3,strings);
	}
	

}

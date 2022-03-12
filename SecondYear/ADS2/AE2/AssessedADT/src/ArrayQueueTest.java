import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.PriorityQueue;

import org.junit.jupiter.api.Test;

class ArrayQueueTest {
	
	PriorityQueue<Integer> priorityQueue = new PriorityQueue<Integer>();
	
	void addNumbers(int[] numbers) {
		for (int num : numbers) {
			priorityQueue.add(num);
		}
	}

	@Test
	void compareCreatingTest() {
		int[] arr = new int[]{15, 12, 10, 17, 4, 1, 11, 7, 9, 20, 8};
		ArrayQueue arrQueue = new ArrayQueue(arr.length);
		arrQueue.build_min_heap(arr);
		addNumbers(arr);
		Integer[] priorityArray = priorityQueue.toArray(new Integer[11]);
		boolean equals = true;
		for (int i=0; i < priorityArray.length; i++) { 
			if (priorityArray[i] != arrQueue.q[i+1]) {
				equals = false;
			}
		}
		assertTrue(equals);	
	}
	
	@Test
	void compareInsertingTest() {
		ArrayQueue arrQueue = new ArrayQueue(3);
		arrQueue.insert(3);
		priorityQueue.add(3);
		assertEquals(arrQueue.q[1], priorityQueue.peek());
	}
	
	@Test
	void compareMinTest() { 
		ArrayQueue arrQueue = new ArrayQueue(3);
		arrQueue.insert(3);
		priorityQueue.add(3);
		assertEquals(arrQueue.min(), priorityQueue.peek());
	}

	@Test
	void insertAndRearrangeTest() {
		ArrayQueue arrQueue = new ArrayQueue(3);
		arrQueue.insert(3);
		arrQueue.insert(1);
		
		priorityQueue.add(3);
		priorityQueue.add(1);
		Integer[] priorityArray = priorityQueue.toArray(new Integer[3]);
		boolean equals = true;
		for (int i=0; i < 2; i++) {
			if (priorityArray[i] != arrQueue.q[i+1])
				equals = false;
		}
		assertTrue(equals);
	}
	
	@Test
	void insertTest() {
		ArrayQueue arrQueue = new ArrayQueue(3);
		arrQueue.insert(1);
		arrQueue.insert(3);
		
		priorityQueue.add(1);
		priorityQueue.add(3);
		Integer[] priorityArray = priorityQueue.toArray(new Integer[3]);
		boolean equals = true;
		for (int i=0; i < 2; i++) {
			if (priorityArray[i] != arrQueue.q[i+1])
				equals = false;
		}
		assertTrue(equals);
	}
	
	@Test
	void extractReturnsSameTest() {
		ArrayQueue arrQueue = new ArrayQueue(3);
		arrQueue.insert(7);
		arrQueue.insert(1);
		arrQueue.insert(5);
		
		priorityQueue.add(7);
		priorityQueue.add(1);
		priorityQueue.add(5);
		assertEquals(arrQueue.extract_min(), priorityQueue.poll());
		
	}
	
	@Test
	void extractMinRootTest() {
		ArrayQueue arrQueue = new ArrayQueue(2);
		arrQueue.insert(2);
		arrQueue.insert(5);
		
		priorityQueue.add(2);
		priorityQueue.add(5);
		
		arrQueue.extract_min();
		priorityQueue.poll();
		Integer[] priorityArray = priorityQueue.toArray(new Integer[2]);
		boolean equals = true;
		assertEquals(arrQueue.q[1], priorityArray[0]);
	}
	
	@Test
	void extractEmptyTest() {
		ArrayQueue arrQueue = new ArrayQueue(1);
		assertEquals(-1, arrQueue.extract_min());
	}
}
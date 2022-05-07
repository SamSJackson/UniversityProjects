package ds.basic.samjackson.structures;

public class Heap {

	int[] arr;
	int n;
	
	public Heap() {
		this.arr = new int[3];
	}
	
	public Heap(int[] arr) {
		this.n = arr.length;
		this.arr = new int[n];
		for (int i=0; i < n; i++) {
			this.arr[i] = arr[i];
		}
		build_max_heap();
	}
	
	private int left(int i) {
		return (2*i) + 1;
	}
	private int right(int i) {
		return (2*i) + 2;
	}
	
	private void heapify(int i) {
		int largest = i;
		int left_c = left(i);
		int right_c = right(i);
		if (left_c < this.n && this.arr[left_c] > this.arr[largest]) {
			largest = left_c;
		}
		if (right_c < this.n && this.arr[right_c] > this.arr[largest]) {
			largest = right_c;
		}
		if (largest != i) {
			int temp = this.arr[i];
			this.arr[i] = this.arr[largest];
			this.arr[largest] = temp;
			
			heapify(largest);
		}
	}
	
	private void build_max_heap() {
		for (int i=(n/2) - 1; i >= 0; i--) {
			heapify(i);
		}
	}
	
	public void printHeap() { 
		System.out.print("[ ");
		for (int num : this.arr) {
			System.out.print(num + " ");
		}
		System.out.println("]");
	}
}

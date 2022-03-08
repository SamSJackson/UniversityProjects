
// Note that this array queue is a min priority queue.
// Also a binary heap array
public class ArrayQueue {

	// Operations to contain
	// Insert (Add an element into q)
	// Min (returns the element with the smallest key)
	// Extract-min (Removes and return the element of queue with smallest key)

	// Heap array is created as 0 with root
	// Each consequent tree is indexed from left to right

	// Going to create heap array with max-heap otherwise hard to remove from root
	// with extract-min
	// Cancel that, it is easier to find and return root with min-heap.
	//

	private int[] q;
	private int n;

	public ArrayQueue(int n) {
		this.n = 0;
		this.q = new int[n];
	}

	public void printArray() {
		System.out.print("[ ");
		for (int num : this.q) {
			System.out.print(num + " ");
		}
		System.out.println("]");
	}

	private void swap(int i, int j) {
		int temp = this.q[j];
		this.q[j] = this.q[i];
		this.q[i] = temp;
	}

	private int left(int i) {
		return (2 * i) + 1;
	}

	private int right(int i) {
		return (2 * i) + 2;
	}

	public int min() {
		return this.q[0];
	}

	public int extract_min() {
		int index = 0;
		int num = min();
		swap(index, n - 1);
		this.q[--n] = 0;
		for (int i = (n / 2) - 1; i >= 0; i--) {
			heapify(i);
		}
		return num;
	}

	private void heapify(int i) {
		int smallest = i;
		int l = left(i);
		int r = right(i);
		if (l < this.n && this.q[l] < this.q[smallest]) {
			smallest = l;
		}
		if (r < this.n && this.q[r] < this.q[smallest]) {
			smallest = r;
		}
		if (smallest != i) {
			swap(i, smallest);
			heapify(smallest);
		}
	}

	public void insert(int x) {
		this.q[n++] = x;
		// If not at root
		if (n - 1 != 0) {
			// Work way down tree, checking if insertion has violated heap rule
			for (int i = (n / 2) - 1; i >= 0; i--) {
				heapify(i);
			}
		}
	}

}


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

	// Note that (log n) refers to (log_2 n) as opposed to the standard (log_10 n) since 2 is number of nodes
	private int[] q;
	private int n;

	public ArrayQueue(int n) {
		this.n = 0;
		this.q = new int[n+1]; // Index 0 is kept empty
	}

	public void printArray() {
		System.out.print("[ ");
		for (int i=1; i < n; i++) {
			System.out.print(this.q[i] + " ");
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
	
	private int parent(int i) {
		return i/2;
	}

	// Constant time operation O(1)
	public int min() {
		return this.q[1];
	}

	// Swapping is constant operation + heapify which is O(log n)
	// Hence extract_min is O(log n) operation
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

	// Operation time worst case is O(log n) since it may have to traverse height of tree
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
	
	// O(n) * O(log n) since insert is O(log n) operation
	// Hence O(n log n) operation 
	public void build_heap(int[] arr) {
		for (int num : arr) {
			insert(num);
		}
	}
	

	// O(log n) operation since heapify
	public void insert(int x) {
		if (n == q.length) {
			System.out.println("Overflow");
			return;
		}
		this.q[++n] = x;
		// If not at root
		int k = n;
		while (k > 1 && this.q[k/2] > this.q[k]) {
			swap(k, k/2);
			k = k/2;
		}
	}

}

package sam.ads2.lab3;

public class ResizingQueue {
	private int[] q;
	private int n;
	public int tail;
	public int head;
	
	public ResizingQueue() {
		q = new int[2];
		n = q.length;
		head = 0;
		tail = 0;
	}
	
	public void printQueue() {
		System.out.print("[ ");
		for (int num : this.q) {
			System.out.print(num + " ");
		}
		System.out.println("]");
	}
	
	private int queueSize() {
		return (n - this.head + this.tail) % n;	
	}
	
	private boolean isEmpty() {
		return this.head == this.tail;
	}
	
	private void resize(int size) {
		int[] newArray = new int[size];
		for (int i=0; i < size-1; i++) {
			newArray[i] = this.q[(this.head + i) % n];
		}
		this.q = newArray;
		this.head = 0;
		this.tail = this.n-1;
	}
	
	public void push_back(int x) {
		if (queueSize() == this.n) {
			resize(this.n*2);
		}
		this.q[this.tail] = x;
		this.tail = (this.tail + 1) % n;
		this.n++;
	}
	
	public int pop_front() {
		if (isEmpty())
			throw new IllegalArgumentException("underflow");
		int x = this.q[this.head];
		this.head = (this.head + 1) % n;
		if (queueSize() == (this.n / 4))
			resize(n/2);
		return x;
	}
	
}

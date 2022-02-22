package sam.ads2.lab3;

public class ResizingDequeue {
	private int[] q;
	private int n;
	private int tail;
	private int head;
	
	public ResizingDequeue() {
		q = new int[2];
		n = 0;
		head = 0;
		tail = 0;
	}
	
	public boolean isEmpty() {
		return head == tail;
	}
	
	public int queue_size() {
		return (this.n - this.head + this.tail) % n;
	}
	
	private void resize_double() { 
		int[] newArray = new int[n*2];
		for (int i = 0; i < n; i++) {
			newArray[i] = q[i];
		}
		this.q = newArray;
		this.n = q.length;
	}
	
	private void resize_half() {
		int[] newArray = new int[n/2];
		for (int i=0; i < n/4; i++) {
			newArray[i] = q[i];
		}
		this.q = newArray;
		this.n = q.length;
	}
	
	public boolean push_back(int x) {
		if (queue_size() == n-1) {
			throw new IllegalArgumentException("Overflow");
		}
		else {
			this.q[this.tail] = x;
			this.tail = (this.tail + 1) % n;
			return true;
		}
	}
	
	public boolean dequeue
}

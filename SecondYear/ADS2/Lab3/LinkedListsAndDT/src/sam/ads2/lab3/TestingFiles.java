package sam.ads2.lab3;	

public class TestingFiles {
	public static void main(String[] args) {
		ResizingQueue queue = new ResizingQueue();
		queue.push_back(3);
		queue.printQueue();
		queue.push_back(6);
		queue.printQueue();
		queue.push_back(8);
		queue.printQueue();
		System.out.println(queue.tail);
		queue.push_back(12);
		queue.printQueue();
		System.out.println(queue.tail);
		queue.push_back(16);
		queue.printQueue();
	}
}

package sam.ads2.lab3;

public class Algorithms {

	
	private static LinkedList Merge(LinkedList a, LinkedList b) {
		if (a == null) {
			return b;
		} else if (b == null) {
			return a;
		}
		
		LinkedList x = null;
		if (a.getKey() <= b.getKey()) {
			x = a;
			x.setNext(Merge(a.getNext(), b));
		} else {
			x = b;
			x.setNext(Merge(a, b.getNext()));
		}
		return x;
	}
}

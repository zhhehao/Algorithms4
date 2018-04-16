import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import java.util.Iterator;

public class Queue<Item> implements Iterable<Item> {
	
    private Node first;
    private Node last;
	private int N;
	private class Node {
		Item item;
		Node next;
	}
	
	public boolean isEmpty() {
		return first == null;
	}
	
	public int size() {
		return N;
	}
	
	public void enqueue(Item item) {
		Node oldLast = last;
		last = new Node();
		last.item = item;
        last.next = null;
        if (isEmpty()) {
            first = last;
        }
        else {
            oldLast.next = last;
        }
		N++;
	}
	
	public Item dequeue() {
		Item item = first.item;
        first = first.next;
        if (isEmpty()) {
            last = null;
        }
		N--;
		return item;
	}

	// 此处应抛出队列空异常
	public Item peek() {
		return first.item;
	}

	public Iterator<Item> iterator() {
		return new ListIterator();
	}

	private class ListIterator implements Iterator<Item> {
		private Node current = first;
		public boolean hasNext() {
			return current != null;
		}

		public void remove() {

		}

		public Item next() {
			Item item = current.item;
			current = current.next;
			return item;
		}
	}

	public static void main(String[] args) {
		Queue<String> q = new Queue<String>();
		
		while (!StdIn.isEmpty()) {
			String item = StdIn.readString();
			if (!item.equals("-")) {
				q.enqueue(item);
			}
			else if (!q.isEmpty()) {
				StdOut.print(q.dequeue() + " ");
			}
		}
		
		StdOut.println("(" + q.size() + " left on queue)");
	}

	public void catenation (Queue<Item> s) {
		for (Iterator<Item> it = s.iterator(); it.hasNext();) {
			this.enqueue(it.next());
		}
	}
}

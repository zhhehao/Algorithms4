import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import java.util.Iterator;

public class Stack<Item> implements Iterable<Item> 
{
	
	private Node first;
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
	
	public void push(Item item) {
		Node oldFirst = first;
		first = new Node();
		first.item = item;
		first.next = oldFirst;
		N++;
	}
	
	public Item pop() {
		Item item = first.item;
		first = first.next;
		N--;
		return item;
	}

	// 习题 1.3.4
	public Item peek() {
		if (isEmpty()) {
			// 需要处理，可以参照答案，抛出异常
		}
		return first.item;
	}

	public Iterator<Item> iterator() {
		return new ListIterator();
	}

	private class ListIterator implements Iterator<Item> 
	{
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

	// public static void main(String[] args) {
	// 	Stack<String> s = new Stack<String>();
		
	// 	while (!StdIn.isEmpty()) {
	// 		String item = StdIn.readString();
	// 		if (!item.equals("-")) {
	// 			s.push(item);
	// 		}
	// 		else if (!s.isEmpty()) {
	// 			StdOut.print(s.pop() + " ");
	// 		}
	// 	}
		
	// 	StdOut.println("(" + s.size() + " left on stack)");
	// }
}

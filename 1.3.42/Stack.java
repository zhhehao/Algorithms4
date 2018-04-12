/**
 * 习题 1.3.42
 * 
 */

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
		Node() {}

		// // 递归构造一个链表副本
		// Node(Node x) {
		// 	item = x.item;
		// 	if (x.next != null) {
		// 		next = new Node(x.next);
		// 	}
		// }

		// 非递归版
		Node(Node x) {
			item = x.item;
			next = x.next;
		}
	}

	public Stack() {}

	// 非递归版
	public Stack(Stack<Item> s) {
		if (s.first != null) {
			first = new Node(s.first);
			for (Node x = first; x.next != null; x = x.next) {
				x.next = new Node(x.next);
			}
		}
	}

	// // 递归版的构造函数
	// public Stack(Stack<Item> s) {
	// 	// 把创造好的副本指向first
	// 	first = new Node(s.first);
	// }
	
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
}

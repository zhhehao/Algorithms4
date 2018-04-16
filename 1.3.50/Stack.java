/**
 * 习题 1.3.50
 * 
 */

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import java.util.Iterator;
import java.util.ConcurrentModificationException;

public class Stack<Item> implements Iterable<Item> 
{
	
	private Node first;
	private int N;

	private int pop_count;
	private int push_count;

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
		push_count++;
	}
	
	public Item pop() {
		Item item = first.item;
		first = first.next;
		N--;
		pop_count++;
		return item;
	}

	public Iterator<Item> iterator() {
		return new ListIterator();
	}

	private class ListIterator implements Iterator<Item> 
	{
		private Node current = first;
		private int pu_cnt = push_count;
		private int po_cnt = pop_count;

		private void push_or_pop() {
			if (pu_cnt != push_count || po_cnt != pop_count) {
				throw new ConcurrentModificationException("你做了不应该做的操作");
			}
		}
		public boolean hasNext() {
			push_or_pop();
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

	public void catenation (Stack<Item> s) {
		for (Iterator<Item> it = s.iterator(); it.hasNext();) {
			this.push(it.next());
		}
	}
}

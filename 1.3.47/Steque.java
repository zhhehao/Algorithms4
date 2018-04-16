/**
 * 习题 1.3.32
 * 
 * API
 * public class Steque<Item> implements Iterable<Item>
 * -----------------------------------------------
 * Steque()
 * boolean isEmpty()
 * int size()
 * void push(Item item) 栈顶压入
 * Item pop()           栈顶弹出
 * void enqueue(Item item) 栈底压入
 * Iterator<Item> iterator() 迭代器
 */

import java.util.NoSuchElementException;
import java.util.Iterator;

public class Steque<Item> implements Iterable<Item>
{
    private Node first;
    private Node last;
    private int N;

    private class Node 
    {
        Item item;
        Node next;
    }


    public Steque() {
        
    }

    public boolean isEmpty() {
        return N == 0;
    }

    public int size() {
        return N;
    }

    public void push(Item item) {
        if (isEmpty()) {
            first = new Node();
            first.item = item;
            first.next = null;
            last = first;
        }
        else {
            Node old_first = first;
            first = new Node();
            first.item = item;
            first.next = old_first;
        }
        N++;
    }

    public Item pop() {
        if (isEmpty()) {
            throw new NoSuchElementException("队列已空");
        }
        Item item = first.item;
        first = first.next;
        N--;
        return item;
    }

    public void enqueue(Item item) {
        if (isEmpty()) {
            last = new Node();
            last.item = item;
            last.next = null;
            first = last;
        }
        else {
            Node old_last = last;
            last = new Node();
            last.item = item;
            old_last.next = last;
        }       
        N++;
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

        public Item next() {
            Item item = current.item;
            current = current.next;
            return item;
        }

        public void remove() {

        }
    }

	public void catenation (Steque<Item> s) {
		for (Iterator<Item> it = s.iterator(); it.hasNext();) {
			this.push(it.next());
		}
	}
}
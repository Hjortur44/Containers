import java.util.Iterator;

public class Queue<Item> implements Iterable<Item> {
	private Node first, last;
	private int length;
	
	public Queue() {
		first = null;
		last = null;
		length = 0;
	}

	public boolean isEmpty() {
		return first == null;
	}
	
	public int size() {
		return length;
	}
	
	public void push(Item item) {
		Node old = last;
		last = new Node();
		last.item = item;
		last.next = null;
		
		if(isEmpty()) first = last;
		else old.next = last;
		
		length++;
	}
	
	public Item pop() {
		Item item = first.item;
		first = first.next;
		length--;
		
		if(isEmpty()) last = null;
		
		return item;
	}
	
	@Override
	public Iterator<Item> iterator(){
		return new ListIterator();
	}
	
	
	private class Node {
		Item item;
		Node next;
		
		public Node() {
			item = null;
			next = null;
		}
	}	
	
	private class ListIterator implements Iterator<Item>{

		private Node current;
		
		public ListIterator() {
			current = first;
		}
		
		@Override
		public boolean hasNext() {
			return current != null;
		}

		@Override
		public Item next() {
			Item item = current.item;
			current = current.next;
			
			return item;
		}		
	}
}

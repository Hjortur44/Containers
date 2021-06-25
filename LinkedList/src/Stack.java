import java.util.Iterator;

public class Stack<Item> implements Iterable<Item>{

	private Node first;
	private int length;

	public Stack() {
		first = null;
		length = 0;
	}
	
	public boolean isEmpty() {
		return first == null;
	}
	
	public int size() {
		return length;
	}
	
	public void push(Item item) {
		Node old = first;
		first = new Node();
		first.item = item;
		first.next = old;
		length++;
	}
	
	public Item pop() {
		Item item = first.item;
		first = first.next;
		length--;
		
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

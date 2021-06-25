import java.util.Iterator;

public final class Stack<Item> implements IContainer<Item> {

	private Item[] items;
	private int cap, length;
	
	public Stack(int capacity) {
		cap = capacity;
		items = (Item[]) new Object[capacity];
		length = 0;
	}

	@Override
	public Item pop() {
		if(length > 0) {
			Item item = items[--length];
			items[length] = null;
			
			if(length == cap / 4) resize(cap / 2);
			return item;
		}
		
		return null;
	}

	@Override
	public void push(Object item) {
		if(length == cap - 1) {			
			cap *= 2;
			resize(cap);
		}
		
		items[length++] = (Item) item;		
	}

	@Override
	public boolean isEmpty() {
		return length == 0;
	}

	@Override
	public int capacity() {
		return cap;
	}

	@Override
	public int size() {
		return length;
	}
	
	@Override
	public Iterator iterator() {
		return new ContainerIterator();
	}
	
	private void resize(int max) {
		Item[] temp = (Item[]) new Object[max];
		
		for(int i = 0; i < items.length; i++) {
			if(items[i] == null) break;
			temp[i] = items[i];
		}
		
		items = temp;
	}
	
	
	private class ContainerIterator implements Iterator<Item> {

		int m = length;
		
		@Override
		public boolean hasNext() {
			return m > 0;
		}

		@Override
		public Item next() {
			return items[--m];
		}		
	}
}

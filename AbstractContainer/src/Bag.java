import java.util.Iterator;

public class Bag<Item> implements IContainer<Item> {
	
	private Item[] items;
	private int cap, length;
	
	public Bag(int capacity) {
		cap = capacity;
		items = (Item[]) new Object[capacity];
		length = 0;
	}
	
	@Override
	public Item pop() {
		if(length > 0) {
			int i = (int)(Math.random() * length);
			Item item = items[i];
			items[i] = null;
			length--;
			
			if(length == cap / 4) resize(cap / 2);
			return item;
		}
		
		return null;
	}

	@Override
	public void push(Item item) {
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
	public Iterator<Item> iterator() {
		return new ContainerIterator();
	}
	
	private void resize(int max) {
		Item[] temp = (Item[]) new Object[max];
		
		for(int i = 0; i < items.length; i++) {
			if(items[i] != null) temp[i] = items[i];
		}
		
		items = temp;
	}
	
	
	private class ContainerIterator implements Iterator<Item> {

		int m = 0;
		
		@Override
		public boolean hasNext() {
			return m < length - 1;
		}

		@Override
		public Item next() {
			return items[m++];
		}		
	}
}

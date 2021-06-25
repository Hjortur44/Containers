import java.util.Iterator;

public class AbstractContainer<Item> implements Iterable<Item> {
	
	protected Item[] items;
	protected int cap, n;
	
	protected AbstractContainer(int capacity) {
		cap = capacity;
		items = (Item[]) new Object[capacity];
		n = 0;
	}
	
	public Item pop() {		
		Item item = items[--n];
		items[n] = null;
		
		if(n > 0 && n == cap / 4) resize(cap / 2);
		
		return item;
	}
	
	protected void resize(int max) {
		Item[] temp = (Item[]) new Object[max];
		
		for(int i = 0; i < items.length; i++) temp[i] = items[i];
		
		items = temp;
	}
	
	public void push(Item item) {
		int n = items.length;
		
		if(n == cap - 1) {			
			cap *= 2;
			resize(cap);
		}
		
		items[n++] = item;		
	}
	
	public boolean isEmpty() {
		return items.length == 0;
	}
	
	public int capacity() {
		return cap;
	}
	
	public int size() {
		return items.length;
	}

	@Override
	public Iterator<Item> iterator() {
		return new ContainerIterator();
	}
	
	private class ContainerIterator implements Iterator<Item> {

		int m = 0;
		
		@Override
		public boolean hasNext() {
			return m < items.length - 1;
		}

		@Override
		public Item next() {
			return items[m++];
		}		
	}
}
import java.util.Iterator;

public interface IContainer<Item> {
	public Item pop();
	public void push(Item item);	
	public boolean isEmpty();
	public int capacity();	
	public int size();
	public Iterator<Item> iterator();	
}

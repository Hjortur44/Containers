import java.util.Iterator;

public class Driver {

	public static void main(String[] args) {
		Stack<String> stack = new Stack<>();
		Queue<String> queue = new Queue<>();
		String[] list = {"AAA", "BBB", "CCC", "DDD", "EEE", "FFF"};
		
		for(String s : list) {
			stack.push(s);
			queue.push(s);
		}
		
		Iterator<String> itStack = stack.iterator();
		while(itStack.hasNext()) System.out.println(itStack.next());
		
		System.out.println();
		
		Iterator<String> itQueue = queue.iterator();
		while(itQueue.hasNext()) System.out.println(itQueue.next());
	}
}

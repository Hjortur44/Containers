
public class Driver {

	public static void main(String[] args) {
		Stack<Integer> stack = new Stack<>(8);
		Queue<Integer> queue = new Queue<>(8);
		Bag<Integer> bag = new Bag<>(8);
		
		System.out.println(stack.capacity());
		System.out.println(stack.size());
		stack.push(2);
		System.out.println(stack.size());
		System.out.println(stack.pop());
		System.out.println(stack.size());
		
		System.out.println();
		System.out.println(queue.capacity());
		System.out.println(queue.size());
		queue.push(2);
		System.out.println(queue.size());
		System.out.println(queue.pop());
		System.out.println(queue.size());
		
		System.out.println();
		System.out.println(bag.capacity());
		System.out.println(bag.size());
		bag.push(2);
		System.out.println(bag.size());
		System.out.println(bag.pop());
		System.out.println(bag.size());
	}
}

import java.util.*;

public class Main {
	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			int n = (int) Math.pow(10, 10000);
			String s = sc.nextLine();
			char[] arr = s.toCharArray();

			Deque<Character> deque = new ArrayDeque<Character>();
			for (int i = 0; i < arr.length; i++) {
				char c = arr[i];

				if (deque.isEmpty()) {
					deque.addFirst(c);
				} else if (c == 'T' && deque.peekFirst() == 'S' && n > 0) {
					deque.removeFirst();
					n--;
				} else {
					deque.addFirst(c);
				}
			}
			System.out.println(deque.size());
		}
	}
}
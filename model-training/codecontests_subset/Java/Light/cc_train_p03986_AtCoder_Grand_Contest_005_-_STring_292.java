import java.util.ArrayDeque;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		char[] x = sc.next().toCharArray();
		ArrayDeque<Character> deque = new ArrayDeque<>();
		for (int i = 0; i < x.length; i++) {
			if (x[i] == 'S') {
				deque.push(x[i]);
			} else {
				if (deque.isEmpty()) {
					deque.push(x[i]);
				} else if (deque.peek() == 'S') {
					deque.pop();
				} else {
					deque.push(x[i]);
				}
			}
		}
		System.out.println(deque.size());
	}
}

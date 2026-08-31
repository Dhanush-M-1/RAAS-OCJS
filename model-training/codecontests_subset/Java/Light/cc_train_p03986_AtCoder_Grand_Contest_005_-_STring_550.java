import java.io.InputStream;
import java.io.PrintStream;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Scanner;

public class Main {
	InputStream in = System.in;
	PrintStream out = System.out;

	public void _main(String[] args) {
		Scanner sc = new Scanner(in);

		String X = sc.next();

		sc.close();

		Deque<Character> stack = new ArrayDeque<>();

		for(int i=0;i<X.length();i++) {
			char c = X.charAt(i);

			if(c == 'T' && (stack.peek() != null && stack.peek() == 'S')) {
				stack.pop();
			}else {
				stack.push(c);
			}
		}

		out.println(stack.size());
	}

	public static void main(String[] args) {
		new Main()._main(args);
	}
}

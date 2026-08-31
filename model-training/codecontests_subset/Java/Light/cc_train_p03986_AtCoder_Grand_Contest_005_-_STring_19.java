import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String str[] = br.readLine().split("");

		Deque<String> stack = new ArrayDeque<>();

		for (int i = 0; i < str.length; i++) {
			if (str[i].equals("S")) {
				stack.push(str[i]);
			} else if (str[i].equals("T")) {
				if (stack.isEmpty()) {
					stack.push(str[i]);
				} else if (stack.peek().equals("T")) {
					stack.push(str[i]);
				} else {
					stack.pop();
				}
			}
		}

		System.out.println(stack.size());
	}
}

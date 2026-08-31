import java.util.Scanner;
import java.util.Stack;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String x = sc.next();
		Stack<String> stack = new Stack<>();
		for(int i = 0 ; i < x.length() ; i++) {
			if(stack.size() > 0 && stack.peek().equals("S") && x.charAt(i) == 'T') {
				stack.pop();
			} else {
				stack.add(String.valueOf(x.charAt(i)));
			}
		}
		System.out.println(stack.size());
	}
}

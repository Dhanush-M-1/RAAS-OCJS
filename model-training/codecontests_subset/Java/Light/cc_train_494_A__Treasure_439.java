import java.util.LinkedList;
import java.util.Scanner;
import java.util.Stack;

public class Gold {

	public static void main(String[] args) {
		Stack<Character> s = new Stack<Character>();
		Stack<Character> ss = new Stack<Character>();
		int count = 0;
		@SuppressWarnings("resource")
		Scanner scan = new Scanner(System.in);
		String str = scan.nextLine();
		boolean flag = true;
		LinkedList<Integer> arr = new LinkedList<Integer>();
		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) == '(') {
				s.push(str.charAt(i));
				count++;
			} else if (str.charAt(i) == ')') {
				if (s.size() > 0) {
					s.pop();
					count--;
				} else {
					System.out.print("-1");
					flag = false;
					System.exit(0);
					break;
				}
			} else {
				count = 0;
				if (s.size() != 0) {
					arr.add(1);
					s.pop();

				} else {
					System.out.print("-1");
					flag = false;
					System.exit(0);
					break;
				}
			}
		}

		if (str.charAt(str.length() - 1) == '(' || !flag || count > 0) {
			System.out.print("-1");
			System.exit(0);
		} else {
			if (flag) {
				for (int i = 0; i < arr.size() - 1; i++) {
					System.out.println("1");
				}
				System.out.print(s.size() + 1);
			}
		}

	}

}
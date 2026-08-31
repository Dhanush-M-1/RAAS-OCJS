import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		String s = in.next();
		for (int i = 0; i < n; i++) {
			for (int j = 1; j + i < n && s.charAt(i) == '*'; j++) {
				if (i + 4 * j < n && '*' == s.charAt(i + j) && '*' == s.charAt(i + 2 * j) && '*' == s.charAt(i + 3 * j)
						&& '*' == s.charAt(i + 4 * j)) {
					System.out.println("yes");
					return;
				}
			}
		}
		System.out.println("no");
	}
}

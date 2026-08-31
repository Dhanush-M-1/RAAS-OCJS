import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		solve(s);
		s.close();
	}

	public static void solve(Scanner s) {
		int a = s.nextInt();
		int b = s.nextInt();
		int c = s.nextInt();

		if (a + b == c || a + c == b || b + c == a) {
			System.out.println("Yes");
		} else {
			System.out.println("No");
		}
	}
}
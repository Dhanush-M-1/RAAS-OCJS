import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		N = scanner.nextInt();
		dfs("", 'a');
	}

	static int N;

	static void dfs(String s, char mx) {
		if (s.length() == N) {
			System.out.println(s);
		} else {
			for (char c = 'a'; c <= mx; c++) {
				dfs(s + c, (c == mx ? (char) (mx + 1) : mx));
			}
		}
	}
}

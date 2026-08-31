import java.util.Scanner;

public class Main {
	static int n;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		dfs("", 'a');
		sc.close();
	}
	
	static void dfs(String s, char max) {
		if (s.length() == n)
			System.out.println(s);
		else
			for (char c = 'a'; c <= max; c++)
				dfs(s + c, c == max ? (char) (max + 1) : max);
	}
}

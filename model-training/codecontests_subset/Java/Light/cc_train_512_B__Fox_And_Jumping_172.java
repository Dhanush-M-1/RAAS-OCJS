import java.awt.Point;
import java.util.HashMap;
import java.util.Scanner;

public class D {
	static HashMap<Point, Integer> dp = new HashMap<>();

	static int[] l;
	static int[] c;
	static int N;

	public static void main(String[] args) throws Exception {
		Scanner scan = new Scanner(System.in);
		N = scan.nextInt();
		l = new int[N];
		c = new int[N];

		for (int i = 0; i < N; i++)
			l[i] = scan.nextInt();
		for (int i = 0; i < N; i++)
			c[i] = scan.nextInt();
		int ans = backtrack(0, 0);
		System.out.println(ans == (int) 1e9 ? -1 : ans);
		scan.close();
	}

	public static int backtrack(int n, int gcd) {
		if (gcd == 1)
			return 0;
		if (n == N)
			return (int) 1e9;
		Point s = new Point(n, gcd);
		if (dp.containsKey(s))
			return dp.get(s);
		dp.put(new Point(n, gcd), Math.min(backtrack(n + 1, gcd), backtrack(n + 1, gcd(gcd, l[n])) + c[n]));
		return Math.min(backtrack(n + 1, gcd), backtrack(n + 1, gcd(gcd, l[n])) + c[n]);
	}

	public static int gcd(int a, int b) {
		return b == 0 ? a : gcd(b, a % b);
	}
}

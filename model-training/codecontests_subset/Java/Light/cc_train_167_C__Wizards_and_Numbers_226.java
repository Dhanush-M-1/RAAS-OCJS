import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class ProblemC {
	

	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);

		int n = in.nextInt();
		for (int i = 0 ; i < n ; i++) {
			long a = in.nextLong();
			long b = in.nextLong();
			out.println(win(a, b) ? "First" : "Second");
		}
		
//		debug(win(2,11));
//		
//
//		

		memo = new int[1001];
		for (int i = 1 ; i <= 1000 ; i++) {
			//debug(i,subgame2(i, 4));
		}
		
		
		out.flush();
	}
	
	static int[] memo;
	
	private static boolean subgame2(int a, int b) {
		if (a == 0) {
			return true;
		}
		if (memo[a] != 0) {
			return (memo[a] == 1);
		}
		int d = 1;
		while (d * b <= a) {
			d *= b;
		}
		boolean canwin = false;
		while (d >= 1) {
			canwin |= !subgame2(a-d, b);
			d /= b;
		}
		memo[a] = canwin ? 1 : -1;
		return canwin;
	}
	
	
	private static boolean win(long a, long b) {
		if (a == 0 || b == 0) {
			return false;
		}
		if (a > b) {
			return win(b, a);
		}
		if (b % a == 0) {
			return true;
		}
		boolean canwin = !win(a, b%a);
		if (!canwin) {
			long sub = b / a;
			if (a % 2 == 0) {
				sub %= (a+1);
			}
			canwin |= (sub % 2 == 0);
		}
		return canwin;
	}

	public static void debug(Object... o) {
		System.err.println(Arrays.deepToString(o));
	}
}

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
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
		out.flush();
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
				canwin |= (sub % 2 == 0);
			} else {
				canwin |= (sub % 2 == 0);				
			}
		}
		return canwin;
	}

	public static void debug(Object... o) {
		System.err.println(Arrays.deepToString(o));
	}
}

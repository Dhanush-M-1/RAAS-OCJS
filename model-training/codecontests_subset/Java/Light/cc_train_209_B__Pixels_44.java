import java.util.*;
import java.io.*;
import static java.lang.Math.*;

public class B {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		long A = in.nextLong();
		long B = in.nextLong();
		long C = in.nextLong();

		long ans = A+B+C-1;
		ans = min(ans, solve(A, B, C));
		ans = min(ans, solve(A, C, B));
		ans = min(ans, solve(B, A, C));
		ans = min(ans, solve(B, C, A));
		ans = min(ans, solve(C, A, B));
		ans = min(ans, solve(C, B, A));
		System.out.println(ans);
	}
	static long solve(long A, long B, long C) {
		if (A < B)
			return Long.MAX_VALUE;
		if ((A-B)%2 != 0)
			return Long.MAX_VALUE;
		return A;
	}
}

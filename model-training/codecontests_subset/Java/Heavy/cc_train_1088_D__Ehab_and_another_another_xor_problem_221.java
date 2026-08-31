import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.math.BigInteger;
import java.util.Scanner;

public class Solution {

	private static Scanner in;
	private static PrintStream out;

	public static void main(String[] args) {
		in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		out = System.out;
		solve();
		in.close();
	}

	protected static void solve() {
		BigInteger[] sol = { BigInteger.ZERO, BigInteger.ZERO };
		int sign = ask(BigInteger.ZERO, BigInteger.ZERO);
		for (int i = 29; i >= 0; i--) {
			int ans1 = ask(sol[0].setBit(i), sol[1]);
			int ans2 = ask(sol[0], sol[1].setBit(i));
			if (sign == 0) {
				if (ans1 < 0) {
					sol[0] = sol[0].setBit(i);
					sol[1] = sol[1].setBit(i);
				}
				continue;
			}
			if (sign > 0) {
				if (ans1 == 0) {
					sign = ans1;
					sol[0] = sol[0].setBit(i);
					continue;
				}
				if (ans1 < 0) {
					if (ans2 < 0) {
						sign = ans2;
					} else {
						sol[1] = sol[1].setBit(i);
					}
					sol[0] = sol[0].setBit(i);
				} else {
					if (ans2 > 0) sol[0] = sol[0].setBit(i);
				}
			} else {
				if (ans2 == 0) {
					sign = ans2;
					sol[1] = sol[1].setBit(i);
					continue;
				}
				if (ans2 > 0) {
					if (ans1 > 0) {
						sign = ans1;
					} else {
						sol[0] = sol[0].setBit(i);
					}
					sol[1] = sol[1].setBit(i);
				} else {
					if (ans1 < 0) sol[1] = sol[1].setBit(i);
				}
			}
		}
		out.println("! " + sol[0] + " " + sol[1]);
	}

	protected static int ask(BigInteger c, BigInteger d) {
		out.println("? " + c + " " + d);
		System.out.flush();
		return in.nextInt();
		// BigInteger a = new BigInteger("113");
		// BigInteger b = new BigInteger("1073741823");
		// BigInteger val1 = a.xor(c);
		// BigInteger val2 = b.xor(d);
		// return val1.compareTo(val2);
	}
}

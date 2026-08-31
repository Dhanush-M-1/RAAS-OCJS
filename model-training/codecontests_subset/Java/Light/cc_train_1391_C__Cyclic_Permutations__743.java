import java.util.Scanner;

public class cf1391_Div2_C {
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int MOD = (int)1e9 + 7;
		
		// n! - 2^(n - 1)
		long nVal = 1;
		long twoVal = 1;
		for (int i = 1; i <= n - 1; i++) {
			twoVal = (twoVal * 2) % MOD;
			nVal = (nVal * i) % MOD;
		}
		// System.out.println(nVal + " " + twoVal);
		nVal *= n;
		nVal %= MOD;
		nVal -= twoVal;
		nVal %= MOD;
		if (nVal < 0) nVal += MOD;
		System.out.println(nVal);
	}
}

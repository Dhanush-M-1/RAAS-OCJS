import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int n = in.nextInt();
		int m = in.nextInt();
		boolean[] a = new boolean[n];
		for (int i = 0; i < m; i++) {
			int t = in.nextInt();
			a[t - 1] = true;
		}
		System.out.println(solve(a));
		in.close();
	}

	private static int solve(boolean[] a) {
		int[] r = new int[a.length];
		if (a[0])
			r[0] = 0;
		else
			r[0] = 1;
		if (a.length > 1)
			if (a[1])
				r[1] = 0;
			else
				r[1] = 1 + r[0];
		for (int i = 2; i < a.length; i++) {
			if (a[i])
				r[i] = 0;
			else
				r[i] = r[i - 2] + r[i - 1];
			r[i] %= 1000000007;
		}
		return r[a.length - 1];
	}
}
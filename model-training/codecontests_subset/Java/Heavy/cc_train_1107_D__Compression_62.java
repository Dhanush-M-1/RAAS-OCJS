import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class E {

	// 14:06-(14:27)-
	public static void main(String[] args) throws IOException {
		try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		     PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)))) {
			Scanner sc = new Scanner(reader);

			int n = sc.nextInt();
			boolean[][] d = new boolean[n][n];

			for (int i = 0; i < n; i++) {
				String str = sc.next();
				for (int j = 0; j < str.length(); j++) {
					char c = str.charAt(j);
					int val;
					if ('0' <= c && c <= '9') {
						val = c - '0';
					} else {
						val = (c - 'A') + 10;
					}

					for (int k = 3; k >= 0; k--) {
						d[i][j * 4 + (3 - k)] = ((val >>> k) & 1) == 1;
					}
				}
			}


			Set<Integer> nums = new HashSet<>();

			int cnt = 1;
			outer:
			for (int i = 0; i < n - 1; i++) {
				for (int j = 0; j < n; j++) {
					if (d[i][j] != d[i + 1][j]) {
						nums.add(cnt);
						cnt = 1;
						continue outer;
					}
				}
				cnt++;
			}
			nums.add(cnt);

			cnt = 1;
			outer:
			for (int i = 0; i < n - 1; i++) {
				for (int j = 0; j < n; j++) {
					if (d[j][i] != d[j][i + 1]) {
						nums.add(cnt);
						cnt = 1;
						continue outer;
					}
				}
				cnt++;
			}
			nums.add(cnt);

			Integer[] vals = nums.toArray(new Integer[nums.size()]);
			if (vals.length == 1) {
				out.println(vals[0]);
			} else {
				int gcd = gcd(vals[0], vals[1]);
				for (int i = 2; i < vals.length; i++) {
					gcd = gcd(gcd, vals[i]);
				}
				out.println(gcd);
			}
		}
	}

	private static int gcd(int a, int b) {
		while (b > 0) {
			int t = a % b;
			a = b;
			b = t;
		}
		return a;
	}

}

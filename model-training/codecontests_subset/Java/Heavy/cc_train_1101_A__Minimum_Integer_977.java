import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * <a href="http://codeforces.com/contest/1101/problem/A">1101A</a>
 */
public class _1101A {
	public static void main(String[] args) throws Exception {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.valueOf(reader.readLine());
		for (int i = 0; i < n; i++) {
			int[] a = convert(reader.readLine());
			int l = a[0];
			int r = a[1];
			int d = a[2];
			if (d < l || d > r) {
				System.out.println(d);
				continue;
			}
			System.out.println(d * (r / d + 1));
		}

	}

	private static int[] convert(String s) {
		return Arrays.stream(s.split(" ")).mapToInt(Integer::valueOf).toArray();
	}
}
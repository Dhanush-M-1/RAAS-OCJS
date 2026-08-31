import java.io.*;

public class CF1107D {
	static int gcd(int a, int b) {
		return b == 0 ? a : gcd(b, a % b);
	}
	static int solve(int[][] aa, int n) {
		int d = 0;
		for (int i = 1, k = 1; i <= n; i++) {
			boolean cut = false;
			if (i == n)
				cut = true;
			else
				for (int j = 0; j < n; j++)
					if (aa[i][j] != aa[i - 1][j]) {
						cut = true;
						break;
					}
			if (cut) {
				d = gcd(d, k);
				k = 1;
			} else
				k++;
		}
		return d;
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[][] aa = new int[n][n];
		for (int i = 0; i < n; i++) {
			char[] cc = br.readLine().toCharArray();
			for (int j = 0; j < n / 4; j++) {
				char c = cc[j];
				int a = c >= 'A' ? c - 'A' + 10 : c - '0';
				for (int h = 0; h < 4; h++)
					aa[i][j * 4 + h] = (a >> 3 - h) & 1;
			}
		}
		int d1 = solve(aa, n);
		for (int i = 0; i < n; i++)
			for (int j = i + 1; j < n; j++) {
				int tmp = aa[i][j]; aa[i][j] = aa[j][i]; aa[j][i] = tmp;
			}
		int d2 = solve(aa, n);
		System.out.println(gcd(d1, d2));
	}
}

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[][] f = new int[n][10];
		for (int i = 0; i < n; i++) {
			String[] sa = br.readLine().split(" ");
			for (int j = 0; j < 10; j++) {
				f[i][j] = Integer.parseInt(sa[j]);
			}
		}
		int[][] p = new int[n][11];
		for (int i = 0; i < n; i++) {
			String[] sa = br.readLine().split(" ");
			for (int j = 0; j < 11; j++) {
				p[i][j] = Integer.parseInt(sa[j]);
			}
		}
		br.close();

		long ans = Long.MIN_VALUE;
		int end = 1 << 10;
		for (int i = 1; i < end; i++) {
			long val = 0;
			for (int k = 0; k < n; k++) {
				int cnt = 0;
				for (int j = 0; j < 10; j++) {
					if (f[k][j] == 1 && (i >> j & 1) == 1) {
						cnt++;
					}
				}
				val += p[k][cnt];
			}
			ans = Math.max(ans, val);
		}
		System.out.println(ans);
	}
}

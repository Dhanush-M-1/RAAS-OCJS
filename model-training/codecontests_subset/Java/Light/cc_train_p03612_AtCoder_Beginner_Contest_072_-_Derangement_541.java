import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] p = new int[n + 1];
		String[] sa = br.readLine().split(" ");
		for (int i = 0; i < n; i++) {
			p[i] = Integer.parseInt(sa[i]) - 1;
		}
		br.close();
		p[n] = Integer.MAX_VALUE;

		int ans = 0;
		int cnt = 0;
		for (int i = 0; i <= n; i++) {
			if (p[i] == i) {
				cnt++;
			} else {
				ans += (cnt + 1) / 2;
				cnt = 0;
			}
		}
		System.out.println(ans);
	}
}

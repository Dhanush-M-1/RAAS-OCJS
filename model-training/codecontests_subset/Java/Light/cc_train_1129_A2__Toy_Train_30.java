import java.io.*;
import java.util.*;

public class CF1129A2 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int[] tt = new int[n];
		int[] kk = new int[n];
		int k = 0;
		while (m-- > 0) {
			st = new StringTokenizer(br.readLine());
			int i = Integer.parseInt(st.nextToken()) - 1;
			int j = Integer.parseInt(st.nextToken()) - 1;
			int t = j - i;
			if (t < 0)
				t += n;
			tt[i] = kk[i] == 0 ? t : Math.min(tt[i], t);
			k = Math.max(k, ++kk[i]);
		}
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < n; i++) {
			int t_ = 0;
			for (int j = 0; j < n; j++)
				if (kk[j] == k) {
					int t = j - i;
					if (t < 0)
						t += n;
					t += tt[j];
					t_ = Math.max(t_, t);
				} else if (k > 1 && kk[j] == k - 1) {
					int t = j - i;
					if (t < 0)
						t += n;
					t -= n;
					t += tt[j];
					t_ = Math.max(t_, t);
				}
			t_ += (k - 1) * n;
			sb.append(t_ + " ");
		}
		System.out.println(sb);
	}
}

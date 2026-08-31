// upsolve with rainboy
import java.io.*;
import java.util.*;

public class CF990E {
	static final long INF = (long) 2e12;
	static int[] aa, pp, qq;
	static int count(int n, int p) {
		int cnt = 0;
		for (int i = 0; i < n; )
			if (aa[i] == 0) {
				cnt++;
				i += p;
			} else {
				if (pp[i] + qq[i] - 1 >= p)
					return -1;
				i -= pp[i];
			}
		return cnt;
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		aa = new int[n];
		pp = new int[n];
		qq = new int[n];
		st = new StringTokenizer(br.readLine());
		while (m-- > 0) {
			int i = Integer.parseInt(st.nextToken());
			aa[i] = pp[i] = qq[i] = 1;
		}
		if (aa[0] == 1) {
			System.out.println(-1);
			return;
		}
		for (int i = 1; i < n; i++)
			if (pp[i] != 0)
				pp[i] += pp[i - 1];
		for (int i = n - 2; i >= 0; i--)
			if (qq[i] != 0)
				qq[i] += qq[i + 1];
		st = new StringTokenizer(br.readLine());
		long min = INF;
		for (int p = 1; p <= k; p++) {
			int a = Integer.parseInt(st.nextToken());
			int cnt = count(n, p);
			if (cnt >= 0)
				min = Math.min(min, (long) a * cnt);
		}
		System.out.println(min == INF ? -1 : min);
	}
}

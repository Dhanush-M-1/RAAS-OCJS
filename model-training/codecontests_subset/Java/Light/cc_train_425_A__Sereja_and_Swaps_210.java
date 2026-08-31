import java.io.*;
import java.util.*;

public class CF426C {
	static int[] aa, bb;
	static int n, k;
	static int count(int i, int j) {
		for (int h = i; h < n; h++)
			bb[h - i] = aa[h];
		for (int h = 0; h < i; h++)
			bb[n - i + h] = aa[h];
		int m = j - i;
		Arrays.sort(bb, 0, m);
		Arrays.sort(bb, m, n);
		int sum = 0;
		for (int h = 0; h < m; h++)
			sum += bb[h];
		for (int s = 0; s < k; s++) {
			int p = s;
			int q = n - 1 - s;
			if (p >= m || q < m || bb[p] >= bb[q])
				break;
			sum += bb[q] - bb[p];
		}
		return sum;
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		aa = new int[n];
		bb = new int[n];
		for (int i = 0; i < n; i++)
			aa[i] = Integer.parseInt(st.nextToken());
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < n; i++)
			for (int j = i + 1; j <= n; j++) {
				int cnt = count(i, j);
				max = Math.max(max, cnt);
			}
		System.out.println(max);
	}
}

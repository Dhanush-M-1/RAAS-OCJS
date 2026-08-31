import java.io.*;
import java.util.*;

public class CF830A {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int p = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		Random rand = new Random();
		int[] aa = new int[n];
		for (int i = 0; i < n; i++)
			aa[i] = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		int[] bb = new int[k];
		for (int j = 0; j < k; j++)
			bb[j] = Integer.parseInt(st.nextToken());
		for (int i = n - 1; i > 0; i--) {
			int i_ = rand.nextInt(i + 1);
			int tmp = aa[i]; aa[i] = aa[i_]; aa[i_] = tmp;
		}
		Arrays.sort(aa);
		for (int j = k - 1; j > 0; j--) {
			int j_ = rand.nextInt(j + 1);
			int tmp = bb[j]; bb[j] = bb[j_]; bb[j_] = tmp;
		}
		Arrays.sort(bb);
		int min = Integer.MAX_VALUE;
		for (int h = 0; h + n <= k; h++) {
			int max = 0;
			for (int i = 0; i < n; i++) {
				int a = aa[i];
				int b = bb[h + i];
				int t = Math.abs(a - b) + Math.abs(b - p);
				max = Math.max(max, t);
			}
			min = Math.min(min, max);
		}
		System.out.println(min);
	}
}

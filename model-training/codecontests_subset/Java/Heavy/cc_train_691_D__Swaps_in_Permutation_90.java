import java.io.*;
import java.util.*;

public class CF691D {
	static int find(int parent[], int i) {
		if (parent[i] != i)
			parent[i] = find(parent, parent[i]);
		return parent[i];
	}
	static void join(int parent[], int[] rank, int i, int j) {
		i = find(parent, i);
		j = find(parent, j);
		if (i == j)
			return;
		if (rank[i] < rank[j])
			parent[i] = j;
		else if (rank[i] > rank[j])
			parent[j] = i;
		else {
			rank[i]++;
			parent[j] = i;
		}
	}
	static class Pair {
		int r, i;
		Pair(int r, int i) {
			this.r = r;
			this.i = i;
		}
	}
	static void sort(int[] pp, int[] qq, Pair[] aa, int l, int k) {
		for (int i = 0; i < k; i++) {
			int j = aa[l + i].i;
			qq[i] = pp[j];
		}
		Arrays.sort(qq, 0, k);
		for (int i = 0; i < k; i++) {
			int j = aa[l + i].i;
			pp[j] = qq[k - 1 - i];
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		int[] pp = new int[n];
		int[] qq = new int[n];
		for (int i = 0; i < n; i++)
			pp[i] = Integer.parseInt(st.nextToken());
		int[] parent = new int[n];
		for (int i = 0; i < n; i++)
			parent[i] = i;
		int[] rank = new int[n];
		while (m-- > 0) {
			st = new StringTokenizer(br.readLine());
			int i = Integer.parseInt(st.nextToken()) - 1;
			int j = Integer.parseInt(st.nextToken()) - 1;
			join(parent, rank, i, j);
		}
		Pair[] aa = new Pair[n];
		for (int i = 0; i < n; i++) {
			int r = find(parent, i);
			aa[i] = new Pair(r, i);
		}
		Arrays.sort(aa, (p, q) -> p.r != q.r ? p.r - q.r : p.i - q.i);
		int l = 0, k = 1;
		for (int i = 1; i <= n; i++)
			if (i < n && aa[i].r == aa[i - 1].r)
				k++;
			else {
				if (k > 1)
					sort(pp, qq, aa, l, k);
				l = i;
				k = 1;
			}
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < n; i++)
			sb.append(pp[i] + " ");
		System.out.println(sb);
	}
}

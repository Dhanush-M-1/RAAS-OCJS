import java.io.*;
import java.util.*;

//public class Solution {
public class G {

	static long m = (long) (1e9 + 7);

	public static void main(String[] args) throws IOException {
		Scanner scn = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);
		StringBuilder sb = new StringBuilder();
		int T = scn.ni(), tcs = 0;
		G: while (tcs++ < T) {
//			sb.append("Case #" + tcs + ": ");
			int n = scn.ni();
			int m = scn.ni();
			TreeMap<Long, Integer> hm = new TreeMap<>();
			long s = 0;
			for (int i = 0; i < n; i++) {
				s += scn.nl();
				if (hm.isEmpty() || s > hm.lastKey())
					hm.put(s, i);
			}
			while (m-- > 0) {
				long x = scn.nl();
				if (s <= 0 && hm.lastKey() < x)
					sb.append(-1 + " ");
				else {
					if (x <= hm.lastKey())
						sb.append(hm.ceilingEntry(x).getValue() + " ");
					else {
						long nc = (x - hm.lastKey() + s - 1) / s;
						sb.append(nc * n + hm.ceilingEntry(x - nc * s).getValue() + " ");
					}
				}
			}
			sb.append("\n");
		}
		out.print(sb);
		out.close();
	}

	static class Scanner {

		StringTokenizer st;
		BufferedReader br;

		public Scanner(InputStream s) {
			br = new BufferedReader(new InputStreamReader(s));
		}

		public String next() throws IOException {
			while (st == null || !st.hasMoreTokens())
				st = new StringTokenizer(br.readLine());
			return st.nextToken();
		}

		public int ni() throws IOException {
			return Integer.parseInt(next());
		}

		public long nl() throws IOException {
			return Long.parseLong(next());
		}

		public int[] nia(int n) throws IOException {
			int a[] = new int[n];
			String sa[] = br.readLine().split(" ");
			for (int i = 0; i < n; i++)
				a[i] = Integer.parseInt(sa[i]);
			return a;
		}

		public long[] nla(int n) throws IOException {
			long a[] = new long[n];
			String sa[] = br.readLine().split(" ");
			for (int i = 0; i < n; i++)
				a[i] = Long.parseLong(sa[i]);
			return a;
		}

		public int[] sort(int[] a) {
			ArrayList<Integer> l = new ArrayList<>();
			for (int v : a)
				l.add(v);
			Collections.sort(l);
			for (int i = 0; i < a.length; i++)
				a[i] = l.get(i);
			return a;
		}

		public long[] sort(long[] a) {
			ArrayList<Long> l = new ArrayList<>();
			for (long v : a)
				l.add(v);
			Collections.sort(l);
			for (int i = 0; i < a.length; i++)
				a[i] = l.get(i);
			return a;
		}
	}
}
import java.io.*;
import java.util.*;
import java.util.*;
import java.math.*;
public class Euler {

	public static void main(String[] args) {

		FastReader in = new FastReader();
		PrintWriter o = new PrintWriter(System.out);

		int n = in.nextInt();
		int k = in.nextInt();

		List<Long> list11 = new ArrayList<>();
		List<Long> list22 = new ArrayList<>();
		List<Long> list33 = new ArrayList<>();

		for (int i = 0; i < n; i++) {
			long t = in.nextInt();
			int a = in.nextInt();
			int b = in.nextInt();
			if (a == 1 && b == 1) {
				list11.add(t);
			} else if (a == 1 && b == 0) {
				list22.add(t);
			} else if (a == 0 && b == 1) {
				list33.add(t);
			} else {
			}
		}
		Collections.sort(list11);
		Collections.sort(list22);
		Collections.sort(list33);

		List<Long> list1 = new ArrayList<>();
		List<Long> list2 = new ArrayList<>();
		List<Long> list3 = new ArrayList<>();

		if (list11.size() > 0) list1.add(list11.get(0));
		if (list22.size() > 0) list2.add(list22.get(0));
		if (list33.size() > 0) list3.add(list33.get(0));

		for (int i = 1; i < list11.size(); i++) {
			long val = list11.get(i) + list1.get(i-1);
			list1.add(val);
		}
		for (int i = 1; i < list22.size(); i++) {
			long val = list22.get(i) + list2.get(i - 1);
			list2.add(val);
		}
		for (int i = 1; i < list33.size(); i++) {
			long val = list33.get(i) + list3.get(i-1);
			list3.add(val);
		}

//		for (int i = 0; i < list3.size(); i++) {
//			o.print(list3.get(i) + " ");
//		}
//		o.println();
//		o.println(list1.size());
//		o.println(list2.size());
//		o.println(list3.size());

		long min = Integer.MAX_VALUE;
		for (int cnt = 0; cnt < Math.min(k + 1,list1.size() + 1); cnt++) {
			//o.println(cnt);
			int size1 = list2.size();
			int size2 = list3.size();
			if (size1 >= k - cnt && size2 >= k - cnt) {
				long sum = (cnt - 1 >= 0 ? list1.get(cnt - 1) : 0) + ((k - cnt - 1) >= 0 ? list2.get(k - cnt - 1) : 0) + ((k - cnt - 1) >= 0 ? list3.get(k - cnt - 1) : 0);
				min = Math.min(min, sum);
			}
		}

		o.println(min == Integer.MAX_VALUE ? "-1" : min);

		o.close();
		return;
	}


	static class FastReader {
		BufferedReader br;
		StringTokenizer st;

		public FastReader() {
			br = new BufferedReader(new InputStreamReader(System.in));
		}

		String next() {
			while (st == null || !st.hasMoreElements()) {
				try {
					st = new StringTokenizer(br.readLine());
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			return st.nextToken();
		}

		int nextInt() {
			return Integer.parseInt(next());
		}

		long nextLong() {
			return Long.parseLong(next());
		}

		double nextDouble() {
			return Double.parseDouble(next());
		}

		int[] readArray(int n) {
			int[] a = new int[n];
			for (int i = 0; i < n; i++) a[i] = nextInt();
			return a;
		}

		long[] readLongArray(int n) {
			long[] a = new long[n];
			for (int i = 0; i < n; i++) a[i] = nextLong();
			return a;
		}

		String nextLine() {
			String str = "";
			try {
				str = br.readLine();
			} catch (IOException e) {
				e.printStackTrace();
			}
			return str;
		}
	}

}
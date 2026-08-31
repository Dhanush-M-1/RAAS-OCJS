import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Q1 {
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		MScanner s = new MScanner(System.in);
		int t = s.nextInt();
		while (t-- > 0) {
			int n = s.nextInt();
			HashSet<Integer> set1 = new HashSet<Integer>();
			int m = s.nextInt();
			int[] ar1 = new int[n];
			for (int i = 0; i < n; i++) {
				ar1[i] = s.nextInt();
				set1.add(ar1[i]);
			}
			int[] ar2 = s.intArr(m);
			boolean check = false;
			int ans = 0;
			for (int i = 0; i < m; i++) {
				if (set1.contains(ar2[i])) {
					check = true;
					ans = ar2[i];
				}
			}
			if (check) {
				System.out.println("YES");
				System.out.println(1 + " " + ans);
			} else {
				System.out.println("NO");
			}
		}
	}

	static class MScanner {
		StringTokenizer st;
		BufferedReader br;

		public MScanner(InputStream system) {
			br = new BufferedReader(new InputStreamReader(system));
		}

		public MScanner(String file) throws Exception {
			br = new BufferedReader(new FileReader(file));
		}

		public String next() throws IOException {
			while (st == null || !st.hasMoreTokens())
				st = new StringTokenizer(br.readLine());
			return st.nextToken();
		}

		public int[] intArr(int n) throws IOException {
			int[] in = new int[n];
			for (int i = 0; i < n; i++)
				in[i] = nextInt();
			return in;
		}

		public long[] longArr(int n) throws IOException {
			long[] in = new long[n];
			for (int i = 0; i < n; i++)
				in[i] = nextLong();
			return in;
		}

		public int[] intSortedArr(int n) throws IOException {
			int[] in = new int[n];
			for (int i = 0; i < n; i++)
				in[i] = nextInt();
			shuffle(in);
			Arrays.sort(in);
			return in;
		}

		public long[] longSortedArr(int n) throws IOException {
			long[] in = new long[n];
			for (int i = 0; i < n; i++)
				in[i] = nextLong();
			shuffle(in);
			Arrays.sort(in);
			return in;
		}

		public Integer[] IntegerArr(int n) throws IOException {
			Integer[] in = new Integer[n];
			for (int i = 0; i < n; i++)
				in[i] = nextInt();
			return in;
		}

		public Long[] LongArr(int n) throws IOException {
			Long[] in = new Long[n];
			for (int i = 0; i < n; i++)
				in[i] = nextLong();
			return in;
		}

		public String nextLine() throws IOException {
			return br.readLine();
		}

		public int nextInt() throws IOException {
			return Integer.parseInt(next());
		}

		public double nextDouble() throws IOException {
			return Double.parseDouble(next());
		}

		public char nextChar() throws IOException {
			return next().charAt(0);
		}

		public long nextLong() throws IOException {
			return Long.parseLong(next());
		}

		public boolean ready() throws IOException {
			return br.ready();
		}

		public void waitForInput() throws InterruptedException {
			Thread.sleep(3000);
		}
	}

	static void shuffle(int[] in) {
		for (int i = 0; i < in.length; i++) {
			int idx = (int) (Math.random() * in.length);
			int tmp = in[i];
			in[i] = in[idx];
			in[idx] = tmp;
		}
	}

	static void shuffle(long[] in) {
		for (int i = 0; i < in.length; i++) {
			int idx = (int) (Math.random() * in.length);
			long tmp = in[i];
			in[i] = in[idx];
			in[idx] = tmp;
		}
	}
}

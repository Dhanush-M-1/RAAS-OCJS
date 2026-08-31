import java.util.*;
import java.io.*;


public class B_1421 {
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		PrintWriter pw = new PrintWriter(System.out);
		
		int t = sc.nextInt();
		while(t-->0) {
			int n = sc.nextInt();
			char[][] grid = new char[n][n];
			for(int i = 0; i < n; i++)
				grid[i] = sc.next().toCharArray();
			ArrayList<String> ans = new ArrayList<>();
			if(grid[0][1] == '0' && grid[1][0] == '0') {
				if(grid[n - 2][n - 1] == '0')
					ans.add((n - 1) + " " + (n));
				if(grid[n - 1][n - 2] == '0')
					ans.add((n) + " " + (n - 1));
			} else if(grid[0][1] == '1' && grid[1][0] == '1') {
				if(grid[n - 2][n - 1] == '1')
					ans.add((n - 1) + " " + (n));
				if(grid[n - 1][n - 2] == '1')
					ans.add((n) + " " + (n - 1));
			} else if(grid[n - 1][n - 2] == '0' && grid[n - 2][n - 1] == '0') {
				if(grid[0][1] == '0')
					ans.add((1) + " " + (2));
				if(grid[1][0] == '0')
					ans.add((2) + " " + (1));
			} else if(grid[n - 1][n - 2] == '1' && grid[n - 2][n - 1] == '1') {
				if(grid[0][1] == '1')
					ans.add((1) + " " + (2));
				if(grid[1][0] == '1')
					ans.add((2) + " " + (1));
			} else {
				if(grid[0][1] == '0')
					ans.add((1) + " " + (2));
				if(grid[1][0] == '0')
					ans.add((2) + " " + (1));
				if(grid[n - 2][n - 1] == '1')
					ans.add((n - 1) + " " + (n));
				if(grid[n - 1][n - 2] == '1')
					ans.add((n) + " " + (n - 1));
			}
			
			pw.println(ans.size());
			for(String s : ans)
				pw.println(s);
		}
		
		pw.flush();
	}

	public static class Scanner {
		StringTokenizer st;
		BufferedReader br;

		public Scanner(InputStream system) {
			br = new BufferedReader(new InputStreamReader(system));
		}

		public Scanner(String file) throws Exception {
			br = new BufferedReader(new FileReader(file));
		}

		public String next() throws IOException {
			while (st == null || !st.hasMoreTokens())
				st = new StringTokenizer(br.readLine());
			return st.nextToken();
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

		public int[] nextIntArray(int n) throws IOException {
			int[] array = new int[n];
			for (int i = 0; i < n; i++)
				array[i] = nextInt();
			return array;
		}

		public Integer[] nextIntegerArray(int n) throws IOException {
			Integer[] array = new Integer[n];
			for (int i = 0; i < n; i++)
				array[i] = new Integer(nextInt());
			return array;
		}

		public long[] nextLongArray(int n) throws IOException {
			long[] array = new long[n];
			for (int i = 0; i < n; i++)
				array[i] = nextLong();
			return array;
		}

		public double[] nextDoubleArray(int n) throws IOException {
			double[] array = new double[n];
			for (int i = 0; i < n; i++)
				array[i] = nextDouble();
			return array;
		}

		public static int[] shuffle(int[] a) {
			int n = a.length;
			Random rand = new Random();
			for (int i = 0; i < n; i++) {
				int tmpIdx = rand.nextInt(n);
				int tmp = a[i];
				a[i] = a[tmpIdx];
				a[tmpIdx] = tmp;
			}
			return a;
		}

		public boolean ready() throws IOException {
			return br.ready();
		}

		public void waitForInput() throws InterruptedException {
			Thread.sleep(3000);
		}
	}
}

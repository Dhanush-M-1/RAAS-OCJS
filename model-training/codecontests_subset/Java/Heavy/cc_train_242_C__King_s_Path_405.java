import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;
import java.util.StringTokenizer;
import java.util.TreeMap;

import javax.swing.text.Keymap;

public class KingPath {

	static TreeMap<pair, Integer> tm;

	static int [] r = {-1,-1,-1,0,1,1,1,0};
	static int [] c = {-1,0,1,-1,-1,0,1,1};
	static class pair implements Comparable {
		int i;
		int j;

		public pair(int ii, int jj) {
			i = ii;
			j = jj;
		}

		@Override
		public int compareTo(Object o) {
			pair p = (pair) o;
			if (i < p.i || (i == p.i && j < p.j))
				return -1;
			else if (i > p.i || (i == p.i && j > p.j))
				return 1;
			else
				return 0;

		}

		@Override
		public boolean equals(Object o) {
			if (i == ((pair) o).i && j == ((pair) o).j)
				return true;
			else
				return false;

		}

	}

	public static void bfs(int i, int j) {
		tm.replace(new pair(i,j), 0);
		Queue<pair>q = new LinkedList<>();
		q.add(new pair(i,j));
		while(!q.isEmpty()){
			pair v = q.poll();
			for(int k = 0; k<8; k++){
				int newI = v.i+r[k];
				int newJ = v.j+c[k];
				if(newI<0||newJ<0||newI>=(int)1e9||newJ>=(int)1e9)
					continue;
				pair u = new pair(newI, newJ);
				if(tm.get(u)!=null&&tm.get(u)==(int)1e9){
					tm.replace(u, tm.get(v)+1);
					q.add(u);
				}
			}
		}
		

	}

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		int x0 = sc.nextInt();
		int y0 = sc.nextInt();
		int x1 = sc.nextInt();
		int y1 = sc.nextInt();
		int n = sc.nextInt();
		tm = new TreeMap<>();
		for (int i = 0; i < n; i++) {
			int r = sc.nextInt();
			int a = sc.nextInt();
			int b = sc.nextInt();
			for (int j = a; j <= b; j++)
				tm.put(new pair(r, j), (int) 1e9);
		}
		bfs(x0,y0);
		if(tm.get(new pair(x1,y1))!=(int)1e9)
			System.out.println(tm.get(new pair(x1,y1)));
		else
			System.out.println(-1);

	}

	static class Scanner {
		StringTokenizer st;
		BufferedReader br;

		public Scanner(InputStream s) {
			br = new BufferedReader(new InputStreamReader(s));
		}

		public Scanner(String f) throws FileNotFoundException {
			br = new BufferedReader(new FileReader(f));
		}

		public String next() throws IOException {
			while (st == null || !st.hasMoreTokens())
				st = new StringTokenizer(br.readLine());
			return st.nextToken();
		}

		public int nextInt() throws IOException {
			return Integer.parseInt(next());
		}

		public long nextLong() throws IOException {
			return Long.parseLong(next());
		}

		public String nextLine() throws IOException {
			return br.readLine();
		}

		public double nextDouble() throws IOException {
			return Double.parseDouble(next());
		}

		public boolean ready() throws IOException {
			return br.ready();
		}

		public int[] nextIntArray(int n) throws IOException {
			int[] a = new int[n];
			for (int i = 0; i < n; i++)
				a[i] = nextInt();
			return a;
		}

		public int[] nextIntArray1(int n) throws IOException {
			int[] a = new int[n + 1];
			for (int i = 1; i <= n; i++)
				a[i] = nextInt();
			return a;
		}

		public int[] shuffle(int[] a, int n) {
			int[] b = new int[n];
			for (int i = 0; i < n; i++)
				b[i] = a[i];
			Random r = new Random();
			for (int i = 0; i < n; i++) {
				int j = i + r.nextInt(n - i);
				int t = b[i];
				b[i] = b[j];
				b[j] = t;
			}
			return b;
		}

		public int[] nextIntArraySorted(int n) throws IOException {
			int[] a = nextIntArray(n);
			a = shuffle(a, n);
			Arrays.sort(a);
			return a;
		}

		public long[] nextLongArray(int n) throws IOException {
			long[] a = new long[n];
			for (int i = 0; i < n; i++)
				a[i] = nextLong();
			return a;
		}

		public long[] nextLongArray1(int n) throws IOException {
			long[] a = new long[n + 1];
			for (int i = 1; i <= n; i++)
				a[i] = nextLong();
			return a;
		}

		public long[] nextLongArraySorted(int n) throws IOException {
			long[] a = nextLongArray(n);
			Random r = new Random();
			for (int i = 0; i < n; i++) {
				int j = i + r.nextInt(n - i);
				long t = a[i];
				a[i] = a[j];
				a[j] = t;
			}
			Arrays.sort(a);
			return a;
		}
	}
}

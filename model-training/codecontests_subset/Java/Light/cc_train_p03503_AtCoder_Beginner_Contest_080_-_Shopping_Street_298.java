import java.util.*;
import java.io.*;

public class Main {
	static int mod = (int) 1e9 + 7;
	static int DX[] = { -1, 0, 1, 0 }, DY[] = { 0, -1, 0, 1 };

	public static void main(String[] args) {
		FastScanner fs = new FastScanner(System.in);
		int n = fs.nextInt();
		int f[][] = new int[n][10];
		int p[][] = new int[n][11];
		
		for(int i=0;i<n;i++) {
			for(int j=0;j<10;j++) {
				f[i][j] = fs.nextInt();
			}
		}
		for(int i=0;i<n;i++) {
			for(int j=0;j<11;j++) {
				p[i][j] = fs.nextInt();
			}
		}
		long res = -Long.MAX_VALUE/2;
		for(int i=1;i<(1<<10);i++) {
			long ans = 0;
			int cnt[] = new int[n];
			for(int j=0;j<10;j++) {
				if((i>>j&1)==1) {
					for(int k=0;k<n;k++) {
						if(f[k][j]==1) {
							cnt[k]++;
						}
					}
				}
			}
			int max = -Integer.MAX_VALUE/2;
			boolean ok = false;
			for(int j=0;j<n;j++) {
				int now = p[j][cnt[j]];
				ans+=now;
			}
			res = Math.max(res, ans);
		}
		System.out.println(res);
	}
}

class UnionFind{
	int parent[];
	UnionFind(int N){
		parent = new int[N];
		Arrays.fill(parent, -1);
	}
	
	boolean same(int x, int y){
		return root(x)==root(y);
	}
	int root(int x) {
		if(parent[x]<0)return x;
		return parent[x] = root(parent[x]);
	}
	int size(int x) {
		return -parent[root(x)];
	}
	void unite(int x, int y) {
		if(size(x)<size(y)) {
			int tmp = x;
			x = y;
			y = tmp;
		}
		int rx = root(x);
		int ry = root(y);
		if(rx==ry)return;
		parent[rx] += parent[ry];
		parent[ry] = rx;
	}
}

//高速なScanner
class FastScanner {
	private BufferedReader reader = null;
	private StringTokenizer tokenizer = null;

	public FastScanner(InputStream in) {
		reader = new BufferedReader(new InputStreamReader(in));
		tokenizer = null;
	}

	public String next() {
		if (tokenizer == null || !tokenizer.hasMoreTokens()) {
			try {
				tokenizer = new StringTokenizer(reader.readLine());
			} catch (IOException e) {
				throw new RuntimeException(e);
			}
		}
		return tokenizer.nextToken();
	}

	public String nextLine() {
		if (tokenizer == null || !tokenizer.hasMoreTokens()) {
			try {
				return reader.readLine();
			} catch (IOException e) {
				throw new RuntimeException(e);
			}
		}
		return tokenizer.nextToken("\n");
	}

	public long nextLong() {
		return Long.parseLong(next());
	}

	public int nextInt() {
		return Integer.parseInt(next());
	}

	public double nextDouble() {
		return Double.parseDouble(next());
	}

	public int[] nextIntArray(int n) {
		int[] a = new int[n];
		for (int i = 0; i < n; i++)
			a[i] = nextInt();
		return a;
	}

	public long[] nextLongArray(int n) {
		long[] a = new long[n];
		for (int i = 0; i < n; i++)
			a[i] = nextLong();
		return a;
	}
}
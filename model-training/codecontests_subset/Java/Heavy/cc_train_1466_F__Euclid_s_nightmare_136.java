import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Goodbye21F {
	public static void main(String[] args) throws Exception {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter writer = new PrintWriter(System.out);

		StringTokenizer info = new StringTokenizer(reader.readLine());
		int n = Integer.parseInt(info.nextToken()); // num vectors
		int m = Integer.parseInt(info.nextToken()); // num dimensions

		boolean[] include = new boolean[n];
		boolean[] marked = new boolean[m];
		DisjointSet dsu = new DisjointSet(m + 5);
		for (int i = 0; i < n; i++) {
			StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
			int k = Integer.parseInt(tokenizer.nextToken());
			if (k == 1) {
				int a = Integer.parseInt(tokenizer.nextToken()) - 1;
				int repA = dsu.find(a);
				if (marked[repA]) {
					// don't include
				} else {
					// include
					marked[repA] = true;
					include[i] = true;
				}
			} else {
				int a = Integer.parseInt(tokenizer.nextToken()) - 1;
				int b = Integer.parseInt(tokenizer.nextToken()) - 1;
				int repA = dsu.find(a);
				int repB = dsu.find(b);
				if (repA == repB) {
					if (marked[repA]) {
						// don't include
					} else {
						// include
						//marked[repA] = true;
						//include[i] = true;
					}
				} else {
					if (marked[repA] && marked[repB]) {
						// don't include
						dsu.union(a, b);
						int rep = dsu.find(a);
						marked[rep] = true;
					} else {
						boolean wasMarked = marked[repA] || marked[repB];
						// include
						dsu.union(a, b);
						include[i] = true;
						int rep = dsu.find(a);
						marked[rep] = wasMarked;
					}
				}
			}
		}
		List<Integer> out = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			if (include[i]) {
				out.add(i + 1);
			}
		}

		if (out.size() > m) {
			throw new IllegalStateException();
		}

		// 1st part
		// 2 ^ out.size() mod 1e9 + 7, out.size()
		long MOD = 1_000_000_007L;
		long a = BigInteger.valueOf(2).modPow(BigInteger.valueOf(out.size()), BigInteger.valueOf(MOD)).longValueExact();
		long c = temp(out.size(), 1000000000 + 7);
		if (a != c) {
			throw new IllegalStateException();
		}
		long b = out.size();
		writer.println(a + " " + b);
		// 2nd part
		for (int i = 0; i < out.size() - 1; i++) {
			writer.print(out.get(i));
			writer.print(' ');
		}
		writer.println(out.get(out.size() - 1));


		reader.close();
		writer.close();
	}
	public static long temp(long n, long mod) {
		long x = 1;
		for (int i = 0; i < n; i++) {
			x = (x * 2) % mod;
		}
		return x;
	}
	static class DisjointSet {
		private int[] rank;
		private int[] parent;
		public DisjointSet(int n) {
			this.parent = new int[n];
			this.rank = new int[n];
			for (int i = 0; i < n; i++) {
				parent[i] = i;
				rank[i] = 1;
			}
			// this is because parent[x] = x implies that x is the representative of that set
			// everybody starts out as separate
		}
		// returns true if successfully unioned a and b together
		// returns false if they're already unioned together
		public boolean union(int a, int b) {
			int repA = find(a);
			int repB = find(b);
			if (repA == repB) {
				return false;
			}
			if (rank[repA] < rank[repB]) {
				// we move repA tree to repB
				parent[repA] = repB;
			} else if (rank[repB] < rank[repA]){
				// we do the same thing but opposite
				parent[repB] = repA;
			} else {
				parent[repA] = repB;
				rank[repB]++;
			}
			return true;
		}
		// returns the representative of x
		public int find(int x) {
			// path compression
			if (x != parent[x]) {
				// if we're working with a non-representative
				parent[x] = find(parent[x]);
			}
			// at the end, because of path compression, the parent[x] IS the representative
			return parent[x];
		}
	}
}

import java.util.*;
import java.io.*;

//CHECK LIMITS U RARTED DUMBO - 10^8 too SLO for BF
//FIND PATTERN IF TOO SLOW FOR BRUTE FORCE
//CHECK ALL PARAMETERS
//MAKE SURE YOU FIGURE OUT WHICH YOU USE (int vs ll)
//WRITE SOL ON PAPER BFR IMPLEMENTING
public class D {

	static final boolean stdin = true;
	static final String filename = "";
	static FastScanner br;
	static PrintWriter pw;

	public static void main(String[] args) throws IOException {

		if (stdin) {
			br = new FastScanner();
			pw = new PrintWriter(new OutputStreamWriter(System.out));
		} else {
			br = new FastScanner(filename + ".in");
			pw = new PrintWriter(new FileWriter(filename + ".out"));
		}

		Solver solver = new Solver();
		solver.solve(br, pw);
	}

	static class Solver {
		static long mod = 998244353L;

		public void solve(FastScanner br, PrintWriter pw) throws IOException {
			
			//initialization of array storing each of the given numbers
			//initialization of array storing the counts of each size number
			int n = br.nextInt();
			long[] vals = new long[n];
			long[] cnts = new long[11];
			
			//storing all the numbers and their respective lengths
			for (int i = 0; i < n; i++) {
				long l = br.nextLong();
				vals[i] = l;
				int counter = 0;
				while (l != 0L) {
					l = l / 10;
					counter++;
				}
				cnts[counter]++;
			}
			
			//looping through each number (vals[i]) and size of each number in vals (j)
			long out = 0;
			for (int i = 0; i < n; i++) {
				for (int j = 1; j < 11; j++) {
					
					//skip if there are no numbers of size j
					if(cnts[j]==0)
						continue;
					
					//initialization
					int counter = 0;
					long l = vals[i];
					long a = 0; //stores number where 0 is not put in ones place
					long b = 0; //stores number where 0 is put in ones place
					long reeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeee = 1;
					
					//for every digit in the number up to j starting from ones place
					//put in 0s at appropriate places and keep the total
					while (l != 0L && counter < j) {
						a += ((l % 10) * (reeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeee) % mod) % mod;
						b += ((l % 10) * (reeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeee*10) % mod) % mod;
						l /= 10;
						reeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeee *= 100;
						reeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeee %= mod;
						counter++;
					}
					
					
					//after the rightmost j digits, keep the rest of the left digits the same
					a += (l * reeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeee) % mod;
					b += (l * reeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeee) % mod;
					
					//store these modified numbers * # of times they will be needed
					out += (a*cnts[j])%mod;
					out %= mod;
					out += (b*cnts[j])%mod;
					out %= mod;
				}
			}
			
			//output
			pw.println(out % mod);
			pw.close();
		}

		//fast exponent
		static long pow(long a, long b) {
			if (b == 0)
				return 1L;
			long val = pow(a, b / 2);
			if (b % 2 == 0)
				return val * val % mod;
			else
				return val * val % mod * a % mod;
		}

	}

	static class Point implements Comparable<Point> {
		int a;
		int b;

		Point(int a, int b) {
			this.a = a;
			this.b = b;
		}

		@Override
		public int compareTo(Point o) {
			return this.a - o.a;
		}

	}

	static class Dsu {
		int n;
		int[] parent;
		int[] rank;

		public Dsu(int n) {
			this.n = n;
			parent = new int[n];
			rank = new int[n];
		}

		public void createSet() {
			for (int i = 0; i < n; i++) {
				parent[i] = i;
				rank[i] = 0;
			}
		}

		public int findParent(int x) {
			if (parent[x] == x)
				return x;
			parent[x] = findParent(parent[x]);
			return parent[x];
		}

		public void mergeSet(int a, int b) {
			int pa = findParent(a);
			int pb = findParent(b);

			if (pa == pb)
				return;

			if (rank[pa] > rank[pb]) {
				parent[pb] = pa;
			} else if (rank[pa] < rank[pb]) {
				parent[pa] = pb;
			} else {
				parent[pb] = pa;
				rank[pa]++;
			}
		}
	}

	public static class FastScanner {
		BufferedReader br;
		StringTokenizer st;

		public FastScanner(String s) {
			try {
				br = new BufferedReader(new FileReader(s));
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
		}

		public FastScanner() {
			br = new BufferedReader(new InputStreamReader(System.in));
		}

		String nextToken() {
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
			return Integer.parseInt(nextToken());
		}

		long nextLong() {
			return Long.parseLong(nextToken());
		}

		double nextDouble() {
			return Double.parseDouble(nextToken());
		}

		ArrayList<Integer>[] nextGraph(int nodes, int edges) {
			ArrayList<Integer>[] adj = new ArrayList[nodes];
			for (int i = 0; i < nodes; i++) {
				adj[i] = new ArrayList<Integer>();
			}
			for (int i = 0; i < edges; i++) {
				int a = nextInt() - 1;
				int b = nextInt() - 1;
				adj[a].add(b);
				adj[b].add(a);
			}
			return adj;
		}
	}
}
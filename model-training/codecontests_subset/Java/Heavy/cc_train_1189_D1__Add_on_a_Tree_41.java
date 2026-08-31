import java.util.*;
import java.io.*;

public class Main {
	static final int MOD_PRIME = 1000000007;

	public static void main(String[] args) {
		InputStream inputStream = System.in;
		OutputStream outputStream = System.out;
		InputReader in = new InputReader(inputStream);
		PrintWriter out = new PrintWriter(outputStream);
		Task solver = new Task();

		int i = 0;
		int t = 1;
		// t = in.nextInt();
		for (; i < t; i++)
			solver.solve(i, in, out);

		out.close();
	}

	static class Task {
		public void solve(int testNumber, InputReader in, PrintWriter out) {
			int n = in.nextInt();
			HashMap<Integer , ArrayList<Integer>> adj = new HashMap<Integer, ArrayList<Integer>>();
			for(int i = 0; i < n - 1; i++) {
				int u = in.nextInt();
				int v = in.nextInt();
				if(!adj.containsKey(u)) adj.put(u, new ArrayList<Integer>());
				if(!adj.containsKey(v)) adj.put(v, new ArrayList<Integer>());
				adj.get(u).add(v);
				adj.get(v).add(u);
			}
			
			long leaf = 0;
			boolean twoflag = false;
			for(int k : adj.keySet()) {
				if(adj.get(k).size() == 1) leaf++;
				if(adj.get(k).size() == 2) twoflag = true;
			}
			
			if(n - 1 > (leaf*(leaf - 1))/2 || twoflag) {
				out.println("NO");
			}else {
				out.println("YES");
			}
		}
	}

// template code

	static class InputReader {
		public BufferedReader reader;
		public StringTokenizer tokenizer;

		public InputReader(InputStream stream) {
			reader = new BufferedReader(new InputStreamReader(stream), 32768);
			tokenizer = null;
		}

		public String next() {
			while (tokenizer == null || !tokenizer.hasMoreTokens()) {
				try {
					tokenizer = new StringTokenizer(reader.readLine());
				} catch (IOException e) {
					throw new RuntimeException(e);
				}
			}
			return tokenizer.nextToken();
		}

		public int nextInt() {
			return Integer.parseInt(next());
		}

		public long nextLong() {
			return Long.parseLong(next());
		}

		public double nextDouble() {
			return Double.parseDouble(next());
		}

	}

	static long modexp(long a, long b, long p) {
		// returns a to the power b mod p by modular exponentiation

		long res = 1;
		long mult = a % p;
		while (b > 0) {
			if (b % 2 == 1) {
				res = (res * mult) % p;
			}
			b /= 2;
			mult = (mult * mult) % p;
		}

		return res;
	}

	static double log(double arg, double base) {
		// returns log of a base b, contains floating point errors, dont use for exact
		// calculations.

		if (base < 0 || base == 1) {
			throw new ArithmeticException("base cant be 1 or negative");
		}
		if (arg < 0) {
			throw new ArithmeticException("log of negative number undefined");
		}
		return Math.log10(arg) / Math.log10(base);
	}

	static int gcd(int a, int b) {
		if (b == 0) {
			return a;
		}

		return gcd(b, a % b);

	}

	static long gcd(long a, long b) {
		if (b == 0) {
			return a;
		}

		return gcd(b, a % b);

	}

	// scope for improvement
	static ArrayList<Integer> sieveOfEratosthenes(int n) {
		boolean[] check = new boolean[n + 1];
		ArrayList<Integer> prime = new ArrayList<Integer>();
		for (long i = 2; i <= n; i++) {
			if (!check[(int) i]) {
				prime.add((int) i);
				for (long j = i * i; j <= n; j += i) {
					check[(int) j] = true;
				}
			}
		}

		return prime;
	}

	static int modInverse(int a, int n) {
		// returns inverse of a mod n by extended euclidean algorithm
		int t = 0;
		int newt = 1;
		int r = n;
		int newr = a;
		int quotient;
		int tempr, tempt;
		while (newr != 0) {
			quotient = r / newr;
			tempt = newt;
			tempr = newr;
			newr = r - quotient * tempr;
			newt = t - quotient * tempt;
			t = tempt;
			r = tempr;
		}
		if (r > 1) {
			throw new ArithmeticException("inverse of " + a + " mod " + n + " does not exist");
		} else {
			if (t < 0) {
				t += n;
			}
			return t;
		}
	}

	static long primeModInverse(long a, long n) {
		// returns inverse of a mod n by mod exponentiation, use only if n is prime
		return modexp(a, n - 2, n);
	}

	static void dfs(HashMap<Integer, ArrayList<Integer>> adj, Set<Integer> ans, Set<Integer> open,
			HashMap<String, Integer> edge, boolean[] vis, int i) {
		vis[i] = true;
		open.add(i);
		if (adj.get(i) != null) {
			for (int k : adj.get(i)) {
				if (!vis[k]) {
					dfs(adj, ans, open, edge, vis, k);
				} else if (open.contains(k)) {
					ans.add(edge.get(String.valueOf(i) + " " + String.valueOf(k)));
				}
			}
		}
		open.remove(i);
	}
}

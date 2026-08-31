import java.io.*;
import java.math.*;
import java.util.*;

public class test {

	static int INF = 1000000007;

	public static void main(String[] args) {
//		int test = fs.nextInt();
		int test = 1;
		for (int cases = 0; cases < test; cases++) {
			char[] aa = fs.next().toCharArray();
			char[] bb = fs.next().toCharArray();
			char[] cc = fs.next().toCharArray();
			StringBuilder s = new StringBuilder();
			int a[] = new int[26];
			int b[] = new int[26];
			int c[] = new int[26];
			for (int i = 0; i < aa.length; i++) {
				a[aa[i] - 'a']++;
			}
			for (int i = 0; i < bb.length; i++) {
				b[bb[i] - 'a']++;
			}
			for (int i = 0; i < cc.length; i++) {
				c[cc[i] - 'a']++;
			}
			while (true) {
				int c1 = Integer.MAX_VALUE;
				int c2 = Integer.MAX_VALUE;
				for (int i = 0; i < 26; i++) {
					if (b[i] > 0) {
						c1 = Integer.min(c1, a[i] / b[i]);
					}
					if (c[i] > 0) {
						c2 = Integer.min(c2, a[i] / c[i]);
					}
				}
				if (c1 == 0 && c2 == 0) {
					for (int i = 0; i < 26; i++) {
						int z = a[i];
						while (z > 0) {
							s.append((char) (i + 'a'));
							--z;
						}
					}
					break;
				} else if (c1 >= c2) {
					s.append(String.valueOf(bb));
					for (int i = 0; i < 26; i++) {
						a[i] -= b[i];
					}
				} else {
					s.append(String.valueOf(cc));
					for (int i = 0; i < 26; i++) {
						a[i] -= c[i];
					}
				}
			}
			System.out.println(s);
		}

	}

	static int countplz(HashMap<Character, Integer> hm1, HashMap<Character, Integer> hm2) {
		int count = Integer.MAX_VALUE;
		HashMap<Character, Integer> t = new HashMap<>(hm2);
		Set<Character> set = t.keySet();
		for (Character character : set) {
			if (hm1.get(character) == null) {
				count = 0;
				break;
			} else {
				count = Integer.min(count, hm1.get(character) / t.get(character));
			}
		}
		return count;
	}

	static class CPair {
		char x;
		int y;

		CPair(char x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	static class LongPair {
		long first;
		long second;

		LongPair(long a, long b) {
			this.first = a;
			this.second = b;
		}

	}

	static long power(long x, long y, long p) {
		long res = 1;
		x = x % p;
		while (y > 0) {
			if (y % 2 == 1)
				res = (res * x) % p;
			y = y >> 1;
			x = (x * x) % p;
		}
		return res;
	}

	static long modInverse(long n, long p) {
		return power(n, p - 2, p);
	}

	static long nCrModPFermat(long n, long r, long p) {
		long ans1 = 1;
		long i = n;
		long k = r;
		while (k > 0) {
			ans1 = mul(ans1, i, p);
			i--;
			k--;
		}
		long ans2 = 1;
		while (r > 0) {
			ans2 = mul(ans2, r, p);
			r--;
		}
		r = modInverse(ans2, p);
		ans1 = mul(ans1, r, p);
		return ans1;
	}

	static long facCalc(long total) {
		long ans = 1;
		for (long i = 2; i <= total; i++) {
			ans = mul(ans, i, INF);
		}
		return ans;
	}

	static long mul(long a, long b, long p) {
		return ((a % p) * (b % p)) % p;
	}

	static void sieve() {
		boolean prime[] = new boolean[101];
		Arrays.fill(prime, true);
		prime[1] = false;
		for (int i = 2; i * i <= prime.length - 1; i++) {
			for (int j = i * i; j <= prime.length - 1; j += i) {
				prime[j] = false;
			}
		}
	}

	public static int[] radixSort(int[] f) {
		return radixSort(f, f.length);
	}

	public static int[] radixSort(int[] f, int n) {
		int[] to = new int[n];
		{
			int[] b = new int[65537];
			for (int i = 0; i < n; i++)
				b[1 + (f[i] & 0xffff)]++;
			for (int i = 1; i <= 65536; i++)
				b[i] += b[i - 1];
			for (int i = 0; i < n; i++)
				to[b[f[i] & 0xffff]++] = f[i];
			int[] d = f;
			f = to;
			to = d;
		}
		{
			int[] b = new int[65537];
			for (int i = 0; i < n; i++)
				b[1 + (f[i] >>> 16)]++;
			for (int i = 1; i <= 65536; i++)
				b[i] += b[i - 1];
			for (int i = 0; i < n; i++)
				to[b[f[i] >>> 16]++] = f[i];
			int[] d = f;
			f = to;
			to = d;
		}
		return f;
	}

	static void printArray(int ar[]) {
		System.out.println(Arrays.toString(ar));
	}

	static class Pair {
		int first, second;

		public Pair(int first, int second) {
			this.first = first;
			this.second = second;
		}

	}

	static class Pair2 {
		int first;
		Pair second;

		public Pair2(int first, Pair second) {
			this.first = first;
			this.second = second;
		}

	}

	static long expmodulo(long a, long b, long c) {
		long x = 1;
		long y = a;
		while (b > 0) {
			if (b % 2 == 1) {
				x = (x * y) % c;
			}
			y = (y * y) % c; // squaring the base
			b /= 2;
		}
		return (long) x % c;
	}

	// static int modInverse(int a, int m) {
	// int m0 = m;
	// int y = 0, x = 1;
	//
	// if (m == 1)
	// return 0;
	//
	// while (a > 1) {
	// int q = a / m;
	// int t = m;
	// m = a % m;
	// a = t;
	// t = y;
	// y = x - q * y;
	// x = t;
	// }
	// if (x < 0)
	// x += m0;
	// return x;
	// }

	static int gcd(int a, int b) {
		if (b == 0)
			return a;
		return gcd(b, a % b);
	}

	static void sortMyMapusingValues(HashMap<Integer, Integer> hm) {

		List<Map.Entry<Integer, Integer>> capitalList = new LinkedList<>(hm.entrySet());

		Collections.sort(capitalList, new Comparator<Map.Entry<Integer, Integer>>() {
			public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
				return (o1.getValue()).compareTo(o2.getValue());
			}
		});
		HashMap<Integer, Integer> result = new HashMap<>();
		for (Map.Entry<Integer, Integer> entry : capitalList) {
			result.put(entry.getKey(), entry.getValue());
		}
	}

	static boolean ispowerof2(long num) {
		if ((num & (num - 1)) == 0)
			return true;
		return false;
	}

	static void primeFactors(int n) {
		while (n % 2 == 0) {
			System.out.print(2 + " ");
			n /= 2;
		}
		for (int i = 3; i <= Math.sqrt(n); i += 2) {
			while (n % i == 0) {
				System.out.print(i + " ");
				n /= i;
			}
		}
		if (n > 2)
			System.out.print(n);
	}

	static boolean isPrime(long n) {
		// Corner cases
		if (n <= 1)
			return false;
		if (n <= 3)
			return true;
		if (n % 2 == 0 || n % 3 == 0)
			return false;

		long sq = (long) Math.sqrt(n);
		for (int i = 5; i <= sq; i = i + 6)
			if (n % i == 0 || n % (i + 2) == 0)
				return false;

		return true;
	}

	static class Graph {
		HashMap<Integer, LinkedList<Integer>> hm = new HashMap<Integer, LinkedList<Integer>>();

		private void addVertex(int vertex) {
			hm.put(vertex, new LinkedList<>());
		}

		private void addEdge(int source, int dest, boolean bi) {
			if (!hm.containsKey(source))
				addVertex(source);
			if (!hm.containsKey(dest))
				addVertex(dest);
			hm.get(source).add(dest);
			if (bi) {
				hm.get(dest).add(source);
			}
		}

		private boolean uniCycle(int i, HashSet<Integer> visited, int parent) {
			visited.add(i);
			LinkedList<Integer> list = hm.get(i);
			Iterator<Integer> it = list.iterator();
			while (it.hasNext()) {
				Integer integer = (Integer) it.next();
				if (!visited.contains(integer)) {
					if (uniCycle(integer, visited, i))
						return true;
				} else if (integer != parent) {
					return true;
				}
			}
			return false;
		}

		private boolean uniCyclic() {
			HashSet<Integer> visited = new HashSet<Integer>();
			Set<Integer> set = hm.keySet();
			for (Integer integer : set) {
				if (!visited.contains(integer)) {
					if (uniCycle(integer, visited, -1)) {
						return true;
					}
				}
			}
			return false;
		}

		private boolean isbiCycle(int i, HashSet<Integer> visited, HashSet<Integer> countered) {
			if (countered.contains(i))
				return true;
			if (visited.contains(i))
				return false;
			visited.add(i);
			countered.add(i);
			LinkedList<Integer> list = hm.get(i);
			Iterator<Integer> it = list.iterator();
			while (it.hasNext()) {
				Integer integer = (Integer) it.next();
				if (isbiCycle(integer, visited, countered)) {
					return true;
				}
			}
			countered.remove(i);
			return false;
		}

		Boolean isReachable(int s, int d, int k) {
			if (hm.isEmpty()) {
				return false;
			}
			LinkedList<Integer> temp;
			boolean visited[] = new boolean[k];
			LinkedList<Integer> queue = new LinkedList<Integer>();
			visited[s] = true;
			queue.add(s);
			Iterator<Integer> i;
			while (queue.size() != 0) {
				s = queue.poll();
				int n;
				i = hm.get(s).listIterator();

				// Get all adjacent vertices of the dequeued vertex s
				// If a adjacent has not been visited, then mark it
				// visited and enqueue it
				while (i.hasNext()) {
					n = i.next();

					// If this adjacent node is the destination node,
					// then return true
					if (n == d)
						return true;

					// Else, continue to do BFS
					if (!visited[n]) {
						visited[n] = true;
						queue.add(n);
					}
				}
			}

			// If BFS is complete without visited d
			return false;
		}

		private boolean isbiCyclic() {
			HashSet<Integer> visited = new HashSet<Integer>();
			HashSet<Integer> countered = new HashSet<Integer>();
			Set<Integer> set = hm.keySet();
			for (Integer integer : set) {
				if (isbiCycle(integer, visited, countered)) {
					return true;
				}
			}
			return false;
		}
	}

	static class Node {
		Node left, right;
		int data;

		public Node(int data) {
			this.data = data;
		}

		public void insert(int val) {
			if (val <= data) {
				if (left == null) {
					left = new Node(val);
				} else {
					left.insert(val);
				}
			} else {
				if (right == null) {
					right = new Node(val);
				} else {
					right.insert(val);
				}
			}
		}

		public boolean contains(int val) {
			if (data == val) {
				return true;
			} else if (val < data) {
				if (left == null) {
					return false;
				} else {
					return left.contains(val);
				}
			} else {
				if (right == null) {
					return false;
				} else {
					return right.contains(val);
				}
			}
		}

		public void inorder() {
			if (left != null) {
				left.inorder();
			}
			System.out.print(data + " ");
			if (right != null) {
				right.inorder();
			}
		}

		public int maxDepth() {
			if (left == null)
				return 0;
			if (right == null)
				return 0;
			else {
				int ll = left.maxDepth();
				int rr = right.maxDepth();
				if (ll > rr)
					return (ll + 1);
				else
					return (rr + 1);
			}
		}

		public int countNodes() {
			if (left == null)
				return 1;
			if (right == null)
				return 1;
			else {
				return left.countNodes() + right.countNodes() + 1;
			}
		}

		public void preorder() {
			System.out.print(data + " ");
			if (left != null) {
				left.inorder();
			}

			if (right != null) {
				right.inorder();
			}

		}

		public void postorder() {
			if (left != null) {
				left.inorder();
			}

			if (right != null) {
				right.inorder();
			}
			System.out.print(data + " ");

		}

		public void levelorder(Node node) {
			LinkedList<Node> ll = new LinkedList<Node>();
			ll.add(node);
			getorder(ll);

		}

		public void getorder(LinkedList<Node> ll) {
			while (!ll.isEmpty()) {
				Node node = ll.poll();
				System.out.print(node.data + " ");
				if (node.left != null)
					ll.add(node.left);
				if (node.right != null)
					ll.add(node.right);
			}
		}
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

	static class OutputWriter {
		private final PrintWriter writer;

		public OutputWriter(OutputStream outputStream) {
			writer = new PrintWriter(new BufferedWriter(new OutputStreamWriter(outputStream)));
		}

		public OutputWriter(Writer writer) {
			this.writer = new PrintWriter(writer);
		}

		public void print(Object... objects) {
			for (int i = 0; i < objects.length; i++) {
				if (i != 0)
					writer.print(' ');
				writer.print(objects[i]);
			}
		}

		public void printLine(Object... objects) {
			print(objects);
			writer.println();
		}

		public void close() {
			writer.close();
		}

		public void flush() {
			writer.flush();
		}

	}

	private static final FastReader fs = new FastReader();
	private static final OutputWriter op = new OutputWriter(System.out);
}
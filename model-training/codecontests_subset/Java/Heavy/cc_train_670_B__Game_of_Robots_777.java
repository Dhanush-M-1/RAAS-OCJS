import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Main {
	static final boolean ONLINE_JUDGE = System.getProperty("ONLINE_JUDGE") != null;
	private final static Random rnd = new Random();

	boolean checkIndex(int index, int size) {
		return (0 <= index && index < size);
	}

	// ======================================================

	void solve() throws IOException {
		int n = rI();
		int k = rI();
		int[] a = rA(n);
		int i = 0;
		while (k - i > 0) {
			k -= i;
			i++;
		}

		out.println(a[k - 1]);

	}

	// =======================================================

	// ---------------------------------

	// --------------------------------
	// long[] dijkstra(int start) {
	// long[] distances = new long[n];
	// Arrays.fill(distances, INF);
	// Arrays.fill(parents, -1);
	// class Vertex implements Comparable<Vertex> {
	// int index;
	// long distance;
	//
	// Vertex(int index, long distance) {
	// this.index = index;
	// this.distance = distance;
	// }
	//
	// public int compareTo(Vertex other) {
	// return Long.compare(this.distance, other.distance);
	// }
	// }
	// Queue<Vertex> q = new PriorityQueue<>();
	// distances[start] = 0;
	// q.add(new Vertex(start, distances[start]));
	// while (q.size() > 0) {
	// Vertex vertex = q.poll();
	// if (vertex.distance > distances[vertex.index])
	// continue;
	// int from = vertex.index;
	// long fromDistance = distances[from];
	// // for (Edge e : graph[from]) { // e = { to, w }
	// int to = e.to;
	// long fromToDistance = fromDistance + e.w;
	// if (distances[to] > fromToDistance) {
	// distances[to] = fromToDistance;
	// parents[to] = from;
	// q.add(new Vertex(to, distances[to]));
	// }
	// }
	// }
	//
	// return distances;
	// }

	int min(int... values) {
		int min = Integer.MAX_VALUE;
		for (int value : values) {
			min = Math.min(min, value);
		}
		return min;
	}

	int max(int... values) {
		int max = Integer.MIN_VALUE;
		for (int value : values) {
			max = Math.max(max, value);
		}
		return max;
	}
	// ==============================================================================
	// class DSU {
	//
	// int parent[];
	// int size;
	//
	// DSU(int size) {
	// this.size = size;
	// this.parent = new int[size];
	// for (int i = 0; i < size; i++) {
	// parent[i] = i;
	// sizes[i] = 1;
	// }
	// }
	//
	// int get(int v) {
	// int paren = parent[v];
	// if (paren == v)
	// return v;
	// return parent[v] = get(paren);
	// }
	//
	// void union(int a, int b) {
	// a = get(a);
	// b = get(b);
	// if (a != b) {
	// size--;
	// if (rnd.nextBoolean()) {
	// parent[a] = b;
	// sizes[b] += sizes[a];
	// } else {
	// parent[b] = a;
	// sizes[a] += sizes[b];
	// }
	//
	// }
	// }
	//
	// }

	public static void main(String[] args) {
		new Main().run();
	}

	BufferedReader in;
	PrintWriter out;
	StringTokenizer tok;

	int maxA(int[] a) {
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < a.length; i++) {
			if (a[i] > max) {
				max = a[i];

			}
		}
		return max;
	}

	int minA(int[] a) {
		int min = Integer.MAX_VALUE;
		for (int i = 0; i < a.length; i++) {
			if (a[i] < min) {
				min = a[i];
			}
		}
		return min;
	}

	void init() throws FileNotFoundException {

		if (ONLINE_JUDGE) {
			in = new BufferedReader(new InputStreamReader(System.in));
			out = new PrintWriter(System.out);
		} else {
			in = new BufferedReader(new FileReader("input.txt"));
			out = new PrintWriter("output.txt");
		}

		tok = new StringTokenizer("");
	}

	void run() {
		try {
			long timeStart = System.currentTimeMillis();

			init();
			solve();

			out.close();

			long timeEnd = System.currentTimeMillis();
			System.err.println("Time = " + (timeEnd - timeStart) + " COMPILED");
		} catch (Exception e) {
			e.printStackTrace();
			System.exit(-1);
		}
	}

	long memoryTotal, memoryFree;

	void memory() {
		memoryFree = Runtime.getRuntime().freeMemory();
		System.err.println("Memory = " + ((-memoryTotal + memoryFree) >> 10) + " KB");
	}

	String readLine() throws IOException {
		return in.readLine();
	}

	String delimiter = " ";

	String rS() throws IOException {
		while (!tok.hasMoreTokens()) {
			String nextLine = readLine();
			if (null == nextLine)
				return null;

			tok = new StringTokenizer(nextLine);
		}

		return tok.nextToken(delimiter);
	}

	int[] rA(int b) {
		int a[] = new int[b];
		for (int i = 0; i < b; i++) {
			try {
				a[i] = rI();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return a;
	}

	int rI() throws IOException {
		return Integer.parseInt(rS());
	}

	long rL() throws IOException {
		return Long.parseLong(rS());
	}

	void sort(int[] a) {
		Integer arr[] = new Integer[a.length];
		for (int i = 0; i < a.length; i++) {
			arr[i] = a[i];
		}
		Arrays.sort(arr);
		for (int i = 0; i < a.length; i++) {
			a[i] = arr[i];
		}
	}

}
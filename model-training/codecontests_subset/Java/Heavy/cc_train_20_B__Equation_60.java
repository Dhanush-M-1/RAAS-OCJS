import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.BitSet;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Random;
import java.util.StringTokenizer;
import java.util.TreeMap;
import java.util.TreeSet;

import javax.management.RuntimeErrorException;

public class Template implements Runnable {

	BufferedReader in;
	PrintWriter out;
	StringTokenizer tok = new StringTokenizer("");

	void init() throws FileNotFoundException {
		try {
			in = new BufferedReader(new FileReader("input.txt"));
			out = new PrintWriter("output.txt");
		} catch (Exception e) {
			in = new BufferedReader(new InputStreamReader(System.in));
			out = new PrintWriter(System.out);
		}
	}

	class GraphBuilder {
		int n, m;
		int[] x, y;
		int index;
		int[] size;

		GraphBuilder(int n, int m) {
			this.n = n;
			this.m = m;
			x = new int[m];
			y = new int[m];
			size = new int[n];
		}

		void add(int u, int v) {
			x[index] = u;
			y[index] = v;
			size[u]++;
			size[v]++;
			index++;
		}

		void addDir(int u, int v) {
			x[index] = u;
			y[index] = v;
			size[u]++;
			index++;
		}

		int[][] buildDir() {
			int[][] graph = new int[n][];
			for (int i = 0; i < n; i++) {
				graph[i] = new int[size[i]];
			}
			for (int i = m - 1; i >= 0; i--) {
				graph[x[i]][--size[x[i]]] = y[i];
			}
			return graph;
		}

		int[][] build() {
			int[][] graph = new int[n][];
			for (int i = 0; i < n; i++) {
				graph[i] = new int[size[i]];
			}
			for (int i = m - 1; i >= 0; i--) {
				graph[x[i]][--size[x[i]]] = y[i];
				graph[y[i]][--size[y[i]]] = x[i];
			}
			return graph;
		}
	}

	String readString() throws IOException {
		while (!tok.hasMoreTokens()) {
			try {
				tok = new StringTokenizer(in.readLine());
			} catch (Exception e) {
				return null;
			}
		}
		return tok.nextToken();
	}

	int readInt() throws IOException {
		return Integer.parseInt(readString());
	}

	int[] readIntArray(int size) throws IOException {
		int[] res = new int[size];
		for (int i = 0; i < size; i++) {
			res[i] = readInt();
		}
		return res;
	}

	long readLong() throws IOException {
		return Long.parseLong(readString());
	}

	double readDouble() throws IOException {
		return Double.parseDouble(readString());
	}

	<T> List<T>[] createGraphList(int size) {
		List<T>[] list = new List[size];
		for (int i = 0; i < size; i++) {
			list[i] = new ArrayList<>();
		}
		return list;
	}

	public static void main(String[] args) {
		new Template().run();
		// new Thread(null, new Template(), "", 1l * 200 * 1024 * 1024).start();
	}

	long timeBegin, timeEnd;

	void time() {
		timeEnd = System.currentTimeMillis();
		System.err.println("Time = " + (timeEnd - timeBegin));
	}

	long memoryTotal, memoryFree;

	void memory() {
		memoryFree = Runtime.getRuntime().freeMemory();
		System.err.println("Memory = " + ((memoryTotal - memoryFree) >> 10) + " KB");
	}

	public void run() {
		try {
			timeBegin = System.currentTimeMillis();
			memoryTotal = Runtime.getRuntime().freeMemory();
			init();
			solve();
			out.close();
			if (System.getProperty("ONLINE_JUDGE") == null) {
				time();
				memory();
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.exit(-1);
		}
	}
	
	void solve() throws IOException {
		long a = readInt();
		long b = readInt();
		long c = readInt();
		
		if (a == 0) {
			if (b == 0) {
				if (c == 0) {
					out.println(-1);
				} else {
					out.println(0);
				}
			} else {
				out.println(1);
				out.println(-c / 1d / b);
			}
			return;
		}
		
		long d = b * b - 4 * a * c;
		if (d < 0) {
			out.println(0);
			return;
		}
		if (d == 0) {
			out.println(1);
			out.println(-b / 2d / a);
		} else {
			double dd = Math.sqrt(d);
			double x1 = (-b - dd) / 2d / a;
			double x2 = (-b + dd) / 2d / a;
			if (x1 > x2) {
				double t = x1;
				x1 = x2;
				x2 = t;
			}
			out.println(2);
			out.println(x1);
			out.println(x2);
		}
		
		
	}

}
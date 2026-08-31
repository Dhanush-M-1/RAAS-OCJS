import java.util.*;
import java.io.*;

public class Main{

	public static class Pair implements Comparable<Pair> {
		int id, val;

		public Pair(int id, int val) {
			this.id = id;
			this.val = val;
		}

		@Override
		public int compareTo(Pair o) {
			return Integer.compare(this.val, o.val);
		}
	}

	public static void main(String[] args) throws IOException {
		int N = readInt(), M = readInt(); ArrayList<Pair> graph[] = new ArrayList[N+1];
		for(int i = 1; i<=N; i++) graph[i] = new ArrayList<Pair>();
		for(int i = 1; i<=M; i++) {
			int l = readInt(), r = readInt(), d = readInt(); graph[l].add(new Pair(r, d)); graph[r].add(new Pair(l, -d));
		}
		int dist[] = new int[N+1]; boolean vis[] = new boolean[N+1];
		LinkedList<Integer> list = new LinkedList<Integer>(); 
		for(int i = 1; i<=N; i++) {
			if(!vis[i]) {
				list.add(i); vis[i] = true;
				while(!list.isEmpty()) {
					int n = list.pop(); 
					for(Pair e : graph[n]) {
						if(!vis[e.id]) {vis[e.id] = true; dist[e.id] = dist[n] + e.val; list.add(e.id);}
						if(vis[e.id] && dist[e.id] != dist[n] + e.val) {println("No"); exit();} 
					}
				}
			}
		}

		println("Yes");
		exit();
	}

	public static int find(int par[], int n) {
		if(par[n] == n) return par[n];
		else return par[n] = find(par, n);
	}

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;

	static String next() throws IOException {
		while (st == null || !st.hasMoreTokens())
			st = new StringTokenizer(br.readLine().trim());
		return st.nextToken();
	}

	static long readLong() throws IOException {
		return Long.parseLong(next());
	}

	static float readFloat() throws IOException {
		return Float.parseFloat(next());
	}

	static boolean readBool() throws IOException {
		return Boolean.parseBoolean(next());
	}

	static short readShort() throws IOException {
		return Short.parseShort(next());
	}

	static byte readByte() throws IOException {
		return Byte.parseByte(next());
	}

	static int readInt() throws IOException {
		return Integer.parseInt(next());
	}

	static double readDouble() throws IOException {
		return Double.parseDouble(next());
	}

	static char readChar() throws IOException {
		return next().charAt(0);
	}

	static String readLine() throws IOException {
		return br.readLine().trim();
	}

	static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

	static void print(Object o) {
		pr.print(o);
	}

	static void println(Object o) {
		pr.println(o);
	}

	static void flush() {
		pr.flush();
	}

	static void println() {
		pr.println();
	}

	static void exit() throws IOException {
		br.close();
		pr.close();
		System.exit(0);
	}
}

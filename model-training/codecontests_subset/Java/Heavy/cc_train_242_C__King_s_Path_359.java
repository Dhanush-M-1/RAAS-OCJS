import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class KingPath {
	public static void main(String[] args) throws NumberFormatException, IOException {
		Scanner sc = new Scanner(System.in);
		x0 = sc.nextInt();
		y0 = sc.nextInt();
		x1 = sc.nextInt();
		y1 = sc.nextInt();
		
		map = new TreeMap<Pair, Integer>();
		
		int nextNode = 0;
		int n = sc.nextInt();
		while(n-->0) {
			int r = sc.nextInt();
			int s = sc.nextInt();
			int e = sc.nextInt();
			for(int i = s; i <= e; i++) {
				Pair cell = new Pair(r, i);
				if(!map.containsKey(cell))
					map.put(cell, nextNode++);
			}
		}
		
		adjList = new ArrayList[nextNode];
		for(int i = 0; i < nextNode; i++)
			adjList[i] = new ArrayList<Integer>();
		
		int dx[] = {1, -1, 0, 0, 1, -1, 1, -1};
		int dy[] = {0, 0, 1, -1, 1, 1, -1, -1};
		for(Pair p : map.keySet()) {
			int curNode = map.get(p);
			for(int i = 0; i < 8; i++) {
				Pair adj = new Pair(p.x + dx[i], p.y + dy[i]);
				Integer adjNode = map.get(adj);
				if(adjNode != null) {
					adjList[curNode].add(adjNode);
				}
			}
		}
		int res = bfs();
		System.out.println(res == inf? -1 : res);
	}
	
	static int inf = (int) 1e7;
	static int bfs() {
		int[] dist = new int[map.size()];
		Pair start = new Pair(x0, y0);
		Pair end = new Pair(x1, y1);
		
		int sn = map.get(start), en = map.get(end);
		
		
		Arrays.fill(dist, inf);
		dist[sn] = 0;
		
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(sn);
		while(!q.isEmpty()) {
			int u = q.remove();
			
			for(int v : adjList[u])
				if(dist[v] == inf) {
					dist[v] = 1 + dist[u];
					q.add(v);
				}
		}
		
		return dist[en];
	}
	
	static int x0, y0, x1, y1;
	static TreeMap<Pair, Integer> map;
	static ArrayList<Pair> unmap;
	static ArrayList<Integer>[] adjList;
	
	static class Pair implements Comparable<Pair>{
		int x, y;
		Pair(int a, int b) {
			x = a; y = b;
		}
		@Override
		public int compareTo(Pair p) {
			return x == p.x? y - p.y : x - p.x;
		}
		
		public String toString() {
			return String.format("(%d, %d)", x, y);
		}
	}
	
	static class Scanner {
		BufferedReader br;
		StringTokenizer st;

		Scanner(FileReader f) {
			br = new BufferedReader(f);
		}

		public boolean ready() throws IOException {
			return br.ready();
		}

		Scanner(InputStream s) {
			br = new BufferedReader(new InputStreamReader(s));
		}

		String next() throws IOException {
			while (st == null || !st.hasMoreTokens())
				st = new StringTokenizer(br.readLine());
			return st.nextToken();
		}

		String nextLine() throws IOException {
			return br.readLine();
		}

		int nextInt() throws NumberFormatException, IOException {
			return Integer.parseInt(next());
		}

		long nextLong() throws NumberFormatException, IOException {
			return Long.parseLong(next());
		}
	}

}

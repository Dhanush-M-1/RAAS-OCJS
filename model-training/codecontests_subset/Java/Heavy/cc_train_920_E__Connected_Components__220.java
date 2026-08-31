import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;
import java.util.*;

public class test {
	

	static int N;
	static Set<Integer> adj[];
	static class dat implements Comparable<dat>{
		int val, f;
		public dat(int vv, int ff) {
			val=vv;
			f=ff;
		}
		@Override
		public int compareTo(dat o) {
			return f-o.f;
		}
	}
	
	public static void main(String[] args) {
		FastScanner in = new FastScanner();
		PrintWriter out = new PrintWriter(System.out);
		N = in.nextInt();
		int m = in.nextInt();
		adj = new HashSet[N];
		ArrayList<dat> list = new ArrayList<dat>();
		for(int i = 0; i < N; i++) {
			adj[i] = new HashSet<Integer>();
			list.add(new dat(i, 0));
		}
	
		for(int i = 0; i < m; i++) {
			int v1 = in.nextInt()-1;
			int v2 = in.nextInt()-1;
			list.get(v1).f++;
			list.get(v2).f++;
			adj[v1].add(v2);
			adj[v2].add(v1);
		}
		Collections.sort(list);
		
		ArrayDeque<Integer> q = new ArrayDeque<Integer>();
		
		DisjointSet dsu = new DisjointSet(N);
		boolean vis[] = new boolean[N];
		for(dat d : list) {
			int i = d.val;
			if(vis[i])continue;
			//if(vis[dsu.find(i)])continue;
			vis[i] = true;
			//vis[dsu.find(i)]=true;
			
			for(int j = 0; j < N; j++) {
				if(!adj[i].contains(j)) {
					vis[j]=true;
					q.add(j);
					dsu.union(i,j);
				}
			}
		}
		Arrays.fill(vis, false);
		while(!q.isEmpty()) {
			int i = q.poll();
			
			if(vis[i])continue;
			//if(vis[dsu.find(i)])continue;
			vis[i] = true;
			//vis[dsu.find(i)]=true;
			
			for(int j = 0; j < N; j++) {
				if(!adj[i].contains(j)) {
					vis[j]=true;
					dsu.union(i,j);
				}
			}
		}
		
//		
//		for(int i = 0; i < N; i++) {
//			if(vis[i])continue;
//			//if(vis[dsu.find(i)])continue;
//			vis[i] = true;
//			//vis[dsu.find(i)]=true;
//			
//			for(int j = 0; j < N; j++) {
//				if(!adj[i].contains(j)) {
//					vis[j]=true;
//					dsu.union(i,j);
//				}
//			}
//		}
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		for(int i = 0; i < N; i++) {
			map.put(dsu.find(i), 1+map.getOrDefault(dsu.find(i), 0));
		}
		ArrayList<Integer> nums = new ArrayList<Integer>();
		for(int i = 0; i < N; i++) {
			if(map.containsKey(i)) {
				nums.add(map.get(i));
			}
		}
		Collections.sort(nums);
		out.println(nums.size());
		for(int i = 0; i < nums.size(); i++) out.print(nums.get(i)+" ");
		out.close();
	}
	
	
	/*
6 20
1 4
1 5
1 3
1 6
2 5
2 3
2 6
4 1
4 3
4 6
5 1
5 2
5 6
3 1
3 2
3 4
6 1
6 2
6 4
6 5
	 */
	static class DisjointSet {
		int[] s;
		
		public DisjointSet(int n) {
			Arrays.fill(s = new int[n], -1);
		}
		
		public int find(int i) {
			return s[i] < 0 ? i : (s[i] = find(s[i]));
		}
		
		public boolean union(int a, int b) {
			if ((a = find(a)) == (b = find(b))) return false;
			if(s[a] == s[b]) s[a]--;
			if(s[a] <= s[b]) s[b] = a; else s[a] = b;
			return true;
		}
	}
	
	static class FastScanner{
		BufferedReader br;
		StringTokenizer st;
		public FastScanner(String s) {
			try{
				br = new BufferedReader(new FileReader(s));
			}
			catch(FileNotFoundException e) {
				e.printStackTrace();
			}
		}
		public FastScanner(){
			br = new BufferedReader(new InputStreamReader(System.in));
		}
		
		String nextToken()	{
			while(st == null ||!st.hasMoreElements()){
				try {
				st = new StringTokenizer(br.readLine());}
				catch(IOException e) {
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
		String next() {
			return nextToken();
		}
		
	}

}
import java.io.*;
import java.util.*;

public class A {
	public static void main (String[] args) { new A(); }

	int curSize;
	boolean[] killed;
	
	A() {
		FastScanner s = new FastScanner();
		PrintWriter out = new PrintWriter(System.out);
		System.err.println("");

		int n = s.nextInt();
		int m = s.nextInt();
		int k = s.nextInt();
		killed = new boolean[m];
		
		ArrayList<int[]>[] adj = new ArrayList[n];
		for(int i = 0; i < n; i++) adj[i] = new ArrayList<>();
		int[][] edges = new int[m][2];
		int[] deg = new int[n];
		
		for(int i = 0; i < m; i++) {
			int u = edges[i][0] = s.nextInt()-1;
			int v = edges[i][1] = s.nextInt()-1;
			adj[u].add(new int[] {v, i}); adj[v].add(new int[] {u, i});
			deg[u]++; deg[v]++;
		}
		
		boolean[] dead = new boolean[n];
		for(int i = 0; i < n; i++) if(deg[i] < k) dead[i] = true;
		int[] initMark = new int[n];
		for(int i = 0; i < n; i++) {
			if(dead[i]) continue;
			for(int[] v : adj[i]) if(!dead[v[0]]) initMark[i]++;
		}
		
		ArrayDeque<Integer> dq = new ArrayDeque<>();
		for(int i = 0; i < n; i++) {
			if(!dead[i] && initMark[i] < k) {
				flood(i, k, dead, adj, initMark, dq);
			}
		}
		
		int[] conTo = new int[n];
		for(int i = 0; i < n; i++) {
			if(dead[i]) continue;
			for(int[] v : adj[i]) {
				if(!dead[v[0]]) conTo[i]++;
			}
		}
		for(int i = 0; i < n; i++) {
			if(dead[i]) continue;
			if(conTo[i] < k) {
				flood(i, k, dead, adj, conTo, dq);
			}
		}
		
		curSize = 0;
		for(int i = 0; i < n; i++) if(!dead[i]) curSize++;
		
		int[] res = new int[m];
		res[m-1] = curSize;
		for(int i = m-1; i > 0; i--) {
			int u = edges[i][0], v = edges[i][1];
			if(dead[u] || dead[v] || killed[i]) {
				res[i-1] = curSize;
				continue;
			}
			conTo[u]--; conTo[v]--;
			killed[i] = true;
			if(conTo[u] < k) flood(u, k, dead, adj, conTo, dq);
			if(conTo[v] < k) flood(v, k, dead, adj, conTo, dq);
			
			res[i-1] = curSize;
		}
		
		for(int i : res) out.println(i);
		out.close();
		
	}
	
	void flood(int i, int k, boolean[] dead, ArrayList<int[]>[] adj, int[] cnt, ArrayDeque<Integer> dq) {
		if(dead[i]) return;
		dead[i] = true;
		dq.add(i);
		while(!dq.isEmpty()) {
			curSize--;
			int u = dq.pollFirst();
			for(int[] e : adj[u]) {
				int v = e[0], id = e[1];
				if(dead[v] || killed[id]) continue;
				killed[id] = true;
				cnt[v]--;
				if(cnt[v] < k) {
					dead[v] = true;
					dq.add(v);
				}
			}
		}
	}
	
	class FastScanner {
		public int BS = 1<<16;
		public char NC = (char)0;
		byte[] buf = new byte[BS];
		int bId = 0, size = 0;
		char c = NC;
		double num = 1;
		BufferedInputStream in;
 
		public FastScanner() {
			in = new BufferedInputStream(System.in, BS);
		}
 
		public FastScanner(String s) {
			try {
				in = new BufferedInputStream(new FileInputStream(new File(s)), BS);
			}
			catch (Exception e) {
				in = new BufferedInputStream(System.in, BS);
			}
		}
 
		public char nextChar(){
			while(bId==size) {
				try {
					size = in.read(buf);
				}catch(Exception e) {
					return NC;
				}                
				if(size==-1)return NC;
				bId=0;
			}
			return (char)buf[bId++];
		}
 
		public int nextInt() {
			return (int)nextLong();
		}
 
		public long nextLong() {
			num=1;
			boolean neg = false;
			if(c==NC)c=nextChar();
			for(;(c<'0' || c>'9'); c = nextChar()) {
				if(c=='-')neg=true;
			}
			long res = 0;
			for(; c>='0' && c <='9'; c=nextChar()) {
				res = (res<<3)+(res<<1)+c-'0';
				num*=10;
			}
			return neg?-res:res;
		}
 
		public double nextDouble() {
			double cur = nextLong();
			return c!='.' ? cur:cur+nextLong()/num;
		}
 
		public String next() {
			StringBuilder res = new StringBuilder();
			while(c<=32)c=nextChar();
			while(c>32) {
				res.append(c);
				c=nextChar();
			}
			return res.toString();
		}
 
		public String nextLine() {
			StringBuilder res = new StringBuilder();
			while(c<=32)c=nextChar();
			while(c!='\n') {
				res.append(c);
				c=nextChar();
			}
			return res.toString();
		}
 
		public boolean hasNext() {
			if(c>32)return true;
			while(true) {
				c=nextChar();
				if(c==NC)return false;
				else if(c>32)return true;
			}
		}
		
		public int[] nextIntArray(int n) {
			int[] res = new int[n];
			for(int i = 0; i < n; i++) res[i] = nextInt();
			return res;
		}
		
	}

}
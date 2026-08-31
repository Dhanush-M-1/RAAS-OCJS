import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.*;

public class D {
	
	static ArrayList<Integer> adj[];
	static int cnt[];
	static int deps[];
	public static void main(String args[]) {
		JS in = new JS();
		PrintWriter out = new PrintWriter(System.out);
	
		int N = in.nextInt();
		adj = new ArrayList[N];
		cnt = new int[N];
		for(int i = 0; i < N; i++) adj[i] = new ArrayList<Integer>();
		deps = new int[N];
		
		for(int i = 0; i < N; i++) {
			int c = in.nextInt();
			if(c==0)continue;
			
			int v1 = i;
			int v2 = c-1;
			adj[v1].add(v2);
			adj[v2].add(v1);
			cnt[v1]++;
			cnt[v2]++;
		}
		
		//Do a BFS to get deps
		ArrayDeque<state> q = new ArrayDeque<state>();
		q.add(new state(0,0));
		boolean vis[] = new boolean[N];
		vis[0] = true;
		deps[0] = 0;
		while(!q.isEmpty()) {
			state v = q.poll();			
			for(Integer next : adj[v.node]) {
				if(vis[next])continue;
				vis[next] = true;
				q.add(new state(next, v.dep+1));
				deps[next] = v.dep+1;
			}	
		}
		
		vis = new boolean[N];
		PriorityQueue<state> pq = new PriorityQueue<state>();
		ArrayList<Integer> res = new ArrayList<Integer>();
		for(int i = 0; i < N; i++) {
			if(cnt[i]%2 == 0) pq.add(new state(i, deps[i], cnt[i]));
		}
		while(!pq.isEmpty()) {
			state v = pq.poll();
			if(v.cnt != cnt[v.node])continue;
			res.add(v.node);
			vis[v.node] = true;
			for(Integer next : adj[v.node]) {
				if(vis[next])continue;
				cnt[next]--;
				if(cnt[next]%2==0)pq.add(new state(next, deps[next], cnt[next]));
			}
		}
		
		boolean good =true;
		for(int i = 0; i < N; i++) {
			if(!vis[i])good=false;
		}
		
		if(good) {
			out.println("YES");
			for(Integer ii : res) out.println((ii+1));
		}
		else {
			out.println("NO");
		}

		out.close();
	}
	
	static class state implements Comparable<state>{
		int node, cnt, dep;
		public state(int nn, int dd) {
			node=nn;
			dep=dd;
		}
		public state(int nn, int dd, int cc) {
			node=nn;
			dep=dd;
			cnt = cc;
		}
		@Override
		public int compareTo(state o) {
			return o.dep-this.dep;
		}
	}

	static class JS{
		public int BS = 1<<16;
		public char NC = (char)0;
		byte[] buf = new byte[BS];
		int bId = 0, size = 0;
		char c = NC;
		double num = 1;
		BufferedInputStream in;
		
		public JS() {
			in = new BufferedInputStream(System.in, BS);
		}
		
		public JS(String s) throws FileNotFoundException {
			in = new BufferedInputStream(new FileInputStream(new File(s)), BS);
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
	}
	
}

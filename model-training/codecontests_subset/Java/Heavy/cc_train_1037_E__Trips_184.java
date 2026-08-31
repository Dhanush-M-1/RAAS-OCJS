import java.io.*;
import java.util.*;

public class e {
	public static void main(String[] args) {
		JS in = new JS();
		int n = in.nextInt();
		int m = in.nextInt();
		int k = in.nextInt();
		
		
		HashSet<Integer> adj[] = new HashSet[n];
		for(int i = 0; i < n; i++) adj[i] = new HashSet<>();
		
		int friends[] = new int[n];
		Stack<Integer> ans = new Stack<>(), uq = new Stack<>(), vq = new Stack<>();
		for(int i = 0; i < m; i++ ){
			int u = in.nextInt()-1;
			int v = in.nextInt()-1;
			adj[u].add(v);
			adj[v].add(u);
			uq.add(u);
			vq.add(v);
			friends[u]++;
			friends[v]++;
		}
		
		int a = n;
		ArrayDeque<Integer> q= new ArrayDeque<>();
		boolean good[] = new boolean[n];
		Arrays.fill(good, true);
		for(int i = 0; i < n; i++) {
			if(friends[i] < k) {
				q.add(i);
				good[i] = false;
				a--;
			}
		}
		
		while(!q.isEmpty()) {
			int u = q.poll();
			for(int v : adj[u]) {
				friends[v]--;
				if(good[v] && friends[v] < k) {
					good[v] = false;
					a--;
					q.add(v);
				}
			}
		}
		ans.add(a);
		for(int i = 0; i < m; i++) {
			int u = uq.pop();
			int v = vq.pop();
			
			if(good[u] && good[v]) {
				friends[v]--;
				friends[u]--;
				adj[u].remove(v);
				adj[v].remove(u);
				if(friends[v] < k) {
					a--;
					q.add(v);
					good[v] = false;
				}
				if(friends[u] < k){
					a--;
					q.add(u);
					good[u] = false;
				}
				while(!q.isEmpty()) {
					int uu = q.poll();
					for(int vv : adj[uu]) {
						friends[vv]--;
						if(good[vv] && friends[vv] < k) {
							good[vv] = false;
							a--;
							q.add(vv);
						}
					}
				}
			}
			ans.add(a);

		}
		ans.pop();
		PrintWriter out = new PrintWriter(System.out);
		for(int i = 0; i < m; i++) {
			out.println(ans.pop());
		}
		out.close();
		
	}
	
	static class JS {
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

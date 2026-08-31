import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;

public class C455 {
	
	class Tree {
		int diam, deepest;
		void set(int a, int b) {
			diam = a; deepest = b;
		}
	}
	
	@SuppressWarnings("unchecked")
	public void solve(JoltyScanner in, PrintWriter out) {
		int n = in.nextInt();
		int m = in.nextInt();
		int qs = in.nextInt();
		ArrayList<Integer>[] vs = new ArrayList[n];
		for(int i = 0; i < n; ++i) vs[i] = new ArrayList<>();
		DSU dsu = new DSU(n);
		for(int i = 0; i < m; ++i) {
			int u = in.nextInt() - 1;
			int v = in.nextInt() - 1;
			vs[u].add(v);
			vs[v].add(u);
			dsu.union(u, v);
		}
		Tree[] trees = new Tree[n];
		boolean[] done = new boolean[n];
		for(int i = 0; i < n; ++i) trees[i] = new Tree();
		for(int i = 0; i < n; ++i) {
			int id = dsu.get(i);
			if(done[id]) continue;
			done[id] = true;
			int leaf = -1, len = 0;
			{
				ArrayDeque<Integer> q = new ArrayDeque<>();
				q.add(i); q.add(-1);
				while(!q.isEmpty()) {
					int cur = q.poll();
					int par = q.poll();
					leaf = cur;
					for(int j : vs[cur]) if(j != par) {
						q.add(j);
						q.add(cur);
					}
				}
			}
			{
				ArrayDeque<Integer> q = new ArrayDeque<>();
				ArrayDeque<Integer> dist = new ArrayDeque<>();
				q.add(leaf); q.add(-1);
				dist.add(0);
				while(!q.isEmpty()) {
					int cur = q.poll();
					int par = q.poll();
					int cdist = dist.poll();
					len = cdist;
					for(int j : vs[cur]) if(j != par) {
						q.add(j);
						q.add(cur);
						dist.add(cdist + 1);
					}
				}
			}
			int diam = len;
			int deepest = (len + 1) / 2;
			trees[id].diam = diam;
			trees[id].deepest = deepest;
		}
		while(qs-->0) {
			int type = in.nextInt();
			if(type == 1) {
				int node = in.nextInt() - 1;
				out.println(trees[dsu.get(node)].diam);
			} else {
				int x = in.nextInt() - 1, y = in.nextInt() - 1;
				Tree tx = trees[dsu.get(x)], ty = trees[dsu.get(y)];
				if(tx == ty) continue;
				int ndiam = -1, ndeepest = -1;
				ndiam = Math.max(tx.diam, ty.diam);
				ndiam = Math.max(tx.deepest + ty.deepest + 1, ndiam);
				ndeepest = (ndiam + 1) / 2;
				dsu.union(x, y);
				trees[dsu.get(x)].set(ndiam, ndeepest);
//				System.out.println(x + " U " + y + " => diam=" + ndiam + " deepest=" + ndeepest);
			}
		}
	}

	public static void main(String[] args) {
		JoltyScanner in = new JoltyScanner();
		PrintWriter out = new PrintWriter(System.out);
		new C455().solve(in, out);
		out.close();
	}
	
	class DSU {
		int[] id;
		int size;
		DSU(int x) {
			size = x + 1;
			id = new int[size];
			for (int i = 0; i < size; ++i) {
				id[i] = i;
			}
		}
		int get(int a) {
			return id[a] == a ? a : (id[a] = get(id[a]));
		}
		void union(int a, int b) {
			if(get(a) == get(b)) return;
			id[get(a)] = id[get(b)];
			--size;
		}
	}
	
	static class JoltyScanner {
		public int BS = 1<<16;
		public char NC = (char)0;
		byte[] buf = new byte[BS];
		int bId = 0, size = 0;
		char c = NC;
		double num = 1;
		BufferedInputStream in;

		public JoltyScanner() {
			in = new BufferedInputStream(System.in, BS);
		}

		public JoltyScanner(String s) throws FileNotFoundException {
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
	        while(c!='.'&&c!='-'&&(c <'0' || c>'9')) c = nextChar();
	        boolean neg = c=='-';
	        if(neg)c=nextChar();
	        boolean fl = c=='.';
	        double cur = nextLong();
	        if(fl) return neg ? -cur/num : cur/num;
	        if(c == '.') {
	            double next = nextLong();
	            return neg ? -cur-next/num : cur+next/num;
	        }
	        else return neg ? -cur : cur;
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

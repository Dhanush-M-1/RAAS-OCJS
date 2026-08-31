import java.io.*;
import java.util.*;

public class B implements Runnable{
	public static void main (String[] args) {new Thread(null, new B(), "_cf", 1 << 28).start();}

	//Lesson: try and think in terms of bipartite graphs
	//when the stuff is this big I guess. And break bad
	//greedy solutions like making the frequency of each
	//row/col >= 2 except one (too complicated)
	
	public void run() {
		FastScanner fs = new FastScanner();
		PrintWriter out = new PrintWriter(System.out);
		System.err.println("Go!");

		int n = fs.nextInt();
		int m = fs.nextInt();
		int q = fs.nextInt();
		ArrayList<Integer>[] adj = new ArrayList[n+m];
		for(int i = 0; i < n+m; i++) {
			adj[i] = new ArrayList<>();
		}
		for(int i = 0; i < q; i++) {
			int x = fs.nextInt() - 1;
			int y = fs.nextInt() - 1;
			adj[x].add(y+n);
			adj[y+n].add(x);
		}
		int num = 1;
		int[] comp = new int[n + m], queue = new int[n+m];
		for(int i = 0; i < n+m; i++) if(comp[i] == 0) {
			int tail = 0;
			queue[tail++] = i;
			comp[i] = num;
			for(int j = 0; j < tail; j++) {
				int u = queue[j];
				for(int v : adj[u]) if(comp[v] == 0) {
					comp[v] = num;
					queue[tail++] = v;
				}
			}
			num++;
		}
		out.println(num - 2);
		out.close();
	}

	void sort (int[] a) {
		int n = a.length;
		for(int i = 0; i < 50; i++) {
			Random r = new Random();
			int x = r.nextInt(n), y = r.nextInt(n);
			int temp = a[x];
			a[x] = a[y];
			a[y] = temp;
		}
		Arrays.sort(a);
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

		public FastScanner(String s) throws FileNotFoundException {
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
		
		public int[] nextIntArray(int n) {
			int[] res = new int[n];
			for(int i = 0; i < n; i++) res[i] = nextInt();
			return res;
		}
		
	}

}
import java.io.*;
import java.util.*;

public class E implements Runnable{
	public static void main (String[] args) {new Thread(null, new E(), "_cf", 1 << 28).start();}

	public void run() {
		FastScanner fs = new FastScanner();
		PrintWriter out = new PrintWriter(System.out);
		System.err.println("Go!");

		long oo = (long)1e18;
		int n = fs.nextInt();
		int m = fs.nextInt();
		int k = fs.nextInt();
		boolean[] marked = new boolean[n+1];
		int[] big = new int[n+1], start = new int[n+1];
		int max = 0;
		for(int i = 0; i < m; i++) {
			marked[fs.nextInt()] = true;
		}
		for(int i = 0; i < n; i++) {
			if(!marked[i]) continue;
			int p1 = i;
			while(p1 < n && marked[p1]) p1++;
			int sz = p1-i;
			p1 = i;
			while(p1 < n && marked[p1]) {
				start[p1] = i;
				big[p1++] = sz;
			}
			max = Math.max(max, big[i]);
			i = p1-1;
		}
		if(marked[0]) {
			System.out.println(-1);
			return;
		}
		long res = oo;
		for(int pw = 1; pw <= k; pw++) {
			long cost = fs.nextLong();
			if(max >= pw) continue;
			long cnt = 0;
			int at = 0;
			while(at < n) {
				if(marked[at]) {
					at = start[at]-1;
				}
				cnt++;
				at += pw;
			}
			res = Math.min(res, cost * cnt);
		}
		
		if(res == oo) res = -1;
		out.println(res);
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
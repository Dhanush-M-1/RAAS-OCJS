import java.io.*;
import java.util.*;

public class D implements Runnable{
	public static void main (String[] args) {new Thread(null, new D(), "_cf", 1 << 28).start();}

	public void run() {
		FastScanner fs = new FastScanner();
		PrintWriter out = new PrintWriter(System.out);
		System.err.println("Go!");

		int n = fs.nextInt();
		int d = fs.nextInt();
		int res = 0, sum = 0, curMax = 0;
		int ll = -1, rr = -1;
		for(int i = 0; i < n; i++) {
			int x = fs.nextInt();
			if(x < 0) {
				sum += x;
			}
			else if(x > 0) {
				sum += x;
				if(sum > d) {
					out.println(-1);
					out.close();
					return;
				}
				if(ll!=-1) {
					if(rr-ll+sum>d) {
						rr-=sum;
					}
				}
//				if(sum > curMax && ll != -1) {
//					rr += curMax;
//					curMax = sum;
//					rr -= sum;
//					if(rr < ll) {
//						out.println(-1);
//						out.close();
//						return;
//					}
//				}
			}
			else {
				if(sum < 0) {
					if(ll == -1) {
						ll = 0; rr = d;
						++res;
						sum = 0;
					}
					else {
						ll += (-sum);
						if(ll > rr) {
							++res;
							ll = 0;
							rr = d;
							curMax = 0;
						}
						sum = 0;
					}
				}
			}
		}
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
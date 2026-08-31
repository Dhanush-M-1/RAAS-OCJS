import java.io.*;
import java.util.*;

public class A {
	public static void main (String[] args) {
//		int tests = 1000;
//		while(tests-->0) {
//			new A(); 
//		}
		new A();
	}

	int SIZE;
	int[] dp, lastOcc, lastOcc2, actVals, Ls, Rs, sumBlock;
	int[][] dpSum;
	
	public A() {
//		try { new TestGen(); } catch (Exception e) {}
		FastScanner fs = new FastScanner();
//		fs = new FastScanner("testdata.out");
//		PrintWriter out = new PrintWriter(System.out);
		System.err.println("");

		int n = fs.nextInt();
		int k = fs.nextInt();
		SIZE = (int)Math.sqrt(n);
		
		int[] a = new int[n];
		for(int i = 0; i < n; i++) {
			a[i] = fs.nextInt()-1;
		}

		int numBlocks = n/SIZE + (n%SIZE > 0 ? 1 : 0);
		
		int[] blockID = new int[n];
		Ls = new int[numBlocks];
		sumBlock = new int[numBlocks];
		Rs = new int[numBlocks];
		dpSum = new int[numBlocks][2 * SIZE + 1];
		actVals = new int[n];
		
		for(int i = 0, curID = 0; i < n; i += SIZE) {
			int R = Math.min(n-1, i+SIZE-1);
			Ls[curID] = i; Rs[curID] = R;
			for(int j = i; j <= R; j++) {
				blockID[j] = curID;
			}
			curID++;
		}
		
		int[] lastOcc = new int[n];
		int[] lastOcc2 = new int[n];
		Arrays.fill(lastOcc, -1);
		Arrays.fill(lastOcc2, -1);
		
		dp = new int[n + 1];
		dp[0] = 1;
		
		for(int i = 0; i < n; i++) {
			if(lastOcc[a[i]] != -1) {
				int who = lastOcc[a[i]];
				int id = blockID[who];
				actVals[who] = -1;
				
				updateBlock(id);
			}
			if(lastOcc2[a[i]] != -1) {
				int who = lastOcc2[a[i]];
				int id = blockID[who];
				actVals[who] = 0;
				
				updateBlock(id);
			}
			int myID = blockID[i];
			actVals[i] = 1;
			
			int ways = 0;
			int numD = 0;
			for(int j = i; j >= Ls[myID]; j--) {
				numD += actVals[j];
				if(numD <= k) {
					ways = add(ways, dp[j]);
				}
			}
			
			for(int bid = myID-1; bid >= 0; bid--) {
				int diff = k-numD;
				diff = Math.min(diff, SIZE);
				if(diff >= -SIZE) {
					ways = add(ways, dpSum[bid][diff+SIZE]);
				}
				numD += sumBlock[bid];
			}
			
			dp[i+1] = ways;
			
			updateBlock(myID);
			lastOcc2[a[i]] = lastOcc[a[i]];
			lastOcc[a[i]] = i;
		}
		
		System.out.println(dp[n]);
		
//		int br = naive(a, k);
//		System.out.println(br);
//		if(br != dp[n]) throw null;
	}
	
	void updateBlock(int id) {
		Arrays.fill(dpSum[id], 0);
		int curSum = 0;
		for(int j = Rs[id]; j >= Ls[id]; j--) {
			curSum += actVals[j];
			int pos = curSum+SIZE;
			dpSum[id][pos] = add(dpSum[id][pos], dp[j]);
		}
		
		sumBlock[id] = curSum;
		for(int j = 1; j < dpSum[id].length; j++) {
			dpSum[id][j] = add(dpSum[id][j-1], dpSum[id][j]);
		}
	}
	
	int naive(int[] a, int k) {
		int n = a.length;
		int max = 0; for(int i : a) max = Math.max(max, i);
		int[] dp = new int[n + 1];
		dp[0] = 1;
		for(int i = 0; i < n; i++) {
			int[] freq = new int[max+1];
			int nD = 0;
			for(int j = i; j >= 0; j--) {
				int v = a[j];
				if(freq[v] == 0) {
					nD++;
				}
				else if(freq[v] == 1) {
					nD--;
				}
				freq[v]++;
				if(nD <= k) dp[i+1] = add(dp[i+1], dp[j]);
			}
		}
		System.out.println("> " + Arrays.toString(dp));
		return dp[n];
	}
	
	int MOD = 998244353;
	int add(int a, int b) {
		a += b;
		if(a >= MOD) a -= MOD;
		return a;
	}
	
	class Block {
		int L, R;
		int[] pref, dpSum;
		Block(int l, int r) {
			L = l; R = r;
			pref = new int[2 * SIZE + 1];
			dpSum = new int[2 * SIZE + 1];
		}
		void update(int pos) {
			
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
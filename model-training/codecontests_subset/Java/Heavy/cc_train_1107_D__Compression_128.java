import java.io.*;
import java.util.*;

public class D implements Runnable {
	public static void main (String[] args) {new Thread(null, new D(), "_cf", 1 << 28).start();}
	
	public void run() {
		FastScanner fs = new FastScanner();
		PrintWriter out = new PrintWriter(System.out);
		System.err.println("Go!");
		
		int[] map = new int[256];
		int cnt = 0;
		for(int i = '0'; i <= '9'; i++) map[i] = cnt++;
		for(int i = 'A'; i <= 'F'; i++) map[i] = cnt++;

		int n = fs.nextInt();
		ArrayList<Integer> div = new ArrayList<Integer>();
		for(int i = 2; i <= n; i++) if(n%i == 0) div.add(i);
		String[] matrix = new String[n];
		String[][] vals = new String[div.size()][n];
		for(int i = 0; i < n; i++) {
			matrix[i] = fs.next();
		}
		int[][] chains = new int[4*matrix[0].length()][2];
		for(int i = 0; i < n; i++) {
			StringBuilder actual = new StringBuilder();
			for(char c : matrix[i].toCharArray()) actual.append(pad(Integer.toBinaryString(map[c]), 4));
			int ptr = 0;
			for(int j = 0; j < actual.length(); j++) {
				int k = j;
				while(k < actual.length() && actual.charAt(j) == actual.charAt(k)) k++;
				int len = k-j;
				chains[ptr][0] = len;
				chains[ptr++][1] = actual.charAt(j)-'0';
				j = k-1;
			}
			for(int j = 0; j < div.size(); j++) {
				int cur = 0, in = 0;
				int x = div.get(j), per = x;
				boolean fails = false;
				StringBuilder ret = new StringBuilder();
				while(cur < ptr) {
					if(in+per > chains[cur][0]) {
						fails = true;
						break;
					}
					in += per;
					ret.append(chains[cur][1]);
					if(in == chains[cur][0]) {
						cur++; in = 0;
					}
				}
				if(fails) {
					vals[j][i] = null;
				}
				else {
					vals[j][i] = ret.toString();
				}
			}
		}
//		for(int j = 0; j < div.size(); j++) {
//			System.out.printf("For %d\n", div.get(j));
//			for(int i = 0; i < n; i++) System.out.println(vals[j][i]);
//			System.out.println();
//		}
		
		for(int j = div.size() - 1; j >= 0; j--) {
			int x = div.get(j);
			boolean res = true;
			for(int i = 0; i < n && res; i += x) {
				int k = i, ct = 0;
				boolean good = true;
				while(ct < x && good) {
					good &= vals[j][k+ct] != null && vals[j][k+ct].equals(vals[j][i]);
					ct++;
				}
				res &= good;
			}
			if(res) {
				System.out.println(x);
				return;
			}
		}
		out.println(1);
		out.close();
	}
	
	String pad(String binaryString, int i) {
		while(binaryString.length() < i) binaryString = "0" + binaryString;
		return binaryString;
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
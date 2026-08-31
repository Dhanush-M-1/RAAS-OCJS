import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.InputMismatchException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.TreeMap;
import java.util.TreeSet;

import javax.sound.midi.Synthesizer;

public class Q2 {
	static long MOD = 1000000007;
	static boolean b[];
	static ArrayList<Integer>[] amp;
	static long sum[];
	static long ans = 0;
	static FasterScanner sc = new FasterScanner();
	static Queue<String> q = new LinkedList<>();
	static ArrayList<String>[] arr;
	public static void main(String[] args) throws IOException {
		BufferedWriter log = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = sc.nextInt();
		Pair prr[] = new Pair[n];
		for(int i = 0;i<n;i++){
			int x = sc.nextInt(), y = sc.nextInt();
			prr[i] = new Pair(x,y);
		}
		if(n==1 || n==2) System.out.println(n);
		else{
			int cnt = 2;
			int temp = prr[0].u;
			for(int i = 1;i<n-1;i++){
				if(temp<(prr[i].u-prr[i].v)){
					temp = prr[i].u;
					cnt++;
				}
				else if(prr[i+1].u>(prr[i].u+prr[i].v)){
					cnt++;
					temp = (prr[i].u+prr[i].v);
				}
				else temp = prr[i].u;
			}
			System.out.println(cnt);
		}
		/*
		Arrays.sort(prr);
		for(int i =0;i<n;i++)
		System.out.println(prr[i]);
		int cnt = 1, temp = 0;
		for(int i = 1;i<n;i++){
			if(prr[i].v>temp){
				if(2*prr[i].v-prr[i].u>prr[i-1].v){
					cnt++;
				}
				else{
					temp = prr[i].u;
					cnt++;
				}
			}
			System.out.println(temp);
		}
		System.out.println(cnt);*/
		log.close();
	}
	static int p = 0;
	public static void bfs(){
		if(!q.isEmpty()){
			String x = q.poll();
			int y = Integer.parseInt(q.poll());
			arr[p].add(x);
			//System.out.println(x+" "+y+" "+p);
			for(int i= 0;i<y;i++){
				p++;
				bfs();
				p--;
			}
		}
	}
	public static void buildGraph(int n){
		for(int i =0;i<n;i++){
			int x = sc.nextInt(), y = sc.nextInt();
			amp[--x].add(--y);
			amp[y].add(x);
		}
	}
	public static void dfs(int x){
		ans++;
		b[x] = true;
		for(int i =0 ;i<amp[x].size();i++){
			if(!b[amp[x].get(i)]){
				dfs(amp[x].get(i));
			}
		}
	}
	public static void seive(long n){
		b = new boolean[(int) (n+1)];
		Arrays.fill(b, true);
		for(int i = 2;i<=n;i++){
			if(b[i]){
				for(int p = 2*i;p<=n;p++){
					b[p] = false;
				}
			}
		}
	}
	static long modInverse(long a, long mOD2){
	            return  power(a, mOD2-2, mOD2);
	}
	static long power(long x, long y, long m)
	{
	    if (y == 0)
	        return 1;
	    long p = power(x, y/2, m) % m;
	    p = (p * p) % m;
	 
	    return (y%2 == 0)? p : (x * p) % m;
	}
	static long power2(long x,BigInteger y,long m){
		long ans = 1;
		BigInteger two = new BigInteger("2");
		while(y.compareTo(BigInteger.ZERO)>0){
			if(y.getLowestSetBit()==y.bitCount()){
				x = (x*x)%MOD;
				y = y.divide(two);
			}
			else{
				ans = (ans*x)%MOD;
				y = y.subtract(BigInteger.ONE);
			}
		}
		return ans;
	}
	static BigInteger power2(BigInteger x, BigInteger y, BigInteger m){
		BigInteger ans = new BigInteger("1");
		BigInteger one  = new BigInteger("1");
		BigInteger two  = new BigInteger("2");
		BigInteger zero  = new BigInteger("0");
		while(y.compareTo(zero)>0){
			//System.out.println(y);
			if(y.mod(two).equals(one)){
				ans = ans.multiply(x).mod(m);
				y = y.subtract(one);
			}
			else{
				x = x.multiply(x).mod(m);
				y = y.divide(two);
			}
		}
		return ans;
	}
	static BigInteger power(BigInteger x, BigInteger y, BigInteger m)
	{
	    if (y.equals(0))
	        return (new BigInteger("1"));
	    BigInteger p = power(x, y.divide(new BigInteger("2")), m).mod(m);
	    p = (p.multiply(p)).mod(m);
	 
	    return (y.mod(new BigInteger("2")).equals(0))? p : (p.multiply(x)).mod(m);
	}
	static long d,x,y;
	public static void extendedEuclidian(long a, long b){
		if(b == 0) {
	        d = a;
	        x = 1;
	        y = 0;
	    }
	    else {
	        extendedEuclidian(b, a%b);
	        int temp = (int) x;
	        x = y;
	        y = temp - (a/b)*y;
	    }
	}
	
	public static long gcd(long n, long m){
		if(m!=0) return gcd(m,n%m);
		else return n;
	}
	
	static class Pair implements Comparable<Pair> {
		int u;
		int v;
		public Pair(){
			
		}
		public Pair(int u, int v) {
			this.u = u;
			this.v = v;
		}
		
		public int hashCode() {
			int hu = (int) (u ^ (u >>> 32));
			int hv = (int) (v ^ (v >>> 32));
			return 31*hu + hv;
		}

		public boolean equals(Object o) {
			Pair other = (Pair) o;
			return (u == other.u && v == other.v);
		}

		public int compareTo(Pair other) {
			return Integer.compare(u, other.u) != 0 ? (Integer.compare(u, other.u)) : (Integer.compare(v, other.v));
		}

		public String toString() {
			return "[u=" + u + ", v=" + v + "]";
		}
	}
	public static class FasterScanner {
		private byte[] buf = new byte[1024];
		private int curChar;
		private int numChars;
 
		public int read() {
			if (numChars == -1)
				throw new InputMismatchException();
			if (curChar >= numChars) {
				curChar = 0;
				try {
					numChars = System.in.read(buf);
				} catch (IOException e) {
					throw new InputMismatchException();
				}
				if (numChars <= 0)
					return -1;
			}
			return buf[curChar++];
		}
 
		public String nextLine() {
			int c = read();
			while (isSpaceChar(c))
				c = read();
			StringBuilder res = new StringBuilder();
			do {
				res.appendCodePoint(c);
				c = read();
			} while (!isEndOfLine(c));
			return res.toString();
		}
 
		public String nextString() {
			int c = read();
			while (isSpaceChar(c))
				c = read();
			StringBuilder res = new StringBuilder();
			do {
				res.appendCodePoint(c);
				c = read();
			} while (!isSpaceChar(c));
			return res.toString();
		}
 
		public long nextLong() {
			int c = read();
			while (isSpaceChar(c))
				c = read();
			int sgn = 1;
			if (c == '-') {
				sgn = -1;
				c = read();
			}
			long res = 0;
			do {
				if (c < '0' || c > '9')
					throw new InputMismatchException();
				res *= 10;
				res += c - '0';
				c = read();
			} while (!isSpaceChar(c));
			return res * sgn;
		}
 
		public int nextInt() {
			int c = read();
			while (isSpaceChar(c))
				c = read();
			int sgn = 1;
			if (c == '-') {
				sgn = -1;
				c = read();
			}
			int res = 0;
			do {
				if (c < '0' || c > '9')
					throw new InputMismatchException();
				res *= 10;
				res += c - '0';
				c = read();
			} while (!isSpaceChar(c));
			return res * sgn;
		}
	        
	    public int[] nextIntArray(int n) {
	        return nextIntArray(n, 0);
	    }
	    
	    public int[] nextIntArray(int n, int off) {
	    	int[] arr = new int[n + off];
	    	for (int i = 0; i < n; i++) {
	    		arr[i + off] = nextInt();
	    	}
	    	return arr;
	    }
	    
	    public long[] nextLongArray(int n) {
	    	return nextLongArray(n, 0);
	    }
        
		public long[] nextLongArray(int n, int off) {
		    long[] arr = new long[n + off];
		    for (int i = 0; i < n; i++) {
		        arr[i + off] = nextLong();
		    }
		    return arr;
		}
 
	    private boolean isSpaceChar(int c) {
			return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
		}
 
		private boolean isEndOfLine(int c) {
			return c == '\n' || c == '\r' || c == -1;
		}
	}
}
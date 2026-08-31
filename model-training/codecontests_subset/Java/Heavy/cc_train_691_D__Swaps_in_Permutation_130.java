/*
 * Code Author: Akshay Miterani
 * DA-IICT
 */
import java.io.*;
import java.math.*;
import java.text.*;
import java.util.*;
 
public class A {
 
	static double eps=(double)1e-15;
	static long mod=(int)1e9+7;
	static ArrayList<ArrayList<Integer>> arr=new ArrayList<ArrayList<Integer>>();
	static ArrayList<Integer> pos=new ArrayList<Integer>();
	static ArrayList<Integer> val=new ArrayList<Integer>();
	static boolean v[];
	static int a[];
	public static void main(String args[]){
		InputReader in = new InputReader(System.in);
		OutputStream outputStream = System.out;
		PrintWriter out = new PrintWriter(outputStream);
		//----------My Code----------
		int n=in.nextInt();
		int m=in.nextInt();
		a=new int[n];
		for(int i=0;i<n;i++){
			a[i]=in.nextInt();
		}
		
		for(int i=0;i<n+5;++i){
			arr.add(new ArrayList<Integer>());
		}
		for(int i=0;i<m;i++){
			int u=in.nextInt()-1;
			int v=in.nextInt()-1;
			arr.get(u).add(v);
			arr.get(v).add(u);
		}
		int ans[]=new int[n];
		v=new boolean[n];
		for(int i=0;i<n;i++){
			if(!v[i]){
				pos.clear();
				val.clear();
				dfs(i);
				Collections.sort(pos);
				Collections.sort(val,Collections.reverseOrder());
				for(int x=0;x<pos.size();x++){
					ans[pos.get(x)]=val.get(x);
				}
			}
		}
		for(int x:ans){
			out.print(x+" ");
		}
		out.println();
		out.close();
		//---------------The End------------------
 
	}
	static void dfs(int x){
		if(v[x])
			return;
		v[x]=true;
		pos.add(x);
		val.add(a[x]);
		for(int v:arr.get(x)){
			dfs(v);
		}
	}
	static class Pair implements Comparable<Pair> {
		int u;
		int v;

		public Pair(int u, int v) {
			this.u = u;
			this.v = v;
		}
 
		public int hashCode() {
			int hu = (int) (u ^ (u >>> 32));
			int hv = (int) (v ^ (v >>> 32));
			return 31 * hu + hv;
		}
 
		public boolean equals(Object o) {
			Pair other = (Pair) o;
			return u == other.u && v == other.v;
		}
 
		public int compareTo(Pair other) {
			return Long.compare(u, other.u) != 0 ? Long.compare(u, other.u) : Long.compare(v, other.v);
		}
 
		public String toString() {
			return "[u=" + u + ", v=" + v + "]";
		}
	}
	public static void debug(Object... o) {
		System.out.println(Arrays.deepToString(o));
	}
	static long modulo(long a,long b,long c) {
		long x=1;
		long y=a;
		while(b > 0){
			if(b%2 == 1){
				x=(x*y)%c;
			}
			y = (y*y)%c; // squaring the base
			b /= 2;
		}
		return  x%c;
	}
	static long gcd(long x, long y)
	{
		if(x==0)
			return y;
		if(y==0)
			return x;
		long r=0, a, b;
		a = (x > y) ? x : y; // a is greater number
		b = (x < y) ? x : y; // b is smaller number
		r = b;
		while(a % b != 0)
		{
			r = a % b;
			a = b;
			b = r;
		}
		return r;
	}
	static class InputReader {
		public BufferedReader reader;
		public StringTokenizer tokenizer;
 
		public InputReader(InputStream inputstream) {
			reader = new BufferedReader(new InputStreamReader(inputstream));
			tokenizer = null;
		}
 
		public String nextLine(){
			String fullLine=null;
			while (tokenizer == null || !tokenizer.hasMoreTokens()) {
				try {
					fullLine=reader.readLine();
				} catch (IOException e) {
					throw new RuntimeException(e);
				}
				return fullLine;
			}
			return fullLine;
		}
		public String next() {
			while (tokenizer == null || !tokenizer.hasMoreTokens()) {
				try {
					tokenizer = new StringTokenizer(reader.readLine());
				} catch (IOException e) {
					throw new RuntimeException(e);
				}
			}
			return tokenizer.nextToken();
		}
		public long nextLong() {
			return Long.parseLong(next());
		}
		public int nextInt() {
			return Integer.parseInt(next());
		}
	}
}  

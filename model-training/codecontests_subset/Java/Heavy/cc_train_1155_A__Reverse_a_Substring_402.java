import java.util.*;


import java.awt.Point;
import java.io.*;
import java.math.BigInteger;
public class Solutions {
	 
static int MAX=Integer.MAX_VALUE;
		static int MIN=Integer.MIN_VALUE;
//static ArrayList<ArrayList<Integer>>list=new ArrayList<ArrayList<Integer>>();
	static FastScanner scr=new FastScanner();
	static PrintStream out=new PrintStream(System.out);
//	static ArrayList<Integer>list[];
//	static StringBuilder sb=new StringBuilder();
	public static void main(String []args) {
//		int t=scr.nextInt();
//		while(t-->0) {
			solve();
//		}
//		out.println(sb);
	}
//	static HashMap<Integer,Integer>hm;
	static void solve() {
		int n=scr.nextInt();
		char c[]=scr.next().toCharArray();
		
		boolean bad=true;
		int l=-1;
		int k=-1;
		for(int i=0;i<n-1;i++) {
			if(c[i]>c[i+1]) {
				l=i;
				k=i+1;
				bad=false;
			}
		}
		if(bad) {
			out.println("NO");
		}else {
			out.println("YES");
			out.println((l+1)+" "+(k+1)); 	
		}
	}
	static class pair{
		int x;
		int y;
		pair(int x,int y){
			this.x=x;
			this.y=y;
		}
	}
	static boolean isVowel(char c) {
		return c=='a' || c=='e'||c=='i'|| c=='o' || c=='u';
	}
	static int gcd(int a,int b){
		if(b==0) {
			return a;
		}
		
		return gcd(b,a%b);
	}
	static long modPow(long base,long exp,long mod) {
		if(exp==0) {
			return 1;
		}
		if(exp%2==0) {
			long res=(modPow(base,exp/2,mod));
			return (res*res)%mod;
		}
		return (base*modPow(base,exp-1,mod))%mod;
	}
	static long gcd(long a,long b) {
		if(b==0) {
			return a;
		}
		return gcd(b,a%b);
	}
	static class FastScanner {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer("");
	 	String next() {
	 		while (!st.hasMoreTokens())
	 			try {
	 				st=new StringTokenizer(br.readLine());
	 			} catch (IOException e) {
	 				e.printStackTrace();
	 			}
	 			return st.nextToken();
		}
		int[] sort(int a[]) {
			Arrays.sort(a);
			return a;
		}
		int []reverse(int a[]){
			int b[]=new int[a.length];
			int index=0;
			for(int i=a.length-1;i>=0;i--) {
				b[index]=a[i];
			}
			return b;
		}
		int nextInt() {
			return Integer.parseInt(next());
		}
		int[] readArray(int n) {
			int[] a=new int[n];
			for (int i=0; i<n; i++) a[i]=nextInt();
			return a;
		}
		long[] readLongArray(int n) {
			long  [] a=new long  [n];
			for (int i=0; i<n; i++) a[i]=nextLong();
			return a;
		}
		long nextLong() {
			return Long.parseLong(next());
		}
	}

}

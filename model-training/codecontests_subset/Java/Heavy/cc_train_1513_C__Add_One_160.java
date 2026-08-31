import java.util.*;
import java.io.*;
import java.util.Map.Entry;


public class Main{

	static final int inf=Integer.MAX_VALUE;
	static final int mod=(int)1e9+7;
	static long [] length;
	
	//divide into cases, brute force
	//sort, greedy, binary search
	//transform into graph
	
	static void solve(Reader in, Writer out){
		
		int n=in.ni(), m=in.ni();

		long ans=0;

		while(n>0){
			ans+=digLength(n%10, m);
			n/=10;
			ans%=mod;
		}

		out.println(ans);
		
	}

	static long digLength(int n, int m){
		if(m<10-n) return 1;
		m-=(10-n);
		return length[m];
	}

	public static void main(String[] args) throws IOException {
		Writer out=new Writer(System.out);
		Reader in=new Reader(System.in);	
		int ts=1;
		ts=in.ni();
		int M=(int)2e5+5;
		long [] tens=new long[M];
		tens[0]=1;
		for(int i=9; i<M; ++i){
			tens[i]+=tens[i-9];
			if(i>=10) tens[i]+=tens[i-10];
			tens[i]%=mod;
		}

		length=new long[M];
		length[0]=2;
		for(int i=1; i<M; ++i){
			length[i]=length[i-1]+tens[i];
			length[i]%=mod;
		}

		// out.println(length);

		while(ts-->0) {
			solve(in, out);
		}
		out.close();
	}
	static long ppow(long n, long m){
		if(m==0) return 1;
		long tmp=ppow(n,m/2);
		tmp=tmp*tmp%mod;
		return m%2==0 ? tmp : tmp*n %mod;
	}
	static long gcd(long n, long m){ return m==0 ? n : gcd(m, n%m); }
	static long lcm(long n, long m){ return n/gcd(n,m)*m; }
	static int smaller(long [] a, long k){
		if(a[0]>k) return 0;
		int t=0;
		for(int j=a.length; j>=1; j/=2){
			while(t+j<a.length && a[t+j]<k) t+=j;
		}
		return t+1;
	}
	static void reverse(int a[]){
		ArrayList<Integer> al=new ArrayList<>();
		for(int i: a) al.add(i);
		Collections.reverse(al);
		for(int i=0; i<al.size(); ++i) a[i]=al.get(i); 
	}
	static void sort(long a[]) {
		ArrayList<Long> al=new ArrayList<>();
		for(long i: a) al.add(i);
		Collections.sort(al);
		for(int i=0; i<a.length; ++i) a[i]=al.get(i);
	}
	static void sort(pair [] p){
		ArrayList<pair> pl=new ArrayList<>();
		for(pair pa: p) pl.add(pa);
		Collections.sort(pl, (p1, p2)->{
			return Long.compare(p1.u, p2.u)==0 ? Long.compare(p1.v,p2.v): Long.compare(p1.u,p2.u);
		});
		for(int i=0; i<p.length; ++i) p[i]=pl.get(i);
	}
	static void reverse(pair[] p){
		int n=p.length;
		for(int i=0; i<p.length/2; ++i){
			pair tmp=new pair(0,0);
			tmp.copy(p[i]);
			p[i].copy(p[n-1-i]);
			p[n-1-i].copy(tmp);
		}
	}
	static class pair{
		long u, v;
		pair(long g, long h){u=g; v=h;}
		void copy(pair p){u=p.u; v=p.v;};
	}
	static class Reader{
		
		BufferedReader br;
		StringTokenizer to;
		
		Reader(InputStream stream){
			br=new BufferedReader(new InputStreamReader(stream));
			to=new StringTokenizer("");
		}
		String nextLine() {
			String line="";
			try {
				line=br.readLine();
			}catch(IOException e) {};
			return line;
		}
		String ns() {
			while(!to.hasMoreTokens()) {
				try {
					to=new StringTokenizer(br.readLine());	
				}catch(IOException e) {}
			}
			return to.nextToken();
		}
		int ni() { return Integer.parseInt(ns()); }
		long nl() { return Long.parseLong(ns()); }
		int [] ra(int n) { int a[]=new int[n]; for(int i=0; i<n; i++) a[i]=ni(); return a; }
		long [] rla(int n) { long [] a =new long[n]; for(int i=0; i<n; ++i) a[i]=nl(); return a; }
	}	
	static class Writer extends PrintWriter{
		Writer(OutputStream stream){ super(stream); }
		void println(pair p){ println(p.u+" "+p.v); }
		void println(int a[]){ for(int i: a) print(i+" "); println(); }
	}
}
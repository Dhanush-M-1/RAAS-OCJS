import java.util.*;
import java.io.*;
import java.util.Map.Entry;


public class Main{

	static int inf=Integer.MAX_VALUE;
	static int mod=(int)1e9+7;
	static long [] fact;
	
	
	//divide into cases, brute force
	//sort, greedy, binary search
	//transform into graph
	
	static void solve(Reader in, Writer out){
		
		int n=in.ni(), k=in.ni();
		ArrayList<Integer> likeBoth=new ArrayList<>(), likeAlice=new ArrayList<>(), likeBob=new ArrayList<>();

		for(int i=0; i<n; ++i){
			int t=in.ni(), a=in.ni(), b=in.ni();
			if(a==1 && b==1){
				likeBoth.add(t);
			}else if(a==1){
				likeAlice.add(t);
			}else if(b==1){
				likeBob.add(t);
			}
		}

		Collections.sort(likeBoth); Collections.sort(likeAlice); Collections.sort(likeBob);
		int sc=likeBoth.size(), sa=likeAlice.size(), sb=likeBob.size();
		if(sc+sa<k || sc+sb<k){
			out.println(-1);
			return;
		}

		int preBoth[]=new int[sc+1];
		int preAlice[]=new int[sa+1];
		int preBob[]=new int[sb+1];

		for(int i=1; i<=sc; ++i){
			preBoth[i]=preBoth[i-1]+likeBoth.get(i-1);
		}

		for(int i=1; i<=sa; ++i){
			preAlice[i]=preAlice[i-1]+likeAlice.get(i-1);
		}

		for(int i=1; i<=sb; ++i){
			preBob[i]=preBob[i-1]+likeBob.get(i-1);
		}

		int ans=inf;
		for(int i=0; i<=Math.min(k,sc); ++i){
			if(k-i>sa || k-i>sb) continue;
			int tmp=preBoth[i]+preAlice[k-i]+preBob[k-i];
			ans=Math.min(ans,tmp);
		}

		out.println(ans);

	}

	public static void main(String[] args) throws IOException {
		Writer out=new Writer(System.out);
		Reader in=new Reader(System.in);	
		// mod=998244353;
		int ts=1;
		// ts=in.ni();
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
	static long nCr(int n, int r){ return fact[n]*ppow(fact[n-r], mod-2) % mod * ppow(fact[r],mod-2) % mod; }
	static void factInit(int n){ fact=new long[n]; fact[0]=1; for(int i=1; i<n; ++i) fact[i]=fact[i-1]*i % mod; }
	static int smaller(long [] a, long k){
		if(a[0]>k) return 0; int t=0;
		for(int j=a.length; j>=1; j/=2){ while(t+j<a.length && a[t+j]<k) t+=j; } return t+1;
	}
	static void reverse(int a[]){
		ArrayList<Integer> al=new ArrayList<>();
		for(int i: a) al.add(i); Collections.reverse(al);
		for(int i=0; i<al.size(); ++i) a[i]=al.get(i); 
	}
	static void reverse(long a[]){
		ArrayList<Long> al=new ArrayList<>();
		for(long i: a) al.add(i); Collections.reverse(al);
		for(int i=0; i<al.size(); ++i) a[i]=al.get(i); 
	}
	static void sort(int a[]) {
		ArrayList<Integer> al=new ArrayList<>();
		for(int i: a) al.add(i); Collections.sort(al);
		for(int i=0; i<a.length; ++i) a[i]=al.get(i);
	}
	static void sort(long a[]){
		ArrayList<Long> al=new ArrayList<>();
		for(long i: a) al.add(i); Collections.sort(al);
		for(int i=0; i<a.length; ++i) a[i]=al.get(i);
	}
	static void sort(pair [] p){
		ArrayList<pair> pl=new ArrayList<>(); for(pair pa: p) pl.add(pa);
		Collections.sort(pl, (p1, p2)->{
			return Long.compare(p1.u, p2.u)==0 ? Long.compare(p1.v,p2.v): Long.compare(p1.u,p2.u);
		});
		for(int i=0; i<p.length; ++i) p[i]=pl.get(i);
	}
	static void reverse(pair[] p){
		int n=p.length;
		for(int i=0; i<p.length/2; ++i){
			pair tmp=new pair(0,0); tmp.copy(p[i]);
			p[i].copy(p[n-1-i]); p[n-1-i].copy(tmp);
		}
	}
	static class pair{
		long u,v; pair(long g, long h){u=g; v=h;}
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
			try { line=br.readLine(); }catch(IOException e) {};
			return line;
		}
		String ns() {
			while(!to.hasMoreTokens()) { try { to=new StringTokenizer(br.readLine()); }catch(IOException e) {} }
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
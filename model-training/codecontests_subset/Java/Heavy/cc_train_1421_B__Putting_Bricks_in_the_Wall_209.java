import java.io.*;
import java.util.*;

public class Main{
	
	static int mod=(int)1e9+7;
	
	public static void main(String[] args) throws IOException {
		Writer out=new Writer(System.out);
		Reader in=new Reader(System.in);
		int ts=in.nextInt();
		outer: while(ts-->0) {	
		
			int n=in.nextInt();
			String s[]=new String[n];
			for(int i=0; i<n; i++) s[i]=in.next();
			char a=s[0].charAt(1);
			char b=s[1].charAt(0);
			char c=s[n-2].charAt(n-1);
			char d=s[n-1].charAt(n-2);
			
		
			boolean []b1=new boolean[4];
			boolean []b2=new boolean[4];
			
			int chng1=chng(a,b,c,d,'0','1',b1);
			int chng2=chng(a,b,c,d,'1','0',b2);
			
			if(chng1<chng2)
			{
				chng2=chng1;
				b2=b1;
			}
				out.println(chng2);
				if(b2[0]) out.println(1+" "+2);
				if(b2[1]) out.println(2+" "+1);
				if(b2[2]) out.println((n-1)+" "+(n));
				if(b2[3]) out.println((n)+" "+(n-1));
			
		
			
		}
		out.close();		
		
	}
	
	
	static int chng(char a, char b, char c, char d, char o, char z,boolean bo[]) {
		
		int ans=0;
		if(a!=o) {
			ans++;
			bo[0]=true;
		}
		if(b!=o) {
			ans++;
			bo[1]=true;
		}
		if(c!=z) {
			ans++;
			bo[2]=true;
		}
		if(d!=z) {
			ans++;
			bo[3]=true;
		}
		return ans;
		
	}
	
/*********************************** UTILITY CODE BELOW **************************************/	
		
	static int abs(int a) {
		return a>0 ? a : -a;
	}
	
	static int max(int a, int b) {
		return a>b ? a : b;
	}
	
	static int min(int a, int b) {
		return a<b ? a : b;
	}
	static long pow(long n, long m) {
		if(m==0) return 1;
		long temp=pow(n,m/2);
		long res=((temp*temp)%mod);
		if(m%2==0) return res;
		return (res*n)%mod;
	}
	
	static class Pair{
		int u, v;
		
		Pair(int u, int v){this.u=u; this.v=v;}
		
		static void sort(Pair [] coll) {		
			List<Pair> al=new ArrayList<>(Arrays.asList(coll));
			Collections.sort(al,new Comparator<Pair>() {
				public int compare(Pair p1, Pair p2) {
					return p1.u-p2.u;
				}	
			});
			for(int i=0; i<al.size(); i++) {
				coll[i]=al.get(i);
			}
		}
		
	}
	
	static void sort(int[] a) {
		ArrayList<Integer> list=new ArrayList<>();
		for (int i:a) list.add(i);
		Collections.sort(list);
		for (int i=0; i<a.length; i++) a[i]=list.get(i);
	}
	
	static void sort(long a[]) {
		ArrayList<Long> list=new ArrayList<>();
		for(long i: a) list.add(i);
		Collections.sort(list);
		for(int i=0; i<a.length; i++) a[i]=list.get(i);
	}
	
	static int [] array(int n, int value) {	
		int a[]=new int[n];
		for(int i=0; i<n; i++) a[i]=value;
		return a;
	}
	
	static class Reader{
		
		BufferedReader br;
		StringTokenizer to;
		
		Reader(InputStream stream){
			br=new BufferedReader(new InputStreamReader(stream));
			to=new StringTokenizer("");
		}
		
		String next() {
			while(!to.hasMoreTokens()) {
				try {
					to=new StringTokenizer(br.readLine());	
				}catch(IOException e) {}
				
			}
			return to.nextToken();
			
		}
		
		int nextInt() {
			return Integer.parseInt(next());
		}
		
		long nextLong() {
			return Long.parseLong(next());
		}
		
		int [] readArray(int n) {
			int a[]=new int[n];
			for(int i=0; i<n ;i++) a[i]=nextInt();
			return a;
		}
		long [] readLongArray(int n) {
			long a[]=new long[n];
			for(int i=0; i<n ;i++) a[i]=nextLong();
			return a;
		}
		
	}
	
	static class Writer extends PrintWriter{
		Writer(OutputStream stream){
			super(stream);
		}
		void println(int [] array) {
			for(int i=0; i<array.length; i++) {
				print(array[i]+" ");
			}
			println();
		}
		void println(long [] array) {
			for(int i=0; i<array.length; i++) {
				print(array[i]+" ");
			}
			println();
		}
	}
	
}
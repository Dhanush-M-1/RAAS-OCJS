import java.io.*;
import java.util.*;

public class X {

	public static void main(String[] args) {
		FastScanner in=new FastScanner();
		PrintWriter out=new PrintWriter(System.out);
        solve(in,out);
		out.close();
	}
	
	static void solve(FastScanner in,PrintWriter out){
	    //	out.println(1);
		 int n=in.nextInt();
		 int k=in.nextInt();
		 int a[][]=new int[n][3];
		 	
		 for(int i=0;i<n;i++) {
		     a[i][0]=in.nextInt();  a[i][1]=in.nextInt();   a[i][2]=in.nextInt(); 
		 }
		 
		 ArrayList<Integer> a1=new ArrayList<Integer>();
		 ArrayList<Integer> a2=new ArrayList<Integer>();
		  ArrayList<Integer> mix=new ArrayList<Integer>();
	     double sum=0;
	     for(int i=0;i<n;i++){
	         if(a[i][2]==0&&a[i][1]==0) continue;
	         if(a[i][1]==1&&a[i][2]==1) mix.add(a[i][0]);  
	          else if(a[i][2]==1&&a[i][1]==0) a2.add(a[i][0]);
	          else a1.add(a[i][0]);
	     }
	     Collections.sort(a1);
	     Collections.sort(a2);
	     Collections.sort(mix);
	    if(a1.size()+mix.size()<k||a2.size()+mix.size()<k) { out.println("-1"); return; }
	    int c1=0,c2=0,m=0;
	    long ans=0;
	    //out.println(a1); out.println(a2); out.println(mix);
	    for(int i=0;i<k;i++){
	        if(m>=mix.size()||(c1<a1.size()&&c2<a2.size()&&a1.get(c1)+a2.get(c2)<=mix.get(m))) { ans+=a1.get(c1); ans+=a2.get(c2); c1++; c2++; }
	        else ans+=mix.get(m++);
	    }
	    out.println(ans);
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
		
		int nextInt() {
			return Integer.parseInt(next());
		}
		int[] readArray(int n) {
			int[] a=new int[n];
			for (int i=0; i<n; i++) a[i]=nextInt();
			return a;
		}
		long nextLong() {
			return Long.parseLong(next());
		}
	}

	
}

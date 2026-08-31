import java.io.*;
import java.util.*;

public class C {

	public static void main(String[] args) {
        FastScanner in = new FastScanner();
        PrintWriter out = new PrintWriter(System.out);
        int t = in.nextInt();
        while(t-->0) { 
        	long n = in.nextInt(), l = in.nextLong(), r = in.nextLong();
        	long x = 1;
      		long sum = 1;
      		while(sum+(n-x)*2<l){
      			sum += (n-x)*2;
      			x++;
      		}
      		StringBuilder sb = new StringBuilder();
      		while(sum<=r){
      			if(sum>n*(n-1)){
      				sb.append(1); break;
      			}
      			for(long i=x+1;i<=n;i++){
      				if(sum>=l&&sum<=r) sb.append(x+" ");
      				sum++;
      				if(sum>=l&&sum<=r) sb.append(i+" ");
      				sum++;
      			}
      			x++;
      		}
      		out.println(sb);
        }
        out.flush();
	}
	
	static class FastScanner {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer("");
		
		String next() {
			while(!st.hasMoreTokens())
				try { st = new StringTokenizer(br.readLine()); }
				catch(IOException e) {}
			return st.nextToken();
		}
		
		String nextLine(){
			try{ return br.readLine(); } 
			catch(IOException e) { } return "";
		}
		
		int nextInt() {
			return Integer.parseInt(next());
		}
		
		long nextLong() {
			return Long.parseLong(next());
		}
		
		int[] readArray(int n) {
			int a[] = new int[n];
			for(int i=0;i<n;i++) a[i] = nextInt();
			return a;
		}
	}
}

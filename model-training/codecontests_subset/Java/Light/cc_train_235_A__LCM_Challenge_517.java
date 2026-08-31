import java.util.*;
import java.io.*;

public class Main{

	public static void main(String[] args) throws IOException {
		PrintWriter out=new PrintWriter(System.out);
		Reader in=new Reader(System.in);	
		int ts=1;
//		ts=in.nextInt();
		outer: while(ts-->0) {
			
			int n=in.nextInt();
			if(n==1) out.println(1);
			else if(n==2) out.println(2);
			else if(n==4) {
				out.println(12);
			}
			else {
				if(n%2!=0) {
					out.println((long)n*(n-1)*(n-2));
				} else {
					if(n%3==0) {
						out.println((long)(n-3)*(n-1)*(n-2));
					}else {
						out.println((long)n*(n-1)*(n-3));
					}
				}
			}
			
			
		}
		out.close();	
	}
	
	static void sort(int [] a) {
		List<Integer> l=new ArrayList<>();
		for(int i: a) l.add(i);
		Collections.sort(l);
		for(int i=0; i<a.length; i++) a[i]=l.get(i);
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
			for(int i=0; i<n; i++) a[i]=nextInt();
			return a;
		}
	}	
	
	static int mod=(int)1e9+7;
}
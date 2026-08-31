//Author: net12k44
import java.io.*;
import java.util.*;
public
class Main{//}
	
static PrintWriter out;


static void solve() {
	int n = in.nextInt() , c = in.nextInt();
	int a[] = new int[n];
	for(int i = 0; i < n; ++i) a[i] = in.nextInt();
	int kq = 0;
	for(int i = 0; i+1 < n; ++i)
	 kq = Math.max( kq  , a[i] - a[i+1] - c);
	out.println(kq);
	
	
	
}
	
public static void main (String[] args) throws java.lang.Exception {	
	
	long startTime = System.currentTimeMillis();

	out = new PrintWriter(System.out);
	solve();	
	//out.println((String.format("%.2f",(double)(System.currentTimeMillis()-startTime)/1000)));
	out.close();
	
	
}
	
static class in {
	static BufferedReader reader = new BufferedReader( new InputStreamReader(System.in) ) ;
	static StringTokenizer tokenizer = new StringTokenizer("");
			
		
	static String next() {
		
		while ( !tokenizer.hasMoreTokens() )
			try {
				tokenizer = new StringTokenizer( reader.readLine() );
			} catch (IOException e){
				throw new RuntimeException(e);			
			}
		
		return tokenizer.nextToken();
	}

	static int nextInt() {
		return Integer.parseInt( next() );
	}
		
	static double nextDouble(){
		return Double.parseDouble( next() );
	}
}
//////////////////////////////////////////////////
}//
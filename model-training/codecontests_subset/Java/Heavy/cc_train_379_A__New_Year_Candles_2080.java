import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class A {

	public static void main(String[] args) throws Exception{
		FastScanner sc = new FastScanner(System.in);
		int A = sc.nextInt();
		int B = sc.nextInt();
		long done = 0;
		while(A>=B){
			done+=B;
			A-=B;
			A++;
		}
		done+=A;
		System.out.println(done);
		
		
		
		
	}
	
	
	static class FastScanner {
		BufferedReader br;
		StringTokenizer st;
		
		public FastScanner(InputStream in) throws Exception{
			br = new BufferedReader(new InputStreamReader(in));
			st = new StringTokenizer(br.readLine().trim());
		}
		public int numTokens() throws Exception {
			if(!st.hasMoreTokens()){
				st = new StringTokenizer(br.readLine().trim());
				return numTokens();
			}
			return st.countTokens();
		}
		public boolean hasNext() throws Exception{
			if(!st.hasMoreTokens()){
				st = new StringTokenizer(br.readLine().trim());
				return hasNext();
			}
			return true;
		}
		public String next() throws Exception {
			if(!st.hasMoreTokens()){
				st = new StringTokenizer(br.readLine().trim());
				return next();
			}
			return st.nextToken();
		}
		public double nextDouble() throws Exception{
			return Double.parseDouble(next());
		}
		public float nextFloat() throws Exception{
			return Float.parseFloat(next());
		}
		public long nextLong() throws Exception{
			return Long.parseLong(next());
		}
		public int nextInt() throws Exception{
			return Integer.parseInt(next());
		}
		public String nextLine() throws Exception{
			return br.readLine().trim();
		}
	}


}

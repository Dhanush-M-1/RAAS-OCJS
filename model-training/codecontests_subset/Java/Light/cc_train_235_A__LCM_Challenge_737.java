import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.StringTokenizer;


public class codeforces {
	static PrintWriter out;
	public static void main(String[] args) {
		MyScanner scan = new MyScanner();
		out = new PrintWriter(System.out);
		
		long a = scan.nextLong();
		if(a==1||a==2){
			System.out.println(a);
			return;
		}
		long sol = Math.max(solve(a), solve(a-1));
		out.println(sol);
		out.close();
	}
	private static long solve(long a) {
		long sol = a*(a-1);
		long aa = a*(a-1);
		for(long i=a;i>=1;i--){
			sol = Math.max(sol, aa*i/gcd(aa,i));
		}
		return sol;
	}
	private static long gcd(long a, long b){
		return (b==0)?a:gcd(b,a%b);
	}
	private static class MyScanner {
		BufferedReader br;
		StringTokenizer st;
		public MyScanner() {br = new BufferedReader(new InputStreamReader(System.in));}
		String next(){
			while(st==null||!st.hasMoreElements()){
				try{st = new StringTokenizer(br.readLine());}
				catch(IOException e){e.printStackTrace();}
			}return st.nextToken();
		}
		int nextInt() {return Integer.parseInt(next());}
		long nextLong(){return Long.parseLong(next());}
		double nextDouble(){return Double.parseDouble(next());}
	}
}

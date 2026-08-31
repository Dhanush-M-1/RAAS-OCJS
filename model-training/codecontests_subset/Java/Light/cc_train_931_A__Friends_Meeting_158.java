import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class codeforces {
	public static void main(String[] args) {
		FS scan = new FS(System.in);
		int a = scan.nextInt(), b = scan.nextInt();
		
		if(a > b) a = a^b^(b=a);
		long best = (long)1e18;
		for(int i=a;i<=b;i++){
			long sol = (i-a)*(i-a+1)/2 + (b-i)*(b-i+1)/2;
			best = Math.min(best, sol);
		}
		
		System.out.println(best);
	}
	private static class FS {
		BufferedReader br;
		StringTokenizer st;
		public FS(InputStream in) {
			br = new BufferedReader(new InputStreamReader(in));
		}
		String next(){
			while(st==null||!st.hasMoreElements()){
				try{st = new StringTokenizer(br.readLine());}
				catch(IOException e){e.printStackTrace();}
			}
			return st.nextToken();
		}
		int nextInt() {return Integer.parseInt(next());}
		long nextLong() {return Long.parseLong(next());}
		double nextDouble() { return Double.parseDouble(next());}
	}
}

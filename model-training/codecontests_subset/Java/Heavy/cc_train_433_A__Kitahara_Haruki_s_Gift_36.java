import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Main {

	/**
	 * @param args
	 */
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		InputReader in = new InputReader(System.in);
		PrintWriter out = new PrintWriter(System.out);
		//int T = in.nextInt();
		solve(1,in,out);
		out.flush();

	}

	private static void solve(int testCases, InputReader in, PrintWriter out) {
		// TODO Auto-generated method stub
		int n = in.nextInt();
		int count  = 0;
		for(int i = 0 ; i < n ; i++){
			int k = in.nextInt();
			if(k==100){
				count++;
			}
		}
		if(n==1){
			out.println("NO");
			return;
		}else if(count==0 && n%2==1){
			out.println("NO");
			return;
		}
		if(count%2==0){
			out.println("YES");
		}else{
			out.println("NO");
		}
	}


}

class InputReader {
	BufferedReader br ;
	StringTokenizer tokenizer;

	public InputReader(InputStream reader){
		br = new BufferedReader(new InputStreamReader(reader));
		tokenizer=null;
	}

	public String next(){
		while(tokenizer==null||!tokenizer.hasMoreTokens()){
			try {
				tokenizer = new StringTokenizer(br.readLine());
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return tokenizer.nextToken();
	}

	public int nextInt(){
		return Integer.parseInt(next());
	}

	public double nextDouble(){
		return Double.parseDouble(next());
	}

	public long nextLong(){
		return Long.parseLong(next());
	}
}

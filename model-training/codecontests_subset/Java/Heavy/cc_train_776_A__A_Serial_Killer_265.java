import java.util.*;
import java.io.*;
public class a{
	static InputReader in = new InputReader(System.in);
	static PrintWriter out = new PrintWriter(System.out);
	
	void solve(){
		String a = in.next();
		String b = in.next();
		int n = in.nextInt();
		out.printf("%s %s\n", a, b);
		for(int i=0; i<n; i++){
			String x = in.next(), y = in.next();
			if(x.equals(a)) a = y;
			else b = y;
			out.printf("%s %s\n", a, b);
		}
	}

	public static void main(String[] args){
		a m = new a();
		m.solve();
		out.flush();
		out.close();
	}
	static class InputReader{
		public BufferedReader reader;
		public StringTokenizer tokenizer;
		public InputReader(InputStream instream){
			reader = new BufferedReader(new InputStreamReader(instream), 1<<15);
			tokenizer = null;
		}
		public String next(){
			while(tokenizer == null || !tokenizer.hasMoreTokens()){
				try{
					tokenizer = new StringTokenizer(reader.readLine());
				}catch(Exception e){
					throw new RuntimeException(e);
				}
			}
			return tokenizer.nextToken();	
		}
		public String nextLine(){
			try{
			return reader.readLine();
			}catch(Exception e){
				throw new RuntimeException(e);
			}
		}
		public int nextInt(){
			return Integer.parseInt(next());
		}
		public long nextLong(){
			return Long.parseLong(next());
		}
		public double nextDouble(){
			return Double.parseDouble(next());
		}


	}
}

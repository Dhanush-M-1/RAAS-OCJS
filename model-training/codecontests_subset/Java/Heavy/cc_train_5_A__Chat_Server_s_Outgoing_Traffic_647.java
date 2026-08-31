import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;
	
	public class A {
		
		
		public static void main(String[] args) throws Exception{
			Scanner sc = new Scanner(System.in);
			PrintWriter out = new PrintWriter(System.out);
			int count = 0, ans = 0;
			while(sc.ready())
			{
				StringTokenizer st = new StringTokenizer(sc.nextLine(), ":");
				String n = st.nextToken();
				if(n.charAt(0) == '+') count++;
				else if(n.charAt(0) == '-') count--;
				else if(st.countTokens() == 1)
					ans += st.nextToken().length() * count;
			}
			out.println(ans);
			out.flush();
		}

		static class Scanner 
		{
			StringTokenizer st;
			BufferedReader br;
	
			public Scanner(InputStream System){	br = new BufferedReader(new InputStreamReader(System));}
			public String next() throws IOException 
			{
				while (st == null || !st.hasMoreTokens()) 
					st = new StringTokenizer(br.readLine());
				return st.nextToken();
			}
			public String nextLine()throws IOException{return br.readLine();}
			public int nextInt() throws IOException {return Integer.parseInt(next());}
			public double nextDouble() throws IOException {return Double.parseDouble(next());}
			public char nextChar()throws IOException{return next().charAt(0);}
			public Long nextLong()throws IOException{return Long.parseLong(next());}
			public boolean ready() throws IOException{return br.ready();}
			public void waitForInput(){for(long i = 0; i < 3e9; i++);}
		}
	}
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;
	
	public class A {
		
		static int n, a[];
		
		public static void main(String[] args) throws Exception{
			Scanner sc = new Scanner(System.in);
			PrintWriter out = new PrintWriter(System.out);
			String s1 = sc.next(), s2 = sc.next();
			int n = sc.nextInt();
			out.println(s1 + " " + s2);
			while(n --> 0)
			{
				String in1 = sc.next(), in2 = sc.next();
				if(in1.equals(s1))
					s1 = new String(in2);
				else if(in1.equals(s2))
					s2 = new String(in2);
				else if(in2.equals(s1))
					s1 = new String(in1);
				else
					s1 = new String(in2);
				out.println(s1 + " " + s2);
			}
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
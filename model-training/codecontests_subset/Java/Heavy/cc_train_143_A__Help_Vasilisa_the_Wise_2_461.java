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
			int[] a = new int[6];
			for(int i = 0; i < 6; i++) a[i] = sc.nextInt();
			boolean found = false;
			outer:
			for(int i = 1; i < 10; i++)
				for(int j = 1; j < 10; j++)
					if(i != j)
						for(int k = 1; k < 10; k++)
							if(k != j && k != i)
								for(int l = 1; l < 10; l++)
									if(l != k && l != j && l != i)
										if(i + j == a[0] && k + l == a[1] && i + k == a[2] 
										&& j + l == a[3] && i + l == a[4] && j + k == a[5])
										{
											found = true;
											out.println(i + " " + j);
											out.println(k + " " + l);
											break outer;
										}
			if(!found) out.println(-1);
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
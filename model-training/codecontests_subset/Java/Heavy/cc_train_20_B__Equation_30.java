import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);

		int A = sc.nextInt(), B = sc.nextInt(), C = sc.nextInt();
		if(A == 0 && B == 0)
			out.println(C == 0 ? -1 : 0);
		else if(A == 0)
		{
			out.println(1);
			out.printf("%.5f\n", 1.0 * -C / B);
		}
		else
		{
			long dis = 1l * B * B - 4l * A * C;
			if(dis < 0)
				out.println(0);
			else if(dis == 0)
			{
				out.println(1);
				out.printf("%.5f\n", -B / (2.0 * A));
			}
			else
			{
				out.println(2);
				if(A > 0)
				{
					out.printf("%.5f\n", (-B - Math.sqrt(dis)) / (2.0 * A));
					out.printf("%.5f\n", (-B + Math.sqrt(dis)) / (2.0 * A));
				}
				else
				{
					out.printf("%.5f\n", (-B + Math.sqrt(dis)) / (2.0 * A));
					out.printf("%.5f\n", (-B - Math.sqrt(dis)) / (2.0 * A));
				}
			}
			
		}
		out.flush();
		out.close();
	}

	static class Scanner 
	{
		StringTokenizer st;
		BufferedReader br;

		public Scanner(InputStream s){	br = new BufferedReader(new InputStreamReader(s));}

		public String next() throws IOException 
		{
			while (st == null || !st.hasMoreTokens()) 
				st = new StringTokenizer(br.readLine());
			return st.nextToken();
		}

		public int nextInt() throws IOException {return Integer.parseInt(next());}

		public long nextLong() throws IOException {return Long.parseLong(next());}

		public String nextLine() throws IOException {return br.readLine();}

		public double nextDouble() throws IOException { return Double.parseDouble(next()); }

		public boolean ready() throws IOException {return br.ready();} 
	}
} 
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class A
{
	static PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));
	static MyScanner sc = new MyScanner(System.in);
	
	public static void main(String... args)
	{
		String[] victims = {sc.next(), sc.next()};
		int n = sc.nextInt();
		
		System.out.printf("%s %s%n", victims[0], victims[1]);
		for (int i = 0; i < n; i++)
		{
			String kill = sc.next();
			String next = sc.next();
			if (victims[0].equals(kill))
			{
				victims[0] = next;
			}
			else
			{
				victims[1] = next;
			}
			
			System.out.printf("%s %s%n", victims[0], victims[1]);
		}
	}
	
	/**
	 * Flatfoot's Scanner with slight modifications.
	 * @author <a href="http://codeforces.com/profile/Flatfoot">Flatfoot</a>
	 * @see <a href="http://codeforces.com/blog/entry/7018">Source</a> 
	 */
	private static class MyScanner
	{
		BufferedReader br;
		StringTokenizer st;
		
		MyScanner(InputStream in)
		{
			this.br = new BufferedReader(new InputStreamReader(in));
		}
		
		String next()
		{
			while (this.st == null || !this.st.hasMoreElements())
			{
				try
				{
					this.st = new StringTokenizer(this.br.readLine());
				}
				catch (IOException e)
				{
					e.printStackTrace();
				}
			}
			return this.st.nextToken();
		}
		
		int nextInt()
		{
			return Integer.parseInt(this.next());
		}
		
		long nextLong()
		{
			return Long.parseLong(this.next());
		}
		
		double nextDouble()
		{
			return Double.parseDouble(this.next());
		}
		
		String nextLine()
		{
			String str = "";
			try
			{
				str = this.br.readLine();
			}
			catch (IOException e)
			{
				e.printStackTrace();
			}
			return str;
		}
		
	}
}

import java.util.*;
import java.io.*;
public class WeaknessAndPoorness
{
	public static void main(String[] args) throws Exception
	{
		FastScanner in = new FastScanner(System.in);
		
		int n = in.nextInt();
		
		int[] array = new int[n];
		for(int x = 0; x < n; x++)
		{
			array[x] = in.nextInt();
		}
		
		double low = -10000;
		double high = 10000;
		for(int i = 0; i < 100; i++)
		{
			double mid1 = (low + low + high) / 3;
			double mid2 = (low + high + high) / 3;
			
			if(calc(array, mid1) < calc(array, mid2))
			{
				high = mid2;
			}
			else
			{
				low = mid1;
			}
		}
		
		System.out.println(calc(array, low));
	}
	
	public static double calc(int[] array, double mid)
	{
		return Math.max(poorness(array, mid, 1), poorness(array, mid, -1));
	}
	
	public static double poorness(int[] array, double x, double s)
	{
		double ret = 0;
		double current = 0;
		for(int i = 0; i < array.length; i++)
		{
			current = Math.max(0, current + s * (array[i] - x));
			ret = Math.max(ret, current);
		}
		
		return ret;
	}
	
	static class FastScanner
	{
		BufferedReader br;
		StringTokenizer st;
		
		public FastScanner(InputStream input)
		{
			br = new BufferedReader(new InputStreamReader(input));
			st = new StringTokenizer("");
		}
		
		public String next() throws IOException
		{
			if(st.hasMoreTokens())
			{
				return st.nextToken();
			}
			else
			{
				st = new StringTokenizer(br.readLine());
				return next();
			}
		}
		
		public int nextInt() throws IOException
		{
			return Integer.parseInt(next());
		}
	}
}

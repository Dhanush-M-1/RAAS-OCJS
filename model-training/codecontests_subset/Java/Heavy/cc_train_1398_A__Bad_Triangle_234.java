

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;



public class experiments
{
	public static void main(String args[]) throws IOException
	{
		
		FastScanner fs = new FastScanner();
		int T = fs.nextInt();
		outer :while(T-->0)
		{
			int n =fs.nextInt();
			int arr[] = fs.arrayIn(n);
			int sum = arr[0]+arr[1];
			
			for(int i=2; i<n; i++)
			{
				if(sum<=arr[i])
				{
					System.out.println("1 2 "+(i+1));
					continue outer;
				}
			}
			System.out.println(-1);
		}
	}

	
}
class FastScanner
{
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	StringTokenizer str = new StringTokenizer("");
	
	String next() throws IOException
	{
		while(!str.hasMoreTokens())
			str = new StringTokenizer(br.readLine());
		
		return str.nextToken();
	}
	
	char nextChar() throws IOException {
		return next().charAt(0);
	}

	int nextInt() throws IOException
	{
		return Integer.parseInt(next());
	}
	
	float nextfloat() throws IOException
	{
		return Float.parseFloat(next());
	}
	
	double nextDouble() throws IOException
	{
		return Double.parseDouble(next());
	}
	long nextLong() throws IOException
	{
		return Long.parseLong(next());
	}
	byte nextByte() throws IOException 
	{
		return Byte.parseByte(next());
	}
	int [] arrayIn(int n) throws IOException
	{
		int  arr[] = new int[n];
		for(int i=0; i<n; i++)
		{
			arr[i] = nextInt();
		}
		return arr;
	}
}



	
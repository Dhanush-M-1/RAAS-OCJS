import java.util.*;
import java.io.*;
public class FactoryRepairs
{
	public static void main(String[] args) throws Exception
	{
		FastScanner in = new FastScanner(System.in);
		PrintWriter out = new PrintWriter(System.out);
		
		int n = in.nextInt();
		int k = in.nextInt();
		int a = in.nextInt();
		int b = in.nextInt();
		int q = in.nextInt();
		
		int[] arrayb = new int[n];
		int[] arraya = new int[n];
		BinaryIndexedTree bitb = new BinaryIndexedTree(n);
		BinaryIndexedTree bita = new BinaryIndexedTree(n);
		for(int x = 0; x < q; x++)
		{
			int type = in.nextInt();
			
			if(type == 1)
			{
				int d = in.nextInt() - 1;
				int y = in.nextInt();
				
				int updateB = Math.min(b, arrayb[d] + y) - arrayb[d];
				int updateA = Math.min(a, arraya[d] + y) - arraya[d];
				
				arrayb[d] += updateB;
				arraya[d] += updateA;
				
				bitb.update(d, updateB);
				bita.update(d, updateA);
			}
			else
			{
				int p = in.nextInt() - 1;
				
				int result = bitb.read(0, p - 1);
				if(p + k < n)
				{
					result += bita.read(p + k, n - 1);
				}
				
				out.println(result);
			}
		}
		
		out.close();
	}
	
	static class BinaryIndexedTree 
	{
		int[] tree;
		
		public BinaryIndexedTree(int n)
		{
			tree = new int[n + 1];
		}
		
		public int read(int idx)
		{
			idx++;
			int sum = 0;
			while(idx > 0)
			{
				sum += tree[idx];
				idx -= (idx & -idx);
			}
			
			return sum;
		}
		
		public int read(int low, int high)
		{
			return read(high) - read(low - 1);
		}
		
		public void update(int idx, int val)
		{
			idx++;
			while(idx < tree.length)
			{
				tree[idx] += val;
				idx += (idx & -idx);
			}
		}
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

import java.util.Scanner;
import java.io.*;
import java.util.*;
import java.math.*;
import static java.lang.Math.*;
 
public class M
{	
	static class InputReader
	{
		private InputStream stream;
		private byte[] buf = new byte[1024];
		private int curChar;
		private int numChars;
		private SpaceCharFilter filter;
		
		public InputReader(InputStream stream)
		{
			this.stream = stream;
		}
		
		public int read()
		{
			if (numChars==-1) 
				throw new InputMismatchException();
			
			if (curChar >= numChars)
			{
				curChar = 0;
				try 
				{
					numChars = stream.read(buf);
				}
				catch (IOException e)
				{
					throw new InputMismatchException();
				}
				
				if(numChars <= 0)				
					return -1;
			}
			return buf[curChar++];
		}
	 
		public String nextLine()
		{
			BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
			String str = "";
            try
            {
                str = br.readLine();
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
            return str;
		}
		public int nextInt()
		{
			int c = read();
			
			while(isSpaceChar(c)) 
				c = read();
			
			int sgn = 1;
			
			if (c == '-') 
			{
				sgn = -1;
				c = read();
			}
			
			int res = 0;
			do 
			{
				if(c<'0'||c>'9') 
					throw new InputMismatchException();
				res *= 10;
				res += c - '0';
				c = read();
			}
			while (!isSpaceChar(c)); 
			
			return res * sgn;
		}
		
		public long nextLong() 
		{
			int c = read();
			while (isSpaceChar(c))
				c = read();
			int sgn = 1;
			if (c == '-') 
			{
				sgn = -1;
				c = read();
			}
			long res = 0;
			
			do 
			{
				if (c < '0' || c > '9')
					throw new InputMismatchException();
				res *= 10;
				res += c - '0';
				c = read();
			}
			while (!isSpaceChar(c));
				return res * sgn;
		}
		
		public double nextDouble() 
		{
			int c = read();
			while (isSpaceChar(c))
				c = read();
			int sgn = 1;
			if (c == '-') 
			{
				sgn = -1;
				c = read();
			}
			double res = 0;
			while (!isSpaceChar(c) && c != '.') 
			{
				if (c == 'e' || c == 'E')
					return res * Math.pow(10, nextInt());
				if (c < '0' || c > '9')
					throw new InputMismatchException();
				res *= 10;
				res += c - '0';
				c = read();
			}
			if (c == '.') 
			{
				c = read();
				double m = 1;
				while (!isSpaceChar(c)) 
				{
					if (c == 'e' || c == 'E')
						return res * Math.pow(10, nextInt());
					if (c < '0' || c > '9')
						throw new InputMismatchException();
					m /= 10;
					res += (c - '0') * m;
					c = read();
				}
			}
			return res * sgn;
		}
		
		public String readString() 
		{
			int c = read();
			while (isSpaceChar(c))
				c = read();
			StringBuilder res = new StringBuilder();
			do 
			{
				res.appendCodePoint(c);
				c = read();
			} 
			while (!isSpaceChar(c));
			
			return res.toString();
		}
	 
		public boolean isSpaceChar(int c) 
		{
			if (filter != null)
				return filter.isSpaceChar(c);
			return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
		}
	 
		public String next() 
		{
			return readString();
		}
		
		public interface SpaceCharFilter 
		{
			public boolean isSpaceChar(int ch);
		}
	}
	
	static class Node implements Comparable<Node>
	{
		int value;
		int id;
		
		public Node(int value,int id)
		{
			this.value=value;
			this.id=id;
		}
		
		public int compareTo(Node node)
		{
			if(value<node.value)
				return 1;
			
			if(value>node.value)
				return -1;
			
			if(id<node.id)
				return 1;
			
			return -1;
		}
	}
	
	public static void updateBinaryIndexedTree(int binaryIndexedTree[], int val, int index)
	{
		if(val%2 != 1)
		{
			while(val%2 != 1)
			{
				val /= 2;
			}
		}
		
        while(index < binaryIndexedTree.length)
		{
            binaryIndexedTree[index] ^= val;
            index = getNext(index);
        }
    }
    
    public static int getSum(int binaryIndexedTree[], int index)
	{
        index = index + 1;
        int sum = 0;
		
        while(index > 0)
		{
            sum ^= binaryIndexedTree[index];
            index = getParent(index);
        }
        return sum;
    }
    
    public static int[] createTree(int input[])
	{
        int binaryIndexedTree[] = new int[input.length+10];
		
        for(int i=1; i <= input.length; i++)
		{
            updateBinaryIndexedTree(binaryIndexedTree, input[i-1], i);
        }
        return binaryIndexedTree;
    }
    
    public static int getParent(int index)
	{
        return index - (index & -index);
    }
    
    public static int getNext(int index)
	{
        return index + (index & -index);
    }
	
	public static int LongestIncreasingSubSequence(int arr[] , int n)
	{
		int L[] = new int[n];
		
		Arrays.fill(L , 1);
		
		for(int i = 1 ; i < n ; i++)
		{
			for(int j = 0 ; j < i ; j++)
			{
				if(arr[i] > arr[j] && L[i] < (L[j]+1))
					L[i] = L[j] + 1;
			}
		}
		return L[n-1];
	}
	
	public static void main(String args[]) throws Exception
	{	
		InputReader In = new InputReader(System.in);
		PrintWriter w = new PrintWriter(System.out);
				
		String a = In.next();
		String b = In.next();
		
		int n = In.nextInt();
		//In.nextLine();
				
		String S[] = new String[n];
		String T[] = new String[n];
		
		for(int i = 0 ; i < n ; i++)
		{
			S[i] = In.next();
			T[i] = In.next();
		}
		
		w.println(a + " " + b);
		
		if(S[0].equals(a))
		{
			S[0] = b;
		}
		else
		{
			S[0] = a;
		}
		
		w.println(S[0] + " " + T[0]);
		
		for(int i = 1 ; i < n ; i++)
		{
			if(S[i].equals(S[i-1]))
			{
				S[i] = T[i-1];
			}
			else
			{
				S[i] = S[i-1];
			}
			
			w.println(S[i] + " " + T[i]);
		}
		
		//w.println(ans);
		
		w.close();
	}
}
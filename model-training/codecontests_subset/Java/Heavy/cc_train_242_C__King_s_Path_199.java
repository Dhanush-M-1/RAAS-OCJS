
import java.io.*;
import java.math.*;
import java.util.*;

import static java.util.Arrays.fill;
import static java.lang.Math.*;
import static java.util.Arrays.sort;
import static java.util.Collections.sort;


public class C242 
{

	public static long mod = 1000000007;
	public static long INF = (1L << 60);
	static FastScanner2 in = new FastScanner2();
	static OutputWriter out = new OutputWriter(System.out);
	static class Point
	{
		int x,y;
		Point(int x,int y)
		{
			this.x=x;
			this.y=y;
		}
		@Override
		public int hashCode() 
		{
			final int prime = 31;
			int result = 1;
			result = prime * result + x;
			result = prime * result + y;
			return result;
		}
		@Override
		public boolean equals(Object obj) 
		{
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Point other = (Point) obj;
			if (x != other.x)
				return false;
			if (y != other.y)
				return false;
			return true;
		}
	}
	static class Pair
	{
		Point point;
		int dist;
		Pair(Point point,int dist)
		{
			this.point=point;
			this.dist=dist;
		}
	}
	static int[] dx={0,-1,1,-1,1,-1,0,1};
	static int[] dy={-1,-1,-1,0,0,1,1,1};
	public static void main(String[] args) 
	{

		int x0=in.nextInt();
		int y0=in.nextInt();
		int x1=in.nextInt();
		int y1=in.nextInt();
		int n=in.nextInt();
		Map<Point, Integer> map=new HashMap<>();
		Map<Point, Boolean> visited=new HashMap<>();
		for(int i=1;i<=n;i++)
		{
			int row=in.nextInt();
			int c1=in.nextInt();
			int c2=in.nextInt();
			for(int j=c1;j<=c2;j++)
			{
				map.put(new Point(row, j), 1);
			}
		}
		Queue<Pair> q=new LinkedList<>();
		visited.put(new Point(x0, y0), true);
		q.add(new Pair(new Point(x0, y0), 0));
		int answer=-1;
		while(!q.isEmpty())
		{
			Pair p=q.poll();
			Point pt=p.point;
			int dist=p.dist;
			if(pt.x==x1&&pt.y==y1)
			{
				answer=dist;
				break;
			}
			for(int i=0;i<8;i++)
			{
				if(map.containsKey(new Point(pt.x+dx[i], pt.y+dy[i]))&&!visited.containsKey(new Point(pt.x+dx[i], pt.y+dy[i])))
				{
					visited.put(new Point(pt.x+dx[i], pt.y+dy[i]), true);
					q.add(new Pair(new Point(pt.x+dx[i], pt.y+dy[i]), dist+1));
				}
			}
		}
		out.println(answer);
		out.close();

	}
	
	public static long pow(long x, long n) 
	{
		long res = 1;
		for (long p = x; n > 0; n >>= 1, p = (p * p)) 
		{
			if ((n & 1) != 0) 
			{
				res = (res * p);
			}
		}
		return res;
	}
	
	public static long pow(long x, long n, long mod) 
	{
		long res = 1;
		for (long p = x; n > 0; n >>= 1, p = (p * p) % mod) 
		{
			if ((n & 1) != 0) 
			{
				res = (res * p % mod);
			}
		}
		return res;
	}

	public static long gcd(long n1, long n2)
	{
		long r;
		while (n2 != 0) 
		{
			r = n1 % n2;
			n1 = n2;
			n2 = r;
		}
		return n1;
	}

	public static long lcm(long n1, long n2) 
	{
		long answer = (n1 * n2) / (gcd(n1, n2));
		return answer;
	}

	static class FastScanner2 
	{
		private byte[] buf = new byte[1024];
		private int curChar;
		private int snumChars;

		public int read() 
		{
			if (snumChars == -1)
				throw new InputMismatchException();
			if (curChar >= snumChars) 
			{
				curChar = 0;
				try 
				{
					snumChars = System.in.read(buf);
				} catch (IOException e) 
				{
					throw new InputMismatchException();
				}
				if (snumChars <= 0)
					return -1;
			}
			return buf[curChar++];
		}

		public String nextLine() 
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
			while (!isEndOfLine(c));
			return res.toString();
		}

		public String nextString() 
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

		public long nextLong()
		{
			int c = read();
			while (isSpaceChar(c))
				c = read();
			int sgn = 1;
			if (c == '-') {
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

		public int nextInt() 
		{
			int c = read();
			while (isSpaceChar(c))
				c = read();
			int sgn = 1;
			if (c == '-') {
				sgn = -1;
				c = read();
			}
			int res = 0;
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

		public int[] nextIntArray(int n)
		{
			int[] arr = new int[n];
			for (int i = 0; i < n; i++) 
			{
				arr[i] = nextInt();
			}
			return arr;
		}

		public long[] nextLongArray(int n)
		{
			long[] arr = new long[n];
			for (int i = 0; i < n; i++) 
			{
				arr[i] = nextLong();
			}
			return arr;
		}

		private boolean isSpaceChar(int c)
		{
			return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
		}

		private boolean isEndOfLine(int c) 
		{
			return c == '\n' || c == '\r' || c == -1;
		}
	}

	static class InputReader 
	{
		public BufferedReader reader;
		public StringTokenizer tokenizer;

		public InputReader(InputStream inputstream) 
		{
			reader = new BufferedReader(new InputStreamReader(inputstream));
			tokenizer = null;
		}

		public String nextLine() 
		{
			String fullLine = null;
			while (tokenizer == null || !tokenizer.hasMoreTokens())
			{
				try 
				{
					fullLine = reader.readLine();
				} catch (IOException e)
				{
					throw new RuntimeException(e);
				}
				return fullLine;
			}
			return fullLine;
		}

		public String next()
		{
			while (tokenizer == null || !tokenizer.hasMoreTokens()) 
			{
				try 
				{
					tokenizer = new StringTokenizer(reader.readLine());
				} catch (IOException e) 
				{
					throw new RuntimeException(e);
				}
			}
			return tokenizer.nextToken();
		}

		public long nextLong() 
		{
			return Long.parseLong(next());
		}

		public int[] nextIntArray(int n) 
		{
			int a[] = new int[n];
			for (int i = 0; i < n; i++) 
			{
				a[i] = nextInt();
			}
			return a;
		}

		public long[] nextLongArray(int n)
		{
			long a[] = new long[n];
			for (int i = 0; i < n; i++) 
			{
				a[i] = nextLong();
			}
			return a;
		}

		public int nextInt() 
		{
			return Integer.parseInt(next());
		}
	}

	static class OutputWriter 
	{
		private final PrintWriter writer;

		public OutputWriter(OutputStream outputStream) 
		{
			writer = new PrintWriter(new BufferedWriter(new OutputStreamWriter(outputStream)));
		}

		public OutputWriter(Writer writer)
		{
			this.writer = new PrintWriter(writer);
		}

		public void print(Object... objects)
		{
			for (int i = 0; i < objects.length; i++) 
			{
				if (i != 0)
					writer.print(' ');
				writer.print(objects[i]);
			}
		}

		public void println(Object... objects)
		{
			print(objects);
			writer.println();
		}

		public void close() 
		{
			writer.close();
		}

		public void flush() 
		{
			writer.flush();
		}
	}

}
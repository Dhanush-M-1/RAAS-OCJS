//package codeforcesround350;
import java.io.*;
import java.util.*;
public class q2 {
	static InputReader in;
	public static void main(String[] args) throws Exception
	{
		in=new InputReader(System.in);
		PrintWriter pw=new PrintWriter(System.out);
		int n=in.nextInt();
		int k=in.nextInt();
		long[] a=readlong(n);
		long[] num=new long[n];
		num[0]=1;
		for(int i=1;i<n;i++)
		{
			num[i]=num[i-1]+(i)+1;
		}
		//for(int i=0;i<n;i++)
		//{
			
			//pw.println(num[i]);
		//}
		int min=0;
		for(int i=0;i<n;i++)
		{
			if(k>min && k<=num[i])
			{
				int ind=k-min-1;
				pw.println(a[ind]);
				break;
			}
			min=(int)num[i];
		}
		
		
		pw.close();
	}
	public static long[] readlong(int n)
	{
		long[] a=new long[n];
		for(int i=0;i<n;i++)
		{
			a[i]=in.nextLong();
		}
		return a;
	}
	public static int[] readint(int n)
	{
		int[] a=new int[n];
		for(int i=0;i<n;i++)
		{
			a[i]=in.nextInt();
		}
		return a;
	}
	
	
	
	
	
	
	
	
	
	 static class InputReader {

		private InputStream stream;
		private byte[] buf = new byte[8192];
		private int curChar;
		private int snumChars;
		private SpaceCharFilter filter;

		public InputReader(InputStream stream) {
			this.stream = stream;
		}

		public int snext() {
			if (snumChars == -1)
				throw new InputMismatchException();
			if (curChar >= snumChars) {
				curChar = 0;
				try {
					snumChars = stream.read(buf);
				} catch (IOException e) {
					throw new InputMismatchException();
				}
				if (snumChars <= 0)
					return -1;
			}
			return buf[curChar++];
		}

		public int nextInt() {
			int c = snext();
			while (isSpaceChar(c))
				c = snext();
			int sgn = 1;
			if (c == '-') {
				sgn = -1;
				c = snext();
			}

			int res = 0;

			do {
				if (c < '0' || c > '9')
					throw new InputMismatchException();
				res *= 10;
				res += c - '0';
				c = snext();
			} while (!isSpaceChar(c));

			return res * sgn;
		}
		
		public long nextLong() {
			int c = snext();
			while (isSpaceChar(c))
				c = snext();
			int sgn = 1;
			if (c == '-') {
				sgn = -1;
				c = snext();
			}

			long res = 0;

			do {
				if (c < '0' || c > '9')
					throw new InputMismatchException();
				res *= 10;
				res += c - '0';
				c = snext();
			} while (!isSpaceChar(c));

			return res * sgn;
		}
		
		public String readString() {
			int c = snext();
			while (isSpaceChar(c))
				c = snext();
			StringBuilder res = new StringBuilder();
			do {
				res.appendCodePoint(c);
				c = snext();
			} while (!isSpaceChar(c));
			return res.toString();
		}

		public boolean isSpaceChar(int c) {
			if (filter != null)
				return filter.isSpaceChar(c);
			return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
		}

		public interface SpaceCharFilter {
			public boolean isSpaceChar(int ch);
		}
	}

}


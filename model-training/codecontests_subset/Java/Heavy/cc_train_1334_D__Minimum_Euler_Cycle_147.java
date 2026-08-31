import java.util.*;
import java.io.*;
import java.math.*;
public class Main9
{
	static class Pair
	{
		int x;
		int y;
		Pair(int x,int y)
		{
			this.x=x;
			this.y=y;
		}
	}
	static int mod=1000000007;
	public static int[] sort(int[] a)
	{
		int n=a.length;
		ArrayList<Integer> ar=new ArrayList<>();
		for(int i=0;i<a.length;i++)
		{
			ar.add(a[i]);
		}
		Collections.sort(ar);
		for(int i=0;i<n;i++)
		{
			a[i]=ar.get(i);
		}
		return a;
	}
	public static long pow(long a, long b)
    {
        long result=1;
        while(b>0)
        {
            if (b % 2 != 0)
            {
                result=(result*a)%mod;
                b--;
            } 
            a=(a*a)%mod;
            b /= 2;
        }   
        return result;
    }
	
    public static long gcd(long a, long b)
    {
        if (a == 0)
            return b;
        return gcd(b%a, a);
    }   
	public static long lcm(long a, long b)
	{
		return a*(b/gcd(a,b));
	}
	static ArrayList<ArrayList<Integer>> graph;
	static public void main(String args[])throws IOException
	{
		int tt=i();
		StringBuilder sb1=new StringBuilder();
		for(int ttt=1;ttt<=tt;ttt++)
		{
			long n=l();
			long l=l();
			long r=l();
			long edges=(n*((long)n-1))/2;
			long sum=0;
			long prev=0;
			long index=-1;
			for(long i=n;i>=1;i--)
			{
				sum=sum+(i-1)*2;
				if(sum>=l)
				{
					index=i;
					break;
				}
				prev=sum;
			}
			StringBuilder sb=new StringBuilder();
			if(index==-1)
			{
				sb.append("1\n");
				sb1.append(sb.toString());
			}
			else{
			int flag=0;
			long rem=n-index;
			long starting=rem+1;
			long fin_starting=starting;
			long pp=0;
			long count=0;
			long extraL=l-prev;
			if(extraL%2==0)
			{
				long num=extraL/2;
				starting=(long)(starting+num);
				sb.append(starting+" ");
				count++;
			}
			else
			{
				starting=starting;
			}
			long ans=r-l+1;
			long left=0;
			long right=0;
			if(fin_starting==starting)
			{
				long rr=extraL/2+1;
				long ww=fin_starting+rr;
				left=fin_starting;
				right=(int)ww;
			}
			else
			{
				left=fin_starting;
				right=starting+1;
			}
			right--;
			long tttt=right;
			long count1=count;
			while(count<ans && flag==0)
			{
				while(left<n)
				{
					right=tttt+1;
					while(right<=n && flag==0)
					{
						sb.append(left+" ");
						count++;
						if(count>=ans)
						{
							flag=1;
							break;
						}
						sb.append(right+" ");
						count++;
						if(count>=ans)
						{
							flag=1;
							break;
						}
						right++;
						
					}
					if(flag==1)
					{
						break;
					}
					left++;
					tttt=left;
				}
				if(flag==1)
					break;
				if(count1==count)
					break;
				count1=count;
			}
			if(count<ans)
			{
				sb.append("1");
				sb1.append(sb.toString()+"\n");
			}
			else
			{
				sb1.append(sb.toString()+"\n");
			}}
		}
		System.out.print(sb1.toString());
	}
			/**/
	static InputReader in=new InputReader(System.in);
	static OutputWriter out=new OutputWriter(System.out);
	public static long l()
	{
		String s=in.String();
		return Long.parseLong(s);
	}
	public static void pln(String value)
	{
		System.out.println(value);
	}
	public static int i()
	{
		return in.Int();
	}
	public static String s()
	{
		return in.String();
	}
}
	class InputReader 
	{
		private InputStream stream;
		private byte[] buf = new byte[1024];
		private int curChar;
		private int numChars;
		private SpaceCharFilter filter;
	 
		public InputReader(InputStream stream) {
			this.stream = stream;
		}
	 
		public int read() {
			if (numChars== -1)
				throw new InputMismatchException();
			if (curChar >= numChars) {
				curChar = 0;
				try {
					numChars = stream.read(buf);
				} catch (IOException e) {
					throw new InputMismatchException();
				}
				if (numChars <= 0)
					return -1;
			}
			return buf[curChar++];
		}
	 
		public int Int() {
			int c = read();
			while (isSpaceChar(c))
				c = read();
			int sgn = 1;
			if (c == '-') {
				sgn = -1;
				c = read();
			}
			int res = 0;
			do {
				if (c < '0' || c > '9')
					throw new InputMismatchException();
				res *= 10;
				res += c - '0';
				c = read();
			} while (!isSpaceChar(c));
			return res * sgn;
		}
	 
		public String String() {
			int c = read();
			while (isSpaceChar(c))
				c = read();
			StringBuilder res = new StringBuilder();
			do {
				res.appendCodePoint(c);
				c = read();
			} while (!isSpaceChar(c));
			return res.toString();
		}
	 
		public boolean isSpaceChar(int c) {
			if (filter != null)
				return filter.isSpaceChar(c);
			return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
		}
	 
		public String next() {
			return String();
		}
	 
		public interface SpaceCharFilter {
			public boolean isSpaceChar(int ch);
		}
	}
	 
	class OutputWriter {
		private final PrintWriter writer;
	 
		public OutputWriter(OutputStream outputStream) {
			writer = new PrintWriter(new BufferedWriter(new OutputStreamWriter(outputStream)));
		}
	 
		public OutputWriter(Writer writer) {
			this.writer = new PrintWriter(writer);
		}
	 
		public void print(Object...objects) {
			for (int i = 0; i < objects.length; i++) {
				if (i != 0)
					writer.print(' ');
				writer.print(objects[i]);
			}
		}
	 
		public void printLine(Object...objects) {
			print(objects);
			writer.println();
		}
	 
		public void close() {
			writer.close();
		}
	 
		public void flush() {
			writer.flush();
		}
	 
		}
	 
		class IOUtils {
	 
		public static int[] readIntArray(InputReader in, int size) {
			int[] array = new int[size];
			for (int i = 0; i < size; i++)
				array[i] = in.Int();
			return array;
		}
	 
	} 


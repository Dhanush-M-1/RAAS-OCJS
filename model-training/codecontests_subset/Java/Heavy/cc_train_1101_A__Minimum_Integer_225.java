import java.io.BufferedWriter;
	import java.io.IOException;
	import java.io.InputStream;
	import java.io.OutputStream;
	import java.io.OutputStreamWriter;
	import java.io.PrintWriter;
	import java.io.Writer;
	import java.util.Arrays;
	import java.util.InputMismatchException;
	import java.util.*;
	import java.io.*;
	import java.math.*;
public	 class Main{

	static class Pair
		{ 
			int x; 
			int y; 
			//int z;
			public Pair(int x, int y) 
			{	 
				this.x = x; 
				this.y = y; 
				
			}	 
		} 
		static class Compare
		{ 
			static void compare(Pair arr[], int n) 
			{ 
				// Comparator to sort the pair according to second element 
				Arrays.sort(arr, new Comparator<Pair>() { 
					@Override public int compare(Pair p1, Pair p2) 
					{ 
						return p1.y - p2.y; 
					} 
				}); 
			} 
		}
		public static long pow(long a, long b)
		{
			long result=1;
			while(b>0)
			{
				if (b % 2 != 0)
				{
					result=(result*a)%(mod);
					b--;
				} 
				a=(a*a)%(mod);
				b /= 2;
			}   
			return result;
		}
		public static long fact(long num)
		{
					long value=1;
					int i=0;
					for(i=2;i<num;i++)
					{
						value=((value%mod)*i%mod)%mod;
					}
					return value;
				}
				public static long gcd(long a, long b)
				{
					if (a == 0)
						return b;
					return gcd(b%a, a);
				}
				
				public static long lcm(int a,int b)
				{
					return a * (b / gcd(a, b));
				}
				public static long sum(int h)
				{
					return (h*(h+1)/2);
				}
				public static void dfs(int parent,boolean[] visited,int k)
				{
					ArrayList<Integer> arr=new ArrayList<Integer>();
					arr=graph.get(parent);
					visited[parent]=true;
					if(parent!=0)
					{
						fin[k]=parent;
						k+=2;
					}if(arr.size()==0)
						return;
					for(int i=0;i<arr.size();i++)
					{
						int num=arr.get(i);
						if(visited[num]==false)
						{
							dfs(num,visited,k);
						}
					}
				}
				public static void dfs1(int parent,boolean[] visited,int k)
				{
					ArrayList<Integer> arr=new ArrayList<Integer>();
					arr=graph.get(parent);
					visited[parent]=true;
					if(parent!=0)
					{
						fin[k]=parent;
						k-=2;
					}
					if(arr.size()==0)
						return;
					for(int i=0;i<arr.size();i++)
					{
						int num=arr.get(i);
						if(visited[num]==false)
						{
							dfs(num,visited,k);
						}
					}
				}
				static int[] fin;
			//	static int[] count;
				static int f=0;
				static char[] ch;
				static long mod=998244353L;
				static int[] b;
				static int[] a;
				static ArrayList<ArrayList<Integer>> graph;
				public static void main(String args[])throws IOException
				{
					InputReader in=new InputReader(System.in);
					OutputWriter out=new OutputWriter(System.out);
				//	long a=pow(26,1000000005);
				//    BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
					ArrayList<Integer> ar=new ArrayList<>();
					ArrayList<Integer> ar1=new ArrayList<>();
					ArrayList<Integer> ar2=new ArrayList<>();
					ArrayList<Integer> ar3=new ArrayList<>();
					ArrayList<Integer> ar4=new ArrayList<>();
					TreeSet<Integer> ts=new TreeSet<>();
					TreeSet<Integer> ts1=new TreeSet<>();
					TreeSet<String> pre=new TreeSet<>();
					HashMap<Integer,Integer> hash=new HashMap<>();
					HashMap<Long,Integer> hash1=new HashMap<Long,Integer>();
					HashMap<Long,Integer> hash2=new HashMap<Long,Integer>();
					Map<Integer, List<Integer>> hml = new HashMap<>(); 
				/*	boolean[] prime=new boolean[100001];
					for(int i=2;i*i<=100000;i++)
					{
						if(prime[i]==false)
						{
							for(int j=2*i;j<=100000;j+=i)
							{
								prime[j]=true;
							}
						}
					}*/
					int n=i();
					while(n-->0)
					{
					     int l=i();
					     int r=i();
					     int d=i();
					     if(d<l)
					     {
					          System.out.println(d);
					          continue;
					     }
					     else
					     {
					          int s=r/d;
					          System.out.println((s+1)*d);
					     }
					}
	
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
			 
			 
			 
			 
			 
			 
			 
			 
			 
			 
			 
			 
			 
			 
			 
			 
			 
			 
			 
			 
			 
			 
			class InputReader {
				 
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
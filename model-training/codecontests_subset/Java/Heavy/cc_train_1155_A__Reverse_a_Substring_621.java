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
	public class Main7{

	static class Pair
		{ 
			int x; 
			int y;
			int z;
			public Pair(int x, int y,int z) 
			{	 
				this.x = x; 
				this.y = y;
				this.z=z;
			}	 
		} 
		static class Pair1
		{
			String x;
			int y;
			int z;
			
		}
		static class Compare
		{ 
			static void compare(Pair arr[], int n) 
			{ 
				// Comparator to sort the pair according to second element 
				Arrays.sort(arr, new Comparator<Pair>() { 
					@Override public int compare(Pair p1, Pair p2) 
					{ 
						if(p1.x>p2.x)
						{
							return 1;
						}
						else if(p1.x<p2.x)
						{
							return -1;
						}
						else
						{
							return 0;
						} 
					} 
				}); 
			} 
		}
		
		static class pqcomparator implements Comparator<Pair>
		{
		                // for Ascending order of cgpa 
            public int compare(Pair s1, Pair s2) { 
                if (s1.x > s2.x) 
                    return -1; 
                else if (s1.x < s2.x) 
                    return 1; 
                return 0; 
                } 
        } 
		
		
		public static long pow(long a, long b)
		{
			long result=1;
			while(b>0)
			{
				if (b % 2 != 0)
				{
					result=(result*a);
					b--;
				} 
				a=(a*a);
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
		/*		public static void dfs(int parent,boolean[] visited)
				{
					visited[parent]=true;
					ArrayList<Integer> ar=graph.get(parent);
					for(int i=0;i<ar.size();i++)
					{
						int num=(int)ar.get(i);
						if(visited[num]==false)
						{
							dfs(num,visited);
						}
					}
				}
					
				
			//	static ArrayList<ArrayList<Integer>> graph;
				
				public static void bfs(int root,boolean[] visited)
				{
				Queue<Integer> q=new LinkedList<>();
				q.add(root);
				dis[root]=0;
				visited[root]=true;
				while(!q.isEmpty())
				{
					int x=q.poll();
					ArrayList<Integer> al=graph.get(x);
					for(int i=0;i<al.size();i++)
					{
						int y=al.get(i);	
						if(visited[y]==false)
						{
							q.add(y);
							dis[y]=dis[x]+1;
							visited[y]=true;
						}
					}
				}
				}
				*/
				static int flag1=0;
				static int[] dis;
				static long mod=1000000007L;
				
				public static long[] sort(long[] a)
				{
					int n=a.length;
					ArrayList<Long> ar=new ArrayList<Long>();
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
				public static int[] sort(int[] a)
				{
					int n=a.length;
					ArrayList<Integer> ar=new ArrayList<Integer>();
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
				public static void main(String args[])throws IOException
				{
				//	InputReader in=new InputReader(System.in);
				//	OutputWriter out=new OutputWriter(System.out);
				//	long a=pow(26,1000000005);
				    BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
					ArrayList<Long> ar=new ArrayList<>();
				//	ArrayList<Double> ar1=new ArrayList<>();
					ArrayList<Integer> start=new ArrayList<>();
					ArrayList<Integer> end=new ArrayList<>();
					TreeSet<Long> ts=new TreeSet<>();
					TreeSet<Long> ts1=new TreeSet<>();
					HashMap<Long,Integer> hash=new HashMap<>();
					HashMap<Integer,Integer> odd=new HashMap<Integer,Integer>();
					HashMap<Long,Integer> hash2=new HashMap<Long,Integer>();
				/*	boolean[] prime=new boolean[3000001];
					for(int i=2;i*i<=3000000;i++)
					{
						if(prime[i]==false)
						{
							for(int j=2*i;j<=3000000;j+=i)
							{
								prime[j]=true;
							}
						}
					}*/
					int n=i();
					String s=s();
					char[] ch=s.toCharArray();
					int flag=-1;
					for(int i=1;i<n;i++)
					{
						if(ch[i]<ch[i-1])
						{
							flag=i;
							break;
						}
					}
					if(flag==-1)
					{
						pln("NO");
					}
					else
					{
						pln("YES");
						pln(flag+" "+(flag+1));
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
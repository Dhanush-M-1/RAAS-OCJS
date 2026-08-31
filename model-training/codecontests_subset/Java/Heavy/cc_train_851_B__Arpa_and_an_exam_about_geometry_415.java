	import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Iterator;
	
		 
		public class Solution123 implements Runnable
		{
			static final int MAX = 1000000007;
			static long[] pow2 = new long[200005];
			static class InputReader
			{
				private InputStream stream;
				private byte[] buf = new byte[1024];
				private int curChar;
				private int numChars;
				private SpaceCharFilter filter;
				private BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
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
		 	
			public static void main(String args[]) throws Exception
			{
				new Thread(null, new Solution123(),"Solution123",1<<26).start();
			}	
			static int[] ans;
			static int[] temp;
			public void run()
			{
				InputReader sc= new InputReader(System.in);
				PrintWriter w= new PrintWriter(System.out);
				long a1 = sc.nextInt();
				long a2= sc.nextInt();
				long b1 = sc.nextInt();
				long b2 = sc.nextInt();
				long c1 = sc.nextInt();
				long c2 = sc.nextInt();
				Point p1 = new Point();
				Point p2 = new Point();
				Point p3 = new Point();
				p1.x = a1;
				p1.y = a2;
				p2.x = b1;
				p2.y = b2;
				p3.x = c1;
				p3.y = c2;
				long q = orientation(p1,p2,p3);
				if(q== 0){
					w.println("No");
				}else{
					long dist1 = (p1.y - p2.y)*(p1.y - p2.y) + (p1.x - p2.x) * (p1.x - p2.x);
					long dist2 = (p2.y - p3.y)*(p2.y - p3.y) + (p2.x - p3.x) * (p2.x - p3.x);
					if(dist1 == dist2){
						w.println("yes");
					}else{
						w.println("no");
					}
				}
				w.close();
			}
			long orientation(Point p1, Point p2, Point p3)
			{
			    // See 10th slides from following link for derivation
			    // of the formula
				long val = (p2.y - p1.y) * (p3.x - p2.x) -
			              (p2.x - p1.x) * (p3.y - p2.y);
			 
			    if (val == 0) return 0;  
			 
			    return (val > 0)? 1: 2; 
			}
			static class Point{
				long x;
				long y;
			}
			static class Pair{
				int a;
				int b;
				Pair(int a,int b){
					this.a = a;
					this.b = b;
				}
				Pair(){
					
				}
			}
		}
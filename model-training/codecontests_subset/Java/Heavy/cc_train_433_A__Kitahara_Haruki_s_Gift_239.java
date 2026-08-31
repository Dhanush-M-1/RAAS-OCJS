	import java.io.BufferedReader;
	import java.io.FileReader;
	import java.io.IOException;
	import java.io.InputStream;
	import java.io.InputStreamReader;
	import java.io.PrintWriter;
	import java .util.*;
	public class Contest implements Comparable<Contest>{
		int price ,quality;
		public Contest (int p ,int q){
			price=p;quality=q;
		}
		static long []dp =new long [50];
		public static void main(String [] yahia_mostafa) throws IOException,InterruptedException{
			Scanner sc =new Scanner(System.in);
			PrintWriter pw =new PrintWriter(System.out);
			int n =sc.nextInt();
			int sum=0;
			int [] x =new int [n];
			for (int i=0;i<n;++i) {
				x[i]=sc.nextInt();
				sum+=x[i];
			}
			int s =sum;
			for (int i =0;i<n;++i) {
				sum=s;
				for (int j =i+1;j<n;++j) {
					if ((sum-x[j])*2==s) {
						System.out.println("YES");
						return;
					}
					sum-=x[j];
				}
			}
			pw.print("NO");
			pw.close();
		}
		static long gcd(long a, long b) 
		{ 
		    if (a == 0) 
		        return b; 
		    return gcd(b % a, a); 
		}
		public static long fib(int num) {
			if (num==1||num==2)
				return dp[num]=1l;
			if (num==0)
				return dp[num]=0;
			if(dp[num]!=-1)
				return dp[num];
			return dp[num]=fib(num-1)+fib(num-2);
		}
		public static int fac(int x) {
			if (x==1||x==0)
				return 1;
			return x*fac(x-1);
		}
		static class Scanner {
			StringTokenizer stringTokenizer;
			BufferedReader bfBufferedReader;
			public Scanner(InputStream system) {
				bfBufferedReader=new BufferedReader(new InputStreamReader( system));
			}
			 public Scanner(String file) throws Exception {
		            bfBufferedReader = new BufferedReader(new FileReader( file));
		        }			 
		        public String next() throws IOException {
		            while (stringTokenizer == null || !stringTokenizer.hasMoreTokens())
		                stringTokenizer = new StringTokenizer( bfBufferedReader.readLine());
		            return stringTokenizer.nextToken();
		        }
		 
		        public String nextLine() throws IOException {
		            return bfBufferedReader.readLine();
		        }
		 
		        public int nextInt() throws IOException {
		            return Integer.parseInt(next());
		        }
		 
		        public double nextDouble() throws IOException {
		            return Double.parseDouble(next());
		        }
		 
		        public char nextChar() throws IOException {
		            return next().charAt(0);
		        }
		 
		        public Long nextLong() throws IOException {
		            return Long.parseLong(next());
		        }
		 
		        public boolean ready() throws IOException {
		            return bfBufferedReader.ready();
		        }
		 
		        public void waitForInput() throws InterruptedException {
		            Thread.sleep(3000);
		        }
		    }
		public static boolean eq (int[]arr,int[]x) {
			for (int i=0;i<26;++i)
				if (x[i]!=arr[i])
					return false;
			return true;
		}
		public int compareTo(Contest o) {
			return price-o.price;
		}
		}
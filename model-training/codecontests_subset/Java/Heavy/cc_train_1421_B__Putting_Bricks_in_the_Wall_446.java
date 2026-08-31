	
	
	import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

import org.omg.CORBA.TypeCodePackage.BadKind;

	
	
	
	
	public class COVID {
	
		static long mod = (int) 1e9 + 7;
		static PrintWriter pw;
			static int n,m;
			
			static ArrayList<Integer>[] adjList;
		

	static int INF=(int)1e8;
	public static void main(String[] args) throws Exception {
				Scanner sc = new Scanner(System.in);
				PrintWriter pw = new PrintWriter(System.out);
				int t=sc.nextInt();
				while(t-->0) {
					int n=sc.nextInt();
					char[][] grid=new char[n][n];
					for(int i=0;i<n;i++)
						grid[i]=sc.nextLine().toCharArray();
					if(grid[0][1]==grid[1][0]) {
						int target=(grid[0][1]-'0')^1;
						if(grid[n-1][n-2]==grid[n-2][n-1]) {
							
							if(grid[n-1][n-2]-'0'==target) {
								pw.println(0);
							}else {
								pw.println(2);
								pw.println((n)+" "+(n-1));
								pw.println((n-1)+" "+n);
							}
						}else {
							pw.println(1);
							if(grid[n-1][n-2]-'0'==target) {
								pw.println((n-1)+" "+n);
								
							}else {
								pw.println((n)+" "+(n-1));
							}
						}
					}else {
						if(grid[n-1][n-2]==grid[n-2][n-1]) {
							pw.println(1);
							if(grid[0][1]==grid[n-1][n-2]) {
								pw.println("1 2");
							}else {
								pw.println("2 1");
							}
							
					}else {
						pw.println(2);
						pw.println((n-1)+" "+(n));
						if(grid[0][1]==grid[n-1][n-2]) {
							pw.println("1 2");
						}else {
							pw.println("2 1");
						}
					}
						
					}
				}
				pw.flush();
			}
				

	
			
			static class longPair implements Comparable<longPair> {
			long x, y;
	
			public longPair(long a, long b) {
				x = a;
				y = b;
			}
	
			public int compareTo(longPair p) {
				return (p.x == x) ? ((p.y == y) ? 0 : (y > p.y) ? 1 : -1) : (x > p.x) ? 1 : -1;
			}
		}
	
	
		static class Pair implements Comparable<Pair> {
			int x;
			int y;
	
			public Pair(int a, int b) {
				this.x = a;
				y = b;
			}
	
	
			public int compareTo(Pair o) {
				return (x == o.x) ? ((y > o.y) ? 1 : (y == o.y) ? 0 : -1) : ((x > o.x) ? 1 : -1);
			}
	
			@Override
	
			public int hashCode() {
				final int prime = 31;
				int result = 1;
				result = prime * result + x;
				result = prime * result + y;
				return result;
			}
	
			@Override
	
			public boolean equals(Object obj) {
				if (this == obj)
					return true;
				if (obj == null)
					return false;
				if (getClass() != obj.getClass())
					return false;
				Pair other = (Pair) obj;
				if (x != other.x)
					return false;
				if (y != other.y)
					return false;
				return true;
			}
	
		}
	
		static class Scanner {
			StringTokenizer st;
			BufferedReader br;
	
			public Scanner(InputStream s) {
				br = new BufferedReader(new InputStreamReader(s));
			}
	
			public Scanner(String s) throws FileNotFoundException {
				br = new BufferedReader(new FileReader(s));
			}
	
			public long[] nextLongArr(int n) throws IOException {
				long[] arr = new long[n];
				for (int i = 0; i < n; i++)
					arr[i] = nextLong();
				return arr;
			}
	
			public int[] nextIntArr(int n) throws IOException {
				int[] arr = new int[n];
				for (int i = 0; i < n; i++)
					arr[i] = nextInt();
				return arr;
			}
	
			public String next() throws IOException {
				while (st == null || !st.hasMoreTokens())
					st = new StringTokenizer(br.readLine(), " ,");
				return st.nextToken();
			}
	
			public int nextInt() throws IOException {
				return Integer.parseInt(next());
			}
	
			public long nextLong() throws IOException {
				return Long.parseLong(next());
			}
	
			public String nextLine() throws IOException {
				return br.readLine();
			}
	
			public double nextDouble() throws IOException {
				String x = next();
				StringBuilder sb = new StringBuilder("0");
				double res = 0, f = 1;
				boolean dec = false, neg = false;
				int start = 0;
				if (x.charAt(0) == '-') {
					neg = true;
					start++;
				}
				for (int i = start; i < x.length(); i++) {
					if (x.charAt(i) == '.') {
						res = Long.parseLong(sb.toString());
						sb = new StringBuilder("0");
						dec = true;
					} else {
						sb.append(x.charAt(i));
						if (dec)
							f *= 10;
					}
					if (sb.length() == 18) {
						res += Long.parseLong(sb.toString()) / f;
						sb = new StringBuilder("0");
					}
				}
				res += Long.parseLong(sb.toString()) / f;
				return res * (neg ? -1 : 1);
			}
	
			public boolean ready() throws IOException {
				return br.ready();
			}
	
		}
	
		public static void shuffle(int[] a) {
			int n = a.length;
			for (int i = 0; i < n; i++) {
				int r = i + (int) (Math.random() * (n - i));
				int tmp = a[i];
				a[i] = a[r];
				a[r] = tmp;
			}
		}
	
	}
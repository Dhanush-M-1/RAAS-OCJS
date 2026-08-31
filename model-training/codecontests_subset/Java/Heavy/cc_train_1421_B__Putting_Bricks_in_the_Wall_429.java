import java.io.*;
import java.util.*;
import java.lang.*;

public class B {
	public static void solve(FastReader in,PrintWriter out,int nTestCase) {
		int n = in.nextInt();
		char[][] board = new char[n][n];
		for(int i=0;i<n;i++) {
			board[i] = in.next().toCharArray();
		}
		int a = board[0][1]-'0';
		int b = board[1][0]-'0';
		int c = board[n-1][n-2]-'0';
		int d = board[n-2][n-1]-'0';
		if(a==b&&c==d&&a!=c) {
			out.println("0");
			return;
		}
		ArrayList<Character> ans = new ArrayList<Character>();
		if(a==b) {
			if(c!=d&&c==a) {
				ans.add('c');
			}
			if(c!=d&&d==a) {
				ans.add('d');
			}
			if(c==d&&c==a) {
				ans.add('c');
				ans.add('d');
			}
		}
		if(c==d&&a!=b) {
			if(a!=b&&c==a) {
				ans.add('a');
			}
			if(a!=b&&b==c) {
				ans.add('b');
			}
			if(a==b&&c==a) {
				ans.add('a');
				ans.add('b');
			}			
		}
		if(a!=b&&c!=d) {
			if(a+b+c+d==1) {
				if(a+b==1) {
					if(b==1) ans.add('a');
					if(a==1) ans.add('b');
				}
				if(c+d==1) {
					if(c==1) ans.add('d');
					if(d==1) ans.add('c');
				}
			}
			else {
				if(a!=c) {
					ans.add('b');
					ans.add('d');
				}
				if(a!=d) {
					ans.add('c');
					ans.add('b');
				}
			}
		}
		out.println(ans.size());
		for(char i:ans) {
			if(i=='a') {
				out.println("1 2");
			}
			if(i=='b') {
				out.println("2 1 ");
			}
			if(i=='d') {
				out.println((n-1)+" "+(n));
			}
			if(i=='c') {
				out.println((n)+" "+(n-1));
			}
			
		}
	}
	public static void main(String[] args) {
		FastReader in = new FastReader();
		PrintWriter out = new PrintWriter(System.out);
		long startT = System.currentTimeMillis();
		int T = in.nextInt();
		for(int tt=1;tt<=T;tt++) {
			solve(in,out,tt);
		}
		if(System.getProperty("ONLINE_JUDGE")==null)
			out.println("Total time: "+(System.currentTimeMillis()-startT)+"ms");
		out.close();
	}
	public static int findSqRt(int n) {
		int i = 1;
		while(i*i<n) i++;
		return i;
	}
	static final Random random=new Random();
	//	static void ruffleSort(Pair[] a) {
	//		int n=a.length;//shuffle, then sort 
	//		for (int i=0; i<n; i++) {
	//			int oi=random.nextInt(n);
	//			Pair temp=a[oi];
	//			a[oi]=a[i]; a[i]=temp;
	//		}
	//		Arrays.sort(a);
	//	}
	static void ruffleSort(int[] a) {
		int n=a.length;//shuffle, then sort 
		for (int i=0; i<n; i++) {
			int oi=random.nextInt(n), temp=a[oi];
			a[oi]=a[i]; a[i]=temp;
		}
		Arrays.sort(a);
	}
	static void fastSort(char[] a) {
		int n=a.length;//shuffle, then sort 
		for (int i=0; i<n; i++) {
			int oi=random.nextInt(n);
			char temp=a[oi];
			a[oi]=a[i]; a[i]=temp;
		}
		Arrays.sort(a);
	}
	static class FastReader 
	{ 
		BufferedReader br; 
		StringTokenizer st; 

		public FastReader() 
		{ 
			br = new BufferedReader(new
					InputStreamReader(System.in)); 
		} 

		String next() 
		{ 
			while (st == null || !st.hasMoreElements()) 
			{ 
				try
				{ 
					st = new StringTokenizer(br.readLine()); 
				} 
				catch (IOException  e) 
				{ 
					e.printStackTrace(); 
				} 
			} 
			return st.nextToken(); 
		} 

		int nextInt() 
		{ 
			return Integer.parseInt(next()); 
		} 

		long nextLong() 
		{ 
			return Long.parseLong(next()); 
		} 

		double nextDouble() 
		{ 
			return Double.parseDouble(next()); 
		} 

		String nextLine() 
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

		int[] nextArray(int n) {
			int[] a=new int[n];
			for (int i=0; i<n; i++) a[i]=nextInt();
			return a;
		}
	}
}

//class Pair implements Comparable<Pair>{
//    int a;
//    int b;
//    public Pair(int a, int b) {
//        this.a = a;
//        this.b = b;
//    }
//    public int compareTo(Pair o) {
//        if(this.a==o.a)
//            return this.b - o.b;
//        return this.a - o.a;
//    }   
//}
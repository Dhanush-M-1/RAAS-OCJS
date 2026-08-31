import java.io.*;
import java.util.*;

public class C {
	public static int dp[][]=new int[10][200001];
	public static int mod=1000000007;
	public static int func(int curr_digit,int m) {
		if(m==0) {
			return 1;
		}
		else if(dp[curr_digit][m]!=0) {
			return dp[curr_digit][m];
		}
		else {
			if(curr_digit==9) {
				dp[curr_digit][m]=(func(1, m-1)%mod+func(0, m-1)%mod)%mod;
				return dp[curr_digit][m];
			}
			else {
				dp[curr_digit][m]=func(curr_digit+1, m-1)%mod;
				return dp[curr_digit][m];
			}
		}
	}
	
	public static void main(String[] args) throws FileNotFoundException {
		FastScanner fs = new FastScanner();
		FastOutput fo = new FastOutput();
		long initial_time = System.currentTimeMillis();
		for(int i=0;i<=9;i++) {
			func(i, 200000);
		}
		int testcases = fs.nextInt();
		for (int tt = 0; tt < testcases; tt++) {
			//main code
			int n=fs.nextInt(),m=fs.nextInt();
			long ans=0;
			while(n>0) {
				ans+=dp[n%10][m];
				ans%=mod;
				n/=10;
			}
			fo.println(ans+"");
		}
		fo.time(initial_time);
	}

	static class FastScanner {
		BufferedReader br;
		StringTokenizer st;

		public FastScanner() throws FileNotFoundException {
			//if (System.getProperty("ONLINE_JUDGE") == null) {
				//Read from the File...
			//	File file = new File("src\\input");
			//	br = new BufferedReader(new FileReader(file));
			//} else {
				//Read from the System...
				br = new BufferedReader(new InputStreamReader(System.in));
			//}
			st = new StringTokenizer("");
		}

		String next() {
			while (!st.hasMoreTokens())
				try {
					st = new StringTokenizer(br.readLine());
				} catch (IOException e) {
					e.printStackTrace();
				}
			return st.nextToken();
		}

		int nextInt() {
			return Integer.parseInt(next());
		}

		int[] readArray(int n) {
			int[] a = new int[n];
			for (int i = 0; i < n; i++)
				a[i] = nextInt();
			return a;
		}

		long nextLong() {
			return Long.parseLong(next());
		}
	}

	static class FastOutput {
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		void print(String str) {
			try {
				bw.write(str);
				bw.flush();
			} catch (IOException e) {
			}
		}

		void print(int num) {
			try {
				bw.write((num + ""));
				bw.flush();
			} catch (IOException e) {
			}
		}

		void println(String str) {
			try {
				bw.write(str + '\n');
				bw.flush();
			} catch (IOException e) {
			}
		}

		void println(int num) {
			try {
				bw.write(num + "" + '\n');
				bw.flush();
			} catch (IOException e) {
			}
		}

		void time(long init) {
			if (System.getProperty("ONLINE_JUDGE") == null) {
				System.out.println(System.currentTimeMillis() - init + "ms");
			}
		}
	}
}

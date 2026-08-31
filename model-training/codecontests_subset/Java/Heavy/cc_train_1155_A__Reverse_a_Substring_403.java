import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Stack;
import java.util.StringTokenizer;

public class answertillD {
	static ArrayList<Integer>[] adjlist;
	static int[][] adjmatrix;
	static boolean[] vis;
	static boolean[] intialvis;
	static boolean[] vis2;
	static int[] counter;
	static int V, E;
	static Stack<Integer> st;
	static ArrayList<Integer> arrylist;
	static boolean flag;
	static int[] dx = new int[] { 1, -1, 0, 0 };
	static int[] dy = new int[] { 0, 0, 1, -1 };
	static int[] Arr;
	static PrintWriter pw;

	/*public static void bin(int[] Arr) {
		long l = 0;
		long r = 100000000;
		long mid = (l + r )/ 2;
		while(l<r)

	}
*/
	public static void main(String[] args) throws IOException, InterruptedException {
		pw = new PrintWriter(System.out);
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		Arr = new int[n];
		String str=sc.nextLine();int l=-1;int r=-1;
		for (int i = 1; i < n; i++) {
			if(str.charAt(i-1)>str.charAt(i)){
				l=i;
				r=i+1;
				break;
			}
		}
		if(l==-1){
			pw.print("NO");
		}else{
			pw.println("YES");
			pw.println(l+" "+r);
		}

		pw.close();
	}
	


	static class Scanner {
		StringTokenizer st;
		BufferedReader br;

		public Scanner(InputStream s) {
			br = new BufferedReader(new InputStreamReader(s));
		}

		public String next() throws IOException {
			while (st == null || !st.hasMoreTokens())
				st = new StringTokenizer(br.readLine());
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
			for (int i = start; i < x.length(); i++)
				if (x.charAt(i) == '.') {
					res = Long.parseLong(sb.toString());
					sb = new StringBuilder("0");
					dec = true;
				} else {
					sb.append(x.charAt(i));
					if (dec)
						f *= 10;
				}
			res += Long.parseLong(sb.toString()) / f;
			return res * (neg ? -1 : 1);
		}

		public boolean ready() throws IOException {
			return br.ready();
		}

	}

}

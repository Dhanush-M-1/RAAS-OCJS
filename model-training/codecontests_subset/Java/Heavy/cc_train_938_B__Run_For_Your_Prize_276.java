import java.io.*;
import java.util.*;

public class B {

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		PrintWriter pw = new PrintWriter(System.out);
		
		int n =sc.nextInt();
		int cost=0;
		
		for(int i = 0,n2,temp1,temp2; i < n  ;i++) {
			n2=sc.nextInt();
			temp1=Math.abs(1-n2);
			temp2=Math.abs((int) 1e6-n2);
			if(temp1>=temp2) {
				cost = Math.max(cost, temp2);
				break;
			}
			cost = temp1;
		}

		pw.println(cost);
		pw.flush();
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

		public boolean ready() throws IOException {
			return br.ready();
		}

	}
}

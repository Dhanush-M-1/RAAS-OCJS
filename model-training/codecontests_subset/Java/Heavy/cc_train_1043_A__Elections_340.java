import java.io.*;
import java.util.*;

public class A {

	public static void main(String[] args) throws IOException {

		Scanner sc = new Scanner();
		PrintWriter out = new PrintWriter(System.out);
		int n=sc.nextInt();
		int sum=0;
		int min=0;
		for(int j=0;j<n;j++) {
			int x=sc.nextInt();
			sum+=x;
			min=Math.max(min, x);
		}
		int x=2*sum;
		int ans=x/n+1;
		if(ans<min)
			ans=min;
		out.println(ans);
		
		
		out.close();
	}

	static class Scanner {
		BufferedReader br;
		StringTokenizer st;

		Scanner() {
			br = new BufferedReader(new InputStreamReader(System.in));
		}

		Scanner(String f) throws FileNotFoundException {
			br = new BufferedReader(new FileReader(f));
		}

		String next() throws IOException {
			while (st == null || !st.hasMoreTokens())
				st = new StringTokenizer(br.readLine());
			return st.nextToken();
		}

		int nextInt() throws IOException {
			return Integer.parseInt(next());
		}

		long nextLong() throws IOException {
			return Long.parseLong(next());
		}

		double nextDobule() throws IOException {
			return Double.parseDouble(next());
		}

		String nextLine() throws IOException {
			return br.readLine();
		}
	}
}
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Sol22 {

	BufferedReader br;
	StringTokenizer st;
	PrintWriter out;

	String nextToken() throws IOException {
		while (st == null || !st.hasMoreTokens()) {
			String s = br.readLine();
			if (s == null) {
				return "-1";
			}
			st = new StringTokenizer(s);
		}
		return st.nextToken();
	}

	int nextInt() throws IOException {
		return Integer.parseInt(nextToken());
	}

	long nextLong() throws IOException {
		return Long.parseLong(nextToken());
	}

	void run() throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		out = new PrintWriter(System.out);

		int n = nextInt();
		int x = nextInt() - 1;
		int[] a = new int[n];
		for (int i = 0; i < n; i++) {
			a[i] = nextInt() - 1;
		}

		int[] c = new int[n];
		for (int i = 0; i < n; i++) {
			if (a[i] >= 0) {
				c[a[i]] = 1;
			}
		}
		int p = 0;
		int[] ans = new int[n];
		for (int i = 0; i < n; i++) {
			if (c[i] == 0) {
				boolean bol = false;
				int j = i;
				int k = 1;
				while (a[j] >= 0) {
					if (j == x) {
						bol = true;
					}
					j = a[j];
					k++;
				}
				if (j == x) {
					bol = true;
				}
				if (!bol) {
					ans[p] = k;
					p++;
				}

			}
		}
		int j = x;
		int k = 1;
		while (a[j] >= 0) {
			j = a[j];
			k++;
		}
		Arrays.sort(ans,0,p);
		int[] b = new int[n + 1];
		b[0] = 1;
		for (int i = 0; i < p; i++){
			for ( int t = n; t >=0; t--){
				if (b[t]>0){
					b[t+ans[i]]=1;
				}
			}
		}
		
		
		for (int i = 0; i <= n; i++) {
			if (b[i] > 0) {
				out.println(i+k);
			}
		}

		out.println();

		br.close();
		out.close();
	}

	public static void main(String[] args) throws IOException {
		new Sol22().run();
	}

}

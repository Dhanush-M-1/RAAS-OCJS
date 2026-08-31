import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;
public class code {
	public static void main(String[] args)throws IOException {
		FastReader sc = new FastReader();
		PrintWriter pw = new PrintWriter(System.out);
		int t = sc.nextInt();
		while (t-- > 0) {
			int n1 = sc.nextInt();
			int n2 = sc.nextInt();
			int a[] = new int[n1];
			int b[] = new int[n2];
			for (int i = 0; i < n1; i++) {
				a[i] = sc.nextInt();
			}
			for (int i = 0; i < n2; i++) {
				b[i] = sc.nextInt();
			}
			int ans = -1;
			for (int i = 0; i < n1; i++) {
				for (int j = 0; j < n2; j++) {
					if (a[i] == b[j]) {
						ans = a[i];
						break;
					}
				}

			}
			if (ans == -1)
				System.out.println("NO");
			else {
				System.out.println("YES");
				System.out.println(1 + " " + ans);
			}
		}

	}
}





class FastReader {
	BufferedReader br;
	StringTokenizer st;

	public FastReader() {
		br = new BufferedReader(new
		                        InputStreamReader(System.in));
	}

	String next() {
		while (st == null || !st.hasMoreElements()) {
			try {
				st = new StringTokenizer(br.readLine());
			} catch (IOException  e) {
				e.printStackTrace();
			}
		}
		return st.nextToken();
	}

	int nextInt() {
		return Integer.parseInt(next());
	}

	long nextLong() {
		return Long.parseLong(next());
	}

	double nextDouble() {
		return Double.parseDouble(next());
	}

	String nextLine() {
		String str = "";
		try {
			str = br.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return str;
	}
}
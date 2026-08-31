import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
	public static PrintWriter out;

	public static void main(String[] args) {
		MyScanner sc = new MyScanner();
		out = new PrintWriter(new BufferedOutputStream(System.out));

		int a = sc.nextInt();
		int b = sc.nextInt();
		int rem = 0;
		int sum = 0;
		while (a >= 1) {
			sum += a;
			rem += a;
			if (rem / (double) b >= 1.0) {
				a = rem / b;
				rem = rem % b;
			} else {
				a = 0;
			}
		}
		out.println(sum);
		out.close();
	}

	public static void sort(int a[]) {
		ArrayList<Integer> x = new ArrayList<>();
		for (int i : a)
			x.add(i);
		Collections.sort(x);
		for (int i = 0; i < a.length; ++i)
			a[i] = x.get(i);
	}

	public static void sort(long a[]) {
		ArrayList<Long> x = new ArrayList<>();
		for (Long i : a)
			x.add(i);
		Collections.sort(x);
		for (int i = 0; i < a.length; ++i)
			a[i] = x.get(i);
	}

	public static void sort(ArrayList<Integer> arr) {
		Collections.sort(arr);
	}

	public static class MyScanner {
		BufferedReader br;
		StringTokenizer st;

		public MyScanner() {
			br = new BufferedReader(new InputStreamReader(System.in));
		}

		String next() {
			while (st == null || !st.hasMoreElements()) {
				try {
					st = new StringTokenizer(br.readLine());
				} catch (IOException e) {
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
}

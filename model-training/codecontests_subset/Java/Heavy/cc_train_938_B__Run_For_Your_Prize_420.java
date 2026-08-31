import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class CF938B {

	public static void main(String[] args) {
		FastReader fr = new FastReader();
		int n = fr.nextInt();
		int[] arr = new int[n];
		for (int i = 0; i < n; i++)
			arr[i] = fr.nextInt();
		int[] temp1 = new int[n];
		for (int i = n - 1; i >= 0; i--) {
			temp1[i] = 1000000 - arr[i];
		}
		int minTime = temp1[0];
		for (int i = 0; i < n - 1; i++)
			minTime = Math.min(minTime, Math.max(arr[i] - 1, temp1[i + 1]));
		minTime = Math.min(minTime, arr[n - 1] - 1);
		// System.out.println(Arrays.toString(temp1));
		System.out.println(minTime);
	}

	// Better IO Class
	static class FastReader {
		BufferedReader br;
		StringTokenizer st;

		FastReader() {
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

		public int nextInt() {
			return Integer.parseInt(next());
		}

		public long nextLong() {
			return Long.parseLong(next());
		}

		public Double nextDouble() {
			return Double.parseDouble(next());
		}

		public Float nextFloat() {
			return Float.parseFloat(next());
		}

		String nextLine() {
			String str = "";
			try {
				str = br.readLine();
			} catch (IOException e) {
				System.out.println(e);
			}
			return str;
		}
	}
}

import java.io.*;
import java.util.*;

public class prog {


	public static void main(String[] args)throws IOException {

		InputReader in = new InputReader();
		int a = in.nextInt();
		int b = in.nextInt();
		int c = in.nextInt();
		System.out.println(Math.max(0, (int)Math.ceil((a * c - c * b) / (double)b)));
	}


	static class InputReader {
		BufferedReader br;
		StringTokenizer st;

		public InputReader() {
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
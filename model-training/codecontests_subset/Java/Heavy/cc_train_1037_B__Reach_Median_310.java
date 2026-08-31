import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class A {

	public static void main(String[] args) throws NumberFormatException, IOException {
		Scanner sc = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);
		int n = sc.nextInt(), s = sc.nextInt();
		ArrayList<Integer> a = new ArrayList<>(n);
		for (int i = 0; i < n; ++i) {
			a.add(sc.nextInt());
		}
		int med = n/2;
		Collections.sort(a);
		if(a.get(med) < s){
			long sum = 0;
			for (int i = med; i < n; ++i) {
				sum += Math.max(0, s - a.get(i));
			}
			out.println(sum);
		}
		else if(a.get(med) > s){
			long sum = 0;
			for (int i = 0; i <= med; ++i) {
				sum += Math.max(0, a.get(i) - s);
			}
			out.println(sum);
		}
		else out.println(0);
		out.flush();
		out.close();
	}

	static class Scanner {
		BufferedReader br;
		StringTokenizer st;

		public Scanner(InputStream is) {
			br = new BufferedReader(new InputStreamReader(is));

		}

		public String next() throws IOException {
			while (st == null || !st.hasMoreTokens()) {
				st = new StringTokenizer(br.readLine());
			}
			return st.nextToken();
		}

		public int nextInt() throws NumberFormatException, IOException {
			return Integer.parseInt(next());
		}
		public long nextLong() throws NumberFormatException, IOException {
			return Long.parseLong(next());
		}
	}
}
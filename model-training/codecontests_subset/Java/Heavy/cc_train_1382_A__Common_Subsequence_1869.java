import java.util.*;
import java.util.concurrent.ThreadLocalRandom;
import java.io.*;

public class Sub {

	public static void main(String[] args) throws NumberFormatException, IOException, InterruptedException {
		Scanner sc = new Scanner(System.in);
		PrintWriter pw = new PrintWriter(System.out);
		int t=sc.nextInt();
		loop:while(t-->0) {
			int n=sc.nextInt();
			int m=sc.nextInt();
			HashSet<Integer>hs=new HashSet<Integer>();
			for (int i = 0; i < n; i++) {
				hs.add(sc.nextInt());
			}
			int [] a=sc.nextIntArr(m);
			for (int i = 0; i < m; i++) {
				int o=a[i];
				if(hs.contains(o)) {
					pw.println("YES");
					pw.println(1+" "+o);
					continue loop;
				}
			}
			pw.println("NO");
		}
		pw.close();
	}

	static void shuffleArray(int[] ar) {
		// If running on Java 6 or older, use `new Random()` on RHS here
		Random rnd = ThreadLocalRandom.current();
		for (int i = ar.length - 1; i > 0; i--) {
			int index = rnd.nextInt(i + 1);
			// Simple swap
			int a = ar[index];
			ar[index] = ar[i];
			ar[i] = a;
		}
	}

	static class Scanner {
		StringTokenizer st;
		BufferedReader br;

		public Scanner(InputStream s) {
			br = new BufferedReader(new InputStreamReader(s));
		}

		public Scanner(FileReader r) {
			br = new BufferedReader(r);
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
			return Double.parseDouble(next());
		}

		public int[] nextIntArr(int n) throws IOException {
			int[] arr = new int[n];
			for (int i = 0; i < arr.length; i++)
				arr[i] = nextInt();
			return arr;
		}

		public boolean ready() throws IOException {
			return br.ready();
		}
	}

}
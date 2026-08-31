import java.io.*;
import java.util.*;

public class Main {
	static Scanner sc = new Scanner(System.in);
	static PrintWriter out = new PrintWriter(System.out);

	public static void main(String[] args) throws Exception {

		int n = sc.nextInt(), k = sc.nextInt();
		PriorityQueue<Integer> a, b, c;
		a = new PriorityQueue<>();
		b = new PriorityQueue<>();
		c = new PriorityQueue<>();

		for (int i = 0; i < n; i++) {
			int ti = sc.nextInt(), ai = sc.nextInt(), bi = sc.nextInt();
			if (ai == 1 && bi == 1) {
				c.add(ti);
			} else if (ai == 1) {
				a.add(ti);
			} else if(bi == 1) {
				b.add(ti);
			}
		}

		long ans = 0;
		boolean flag = true;
		while (k-- > 0) {
			long fst = a.isEmpty() ? Integer.MAX_VALUE : a.peek();
			fst += b.isEmpty() ? Integer.MAX_VALUE : b.peek();
			
			long snd = c.isEmpty() ? Integer.MAX_VALUE : c.peek();
			
			if(Math.min(fst, snd) >= Integer.MAX_VALUE) {
				flag = false;
				break;
			}
			
			if(fst < snd) {
				ans += fst;
				a.poll();
				b.poll();
			}else {
				ans += snd;
				c.poll();
			}
		}

		out.println(flag ? ans : -1);
		out.close();
	}
}

class Scanner {
	StringTokenizer st;
	BufferedReader br;

	public Scanner(InputStream system) {
		br = new BufferedReader(new InputStreamReader(system));
	}

	public Scanner(String file) throws Exception {
		br = new BufferedReader(new FileReader(file));
	}

	public String next() throws IOException {
		while (st == null || !st.hasMoreTokens())
			st = new StringTokenizer(br.readLine());
		return st.nextToken();
	}

	public String nextLine() throws IOException {
		return br.readLine();
	}

	public int nextInt() throws IOException {
		return Integer.parseInt(next());
	}

	public double nextDouble() throws IOException {
		return Double.parseDouble(next());
	}

	public Long nextLong() throws IOException {
		return Long.parseLong(next());
	}
}
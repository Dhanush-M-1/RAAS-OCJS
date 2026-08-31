import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.StringTokenizer;

/**
 * Built using CHelper plug-in Actual solution is at the top
 */
public class Main {
	public static void main(String[] args) {
		InputStream inputStream = System.in;
		OutputStream outputStream = System.out;
		InputReader in = new InputReader(inputStream);
		PrintWriter out = new PrintWriter(outputStream);
		TaskD solver = new TaskD();
		solver.solve(1, in, out);
		out.close();
	}
}

class TaskD {
	static final long MODULO = (int) (1e9 + 7);

	public void solve(int testNumber, InputReader in, PrintWriter out) {

		int n = in.nextInt();
		int m = in.nextInt();
		
		int[] a = new int[n];
		int[] c = new int[n];
		int[] b = new int[m];
		LinkedList<Integer> l = new LinkedList<Integer>();
		int[] p = new int[n];
		
		for (int i = 0; i < n; i++) {
			a[i] = in.nextInt();
			p[i] = -1;
		}
		int t;
		for (int i = 0; i < m; i++){
			t = in.nextInt()-1;
			b[i] = t;
			c[t] = 1;
		}
		int count = 0;
		for (int i = 0; i < m; i++){
			if (c[b[i]] == 1){
				l.add(b[i]);
				c[b[i]] = 0;
			}
		}
		long sum = 0L;
		//System.out.println(l);
		for (int i = 0; i < m; i++){
			count = 0;
			for (Integer h : l) {
				if (h == b[i]) {
					break;
				}
				count++;
				sum+=a[h];
			}
			l.remove(count);
			l.add(0, b[i]);
			
		}
		
		
		//for (int i = 0; i < n; i++) {
				System.out.print(sum);
		//}
		
		

	}
}

class Pair implements Comparable<Pair> {
	public int v;

	public Pair(int a) {
		v = a;
	}

	@Override
	public int compareTo(Pair arg0) {
		// TODO Auto-generated method stub
		return this.v - arg0.v;
	}

}

class InputReader {
	public BufferedReader reader;
	public StringTokenizer tokenizer;

	public InputReader(InputStream stream) {
		reader = new BufferedReader(new InputStreamReader(stream), 32768);
		tokenizer = null;
	}

	public String next() {
		while (tokenizer == null || !tokenizer.hasMoreTokens()) {
			try {
				tokenizer = new StringTokenizer(reader.readLine());
			} catch (IOException e) {
				throw new RuntimeException(e);
			}
		}
		return tokenizer.nextToken();
	}

	public int nextInt() {
		return Integer.parseInt(next());
	}

}
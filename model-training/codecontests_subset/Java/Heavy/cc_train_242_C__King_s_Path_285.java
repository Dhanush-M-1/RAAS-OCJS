import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Collection;
import java.util.HashMap;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.util.Queue;
import java.util.LinkedList;
import java.io.InputStream;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 */
public class Main {
	public static void main (String[] args) {
		InputStream inputStream = System.in;
		OutputStream outputStream = System.out;
		InputReader in = new InputReader (inputStream);
		PrintWriter out = new PrintWriter (outputStream);
		TaskC solver = new TaskC ();
		solver.solve (1, in, out);
		out.close ();
	}
	
	static class TaskC {
		private static final byte[] dx = {-1, -1, -1, 0, 0, 1, 1, 1};
		private static final byte[] dy = {0, -1, 1, -1, 1, 0, -1, 1};
		private static HashMap<Long, Boolean> allowed = new HashMap<Long, Boolean> ();
		private static HashMap<Long, Integer> dist = new HashMap<Long, Integer> ();
		private static int xf;
		private static int yf;
		
		private static long map (int x, int y) {
			return y|(((long) x)<<32)/*1000000005L*x + y*/;
		}
		
		private static void bfs (int x, int y) {
			dist.put (map (x, y), 0);
			Queue<Long> q = new LinkedList<Long> ();
			q.add (map (x, y));
			while (!q.isEmpty ()) {
				long op = q.poll ();
				int x1 = (int) (op>>32)/*(op/1000000005)*/;
				int y1 = (int) (op)/*(op%1000000005)*//*op-x1*1000000005*/;
				if (x1 == xf && y1 == yf) return;
				for (int i = 0; i<8; i++) {
					int newX = x1+dx[i];
					int newY = y1+dy[i];
					if (allowed.get (map (newX, newY)) != null) {
						if (dist.get (map (newX, newY)) == null) {
							q.add (map (newX, newY));
							dist.put (map (newX, newY), dist.get (map (x1, y1))+1);
						}
					}
				}
			}
		}
		
		public void solve (int testNumber, InputReader in, PrintWriter out) {
/* worst complexity can be o(n).Have to find shortest path but with a twist: allowed cell marking
 * seems to eat at least o(n), I can't find any other way. Have to use map to search in o(1)*/
			int x0 = in.nextInt (), y0 = in.nextInt (), x1 = in.nextInt (), y1 = in.nextInt ();
			int n = in.nextInt ();
			int idx = 0;
			for (int i = 0; i<n; i++) {
				int r = in.nextInt ();
				int a = in.nextInt ();
				int b = in.nextInt ();
				for (int j = a; j<=b; j++) {
					allowed.put (map (r, j), true);
				}
			}
			xf = x1;
			yf = y1;
			bfs (x0, y0);
			int ans = dist.get (map (x1, y1)) != null ? dist.get (map (x1, y1)) : -1;
			out.println (ans);
		
		/*//testing get
		long op = map (1, 1);
		int x = (int) (op>>32)*//*(op/1000000005)*//*;
		int y = (int) (op)*//*(op%1000000005)*//*;
		System.out.println (x+" "+y);*/
		}
		
	}
	
	static class InputReader {
		private BufferedReader reader;
		private StringTokenizer tokenizer;
		
		public InputReader (InputStream stream) {
			reader = new BufferedReader (new InputStreamReader (stream), 32768);
			tokenizer = null;
		}
		
		public String next () {
			while (tokenizer == null || !tokenizer.hasMoreTokens ()) {
				try {
					String str;
					if ((str = reader.readLine ()) != null) tokenizer = new StringTokenizer (str);
					else return null;//to detect eof
				} catch (IOException e) {
					throw new RuntimeException (e);
				}
			}
			return tokenizer.nextToken ();
		}
		
		public int nextInt () {
			return Integer.parseInt (next ());
		}
		
	}
}


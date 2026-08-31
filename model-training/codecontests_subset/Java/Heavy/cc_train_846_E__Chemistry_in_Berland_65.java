import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

public class e {
	public static void main(String[] args) throws IOException {
		FastScanner in = new FastScanner(System.in);
		int n = in.nextInt();
		long[] bs = new long[n];
		long[] as = new long[n];
		for (int i = 0; i < n; i++) {
			bs[i] = in.nextLong();
		}
		for (int i = 0; i < n; i++) {
			as[i] = in.nextLong();
		}
		ArrayList<Edge>[] cs = new ArrayList[n];
		int[] par = new int[n];
		for (int i = 0; i < n; i++)
			cs[i] = new ArrayList<>();
		int[] degs = new int[n];
		for (int i = 1; i < n; i++) {
			int x = in.nextInt() - 1, k = in.nextInt();
			cs[x].add(new Edge(i, k));
			par[i] = x;
			degs[x]++;
		}
		ArrayDeque<Integer> q = new ArrayDeque<Integer>();
		for (int i = 0; i < n; i++) {
			if (degs[i] == 0) {
				q.offer(i);
			}
		}
		long[] demands = new long[n];
		try {
			while (!q.isEmpty()) {
				int v = q.poll();
				long demand = bs[v] - as[v];
	//			System.out.println(v + ": " + demand);
				for (Edge e : cs[v]) {
					if (demands[e.v] < 0) {
						demand = Math.addExact(demand, Math.multiplyExact(demands[e.v], e.w));
					} else {
						demand = Math.addExact(demand, demands[e.v]);
					}
				}
				if (v != 0) {
					degs[par[v]]--;
					if (degs[par[v]] == 0)
						q.offer(par[v]);
				}
				demands[v] = demand;
			}
		} catch(Exception e) {
			System.out.println("NO");
			return;
		}
		System.out.println(demands[0] >= 0 ? "YES" : "NO");
	}

	static class Edge {
		int v;
		int w;

		public Edge(int v, int w) {
			this.v = v;
			this.w = w;
		}
	}
	static class FastScanner {
	    BufferedReader br;
	    StringTokenizer st;
		
	    public FastScanner(InputStream i) {
	        br = new BufferedReader(new InputStreamReader(i));
	        st = new StringTokenizer("");
	    }
				
	    public String next() throws IOException {
	        if(st.hasMoreTokens())
	            return st.nextToken();
	        else
	            st = new StringTokenizer(br.readLine());
	        return next();
	    }

	    public int nextInt() throws IOException {
	        return Integer.parseInt(next());
	    }
	    //#
	    public long nextLong() throws IOException {
	        return Long.parseLong(next());
	    }
	    public double nextDouble() throws IOException {
	        return Double.parseDouble(next());
	    }
	    //$
	}
}

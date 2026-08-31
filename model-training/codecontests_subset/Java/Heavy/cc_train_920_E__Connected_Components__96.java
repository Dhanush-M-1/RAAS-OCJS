import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class e {
	public static void main(String[] args) throws IOException {
		FastScanner in = new FastScanner(System.in);
		PrintWriter out = new PrintWriter(System.out);
		int n = in.nextInt(), m = in.nextInt();
		TreeSet<Integer> unseen = new TreeSet<>();
		ArrayList<Integer>[] adj = new ArrayList[n];
		for(int i=0;i<n;i++) {
			adj[i] = new ArrayList<>();
			adj[i].add(n);
		}
		for(int i=0;i<m;i++) {
			int u = in.nextInt()-1, v = in.nextInt()-1;
			adj[u].add(v);
			adj[v].add(u);
		}
		for(int i=0;i<n;i++) {
			Collections.sort(adj[i]);
			unseen.add(i);
		}
		unseen.add(n);
		ArrayList<Integer> sizes = new ArrayList<>();
		for(int s=0;s<n;s++) {
			if(!unseen.contains(s)) continue;
			int size = 0;
			ArrayDeque<Integer> q = new ArrayDeque<>();
			q.offer(s);
			unseen.remove(s);
			while(!q.isEmpty()) {
				int u = q.poll();
				int last = -1;
				size++;
				for(int e : adj[u]) {
					int next;
					while((next = unseen.higher(last)) < e) {
						q.offer(next);
						unseen.remove(next);
					}
					last = e;
				}
			}
			sizes.add(size);
		}
		Collections.sort(sizes);
		out.println(sizes.size());
		for(int i=0;i<sizes.size();i++) {
			if(i != 0)
				out.print(' ');
			out.print(sizes.get(i));
		}
		out.println();
		out.close();
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
	    public long nextLong() throws IOException {
	        return Long.parseLong(next());
	    }
	    public double nextDouble() throws IOException {
	        return Double.parseDouble(next());
	    }
	}
}

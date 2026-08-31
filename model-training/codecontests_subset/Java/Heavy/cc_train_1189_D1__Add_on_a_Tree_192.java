import java.util.*;
import java.io.*;
public class d {
	public static void main(String[] args) throws IOException {
		FastScanner sc = new FastScanner(System.in);
		int n = sc.nextInt();
		
		ArrayList<Integer>[] paths = new ArrayList[n];
		
		for (int i = 0 ; i < n ; i++) {
			paths[i] = new ArrayList<>();
		}
		
		for (int i = 0 ; i < n-1 ; i++) {
			int a = sc.nextInt()-1, b = sc.nextInt()-1;
			paths[a].add(b);
			paths[b].add(a);
		}
		
		for (int i = 0 ; i < paths.length ; i++) {
			if (paths[i].size() == 2) {
				System.out.println("NO"); return;
			}
		}
		
		System.out.println("YES");
	}
/*

3
1 2
1 3
 */
	
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

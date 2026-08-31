import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Main {

	public static class FastReader {
		BufferedReader br;
		StringTokenizer root;
		
 
		public FastReader() {
			br = new BufferedReader(new InputStreamReader(System.in));
		}
 
		String next() {
			while (root == null || !root.hasMoreTokens()) {
				try {
					root = new StringTokenizer(br.readLine());
				} catch (Exception addd) {
					addd.printStackTrace();
				}
			}
			return root.nextToken();
		}
 
		int nextInt() {
			return Integer.parseInt(next());
		}
 
		double nextDouble() {
			return Double.parseDouble(next());
		}
 
		long nextLong() {
			return Long.parseLong(next());
		}
 
		String nextLine() {
			String str = "";
			try {
				str = br.readLine();
			} catch (Exception addd) {
				addd.printStackTrace();
			}
			return str;
		}
	}
	
	public static PrintWriter out = new PrintWriter (new BufferedOutputStream(System.out));
	
	public static FastReader sc = new FastReader();
 
	static int mod = (int) (1e9+7),MAX=(int) (3e5),k,n;
	static List<Integer>[] edges ;
    static long[] size;
    static long[][] dp;
	public static void main(String[] args) {
	  int n = sc.nextInt();
	  size = new long[n+1];
	  edges = new ArrayList[n+1];
	  for(int i=0;i<edges.length;++i) edges[i] = new ArrayList<>();
	  int root = -1;
	  for(int i=1;i<=n;++i) {
		  int p = sc.nextInt();
		  if(p == 0) root = i;
		  else edges[p].add(i);
	  }
	  if(n%2 == 0) out.println("NO");
	  else { out.println("YES");
	  dfs(root);
	  delete(root);
	  }
	  out.close();
	}
	
	private static void delete(int root) {
		for(int child : edges[root]) {
			if(size[child]%2 == 0)
				delete(child);
		}
		out.println(root);
		for(int child : edges[root]) {
			if(size[child]%2 != 0)
				delete(child);
		}
		
	}

	private static void dfs(int root) {
		size[root] = 1;
		for(int child : edges[root]) {
			dfs(child);
			size[root]+=size[child];
		}
		
	}
	
}

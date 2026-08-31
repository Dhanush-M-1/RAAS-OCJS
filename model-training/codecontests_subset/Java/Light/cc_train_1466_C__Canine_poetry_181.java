import java.io.*;
import java.util.*;




public class Solution{
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
				} catch (Exception r) {
					r.printStackTrace();
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
			} catch (Exception r) {
				r.printStackTrace();
			}
			return str;
		}
	}
	
	public static PrintWriter out = new PrintWriter (new BufferedOutputStream(System.out));
	static FastReader sc = new FastReader();
	static int mod = (int) (1e9+7);
 //   public static List<Integer>[] edges;

	public static void main(String[] args) {

		int t = sc.nextInt();
		while(t-->0) {
			char[] s = sc.next().toCharArray();
			int ans = 0;
			Set<Character> set = new HashSet<>();
			boolean[] visited = new boolean[s.length];
			for(int i=0;i<s.length;++i) {
				if(i-3 >= 0 && visited[i-3]) set.remove(s[i-3]);
				if(set.contains(s[i])) ++ans;
				else {
					set.add(s[i]);
					visited[i] = true;
				}
			}
			out.println(ans);
		}
		out.close();
	}

	
}
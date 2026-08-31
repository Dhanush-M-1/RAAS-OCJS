import java.util.*;
import java.io.*;

public class Main {

	BufferedReader in;
	StringTokenizer str = null;
	PrintWriter out;
	
	private String next() throws Exception{
		while (str == null || !str.hasMoreElements())
			str = new StringTokenizer(in.readLine());
		return str.nextToken();
	}
	
	private int nextInt() throws Exception{
		return Integer.parseInt(next());
	}
	
	private long nextLong() throws Exception{
		return Long.parseLong(next());
	}
	
	private double nextDouble() throws Exception{
		return Double.parseDouble(next());
	}
	
	public void run() throws Exception{
		in =  new BufferedReader(new InputStreamReader(System.in));
		out = new PrintWriter(System.out);
		int n = nextInt(), m = nextInt();
		int []w = new int[n];
		for(int i = 0; i < n; ++i) w[i] = nextInt();
		int []a = new int[m];
		for(int i = 0; i < m; ++i) a[i] = nextInt() - 1;

		List<Integer> list = new ArrayList<Integer>();
		boolean []used = new boolean[n];
		for(int i = 0; i < m; ++i) {
			if (used[a[i]]) continue;
			used[a[i]] = true;
			list.add(a[i]);
		}

		// System.out.println(list);

		int ret = 0;
		for(int i = 0; i < m; ++i) {
			int x = a[i], sum = 0;
			for(int j = 0; j < list.size(); ++j) {
				if (list.get(j) == x) {
					list.remove(j);
					list.add(0, x);
					break;
				}
				sum += w[list.get(j)];
			}
			ret += sum;
		}

		out.println(ret);
		out.close();
	}
		
	public static void main(String[] args) throws Exception{
		new Main().run();
	}
}

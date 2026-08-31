import java.util.*;
import java.io.*;

import static java.lang.Math.*;

public class Solution implements Runnable{
	
	public static void main (String ...strings){
		new Thread(new Solution()).start();
	}
	
	BufferedReader in;
	PrintWriter out;
	StringTokenizer st;
	String next() throws Exception{
		if (st == null || !st.hasMoreElements())
			st = new StringTokenizer(in.readLine());
		return st.nextToken();
	}
	int nextInt() throws Exception{
		return Integer.parseInt(next());
	}
	double nextDouble() throws Exception{
		return Double.parseDouble(next());
	}
	long nextLong() throws Exception{
		return Long.parseLong(next()); 
	}
	
	@Override
	public void run() {
		try{
			in = new BufferedReader(new InputStreamReader(System.in));
			out = new PrintWriter(System.out);
			solve();
		}catch (Exception e) {
			throw new RuntimeException(e);
		}
		finally{
			out.close();
		}
	}
	void solve() throws Exception{
		int k = nextInt();
		String [][] ret = new String [k-1][k-1];
		for (int i = 0; i < k - 1; i++)
			ret[0][i] = ret[i][0] = Integer.toString(i+1);
		
		for (int i = 1; i < ret.length; i++)
			for (int j = 1; j < ret.length; j++)
				ret[i][j] = Integer.toString((i+1)*(j+1), k);
		
		for (int i = 0; i < ret.length; i++){
			for (int j = 0; j < ret.length; j++)
				out.print(ret[i][j] + " ");
			out.println();
		}
	}
	
}
//package codeforcesSchool;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class B {

	static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static PrintWriter out = new PrintWriter(System.out);
	
	static String nextToken() throws IOException{
		while (st==null || !st.hasMoreTokens()){
			String s = bf.readLine();
			if (s == null)
				return null;
			st = new StringTokenizer(s);
		}
		
		return st.nextToken();
	}
	
	static int nextInt() throws IOException{
		return Integer.parseInt(nextToken());
	}
	
	static String nextStr() throws IOException{
		return nextToken();
	}
	
	public static void main(String[] args) throws IOException{
		int n = nextInt()*2,
			a = nextInt(),
			b = nextInt(),
			c = nextInt();
		
		int res = 0;
		for (int i=0; i<=a; i+=2)
			for (int j=0; j<=b && j*2+i<=n; j++)
				if ((n-j*2-i)%4==0 && (n-j*2-i)/4<=c)
					res++;
		
		out.println(res);
		out.flush();
	}

}

// package CodeForces;

import java.io.*;
import java.util.*;

public class Problem_526A {
	public static boolean sol(int i,int sum,int diff)
	{
//		System.out.println(i);
		if(sum==4)
			return true;
		if(i==n || i==-1)
			return false;
		for(int j=i+1;j<n;j++)
		{
			if(s.charAt(j)=='*')
			{
				if(j-i==diff)
				{	
					if(sol(j,sum+1,diff))
						return true;
				}
				else
				{	
					if(sol(j,1,j-i))
						return true;
				}
			}
		}
		return false;
	}
	static int n;
	static String s;
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner();
		PrintWriter pw = new PrintWriter(System.out);
		n=sc.nextInt();
		s=sc.nextLine();
		int i=s.indexOf("*");
		if(sol(i,0,-1))
			System.out.println("yes");
		else
			System.out.println("no");
		pw.close();
	}

	static class Scanner {
		BufferedReader br;
		StringTokenizer st;

		Scanner() {
			br = new BufferedReader(new InputStreamReader(System.in));
		}

		String next() throws IOException {
			while (st == null || !st.hasMoreTokens()) {
				st = new StringTokenizer(br.readLine());
			}
			return st.nextToken();
		}

		int nextInt() throws IOException {
			return Integer.parseInt(next());
		}

		long nextLong() throws IOException {
			return Long.parseLong(next());
		}

		double nextDouble() throws IOException {
			return Double.parseDouble(next());
		}

		String nextLine() throws IOException {
			return br.readLine();
		}

		boolean hasnext() throws IOException {
			return br.ready();
		}

	}
}

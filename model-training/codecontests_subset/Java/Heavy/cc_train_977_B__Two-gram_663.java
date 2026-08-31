//package code_forces;

import java.io.*;
import java.util.*;

public class Problem_977B {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner();
		PrintWriter pw = new PrintWriter(System.out);
		int n=sc.nextInt();
		String s= sc.nextLine();
		int max=0;
		String ans="";
		for(int i=0;i<n-1;i++)
		{
			char f=s.charAt(i),sec=s.charAt(i+1);
			int count=1;
			for(int j=i+1;j<n-1;j++)
			{
				if(s.charAt(j)==f&& s.charAt(j+1)==sec)
					count++;
			}
			if(count>max)
			{
				max=count;
				ans=f+""+sec;
			}
		}
		
		pw.println(ans);
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

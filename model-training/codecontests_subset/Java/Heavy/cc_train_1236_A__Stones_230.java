


import java.util.*;

import java.io.*;
import java.math.BigInteger;

public class glass {

	static class pair implements Comparable<pair> {
		int x;
		int y;

		public pair(int d, int k) {
			x = d;
			y = k;
		}

		@Override
		public int compareTo(pair arg0) {
			// TODO Auto-generated method stub
			if (x == arg0.x) {
				return y - arg0.y;
			}
			return x - arg0.x;
		}
	}

	static int x, y, d;

	static void extendedEuclid(int a, int b) {
		if (b == 0) {
			x = 1;
			y = 0;
			d = a;
			return;
		}
		extendedEuclid(b, a % b);
		int x1 = y;
		int y1 = x - a / b * y;
		x = x1;
		y = y1;
	}

	static int q;
	static int w;

	static void solve(String be, String af) {
		if (be.length() == 0)
			q = 1;
		else if (be.charAt(0) == '-') {
			if (be.length() == 1)
				q = -1;
			else
				q = -1 * Integer.parseInt(be.substring(1));
		} else
			q = Integer.parseInt(be);
		if (af.length() == 0)
			w = 1;
		else
			w = Integer.parseInt(af);
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pw = new PrintWriter(System.out);
		int t = Integer.parseInt(br.readLine());
		while(t-->0){
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n=Integer.parseInt(st.nextToken());
			int b=Integer.parseInt(st.nextToken());
			int c=Integer.parseInt(st.nextToken());
			int sol=0;
			int x=n;
			int s=b;
			int w=c;
			if(c/2<=b) {
				sol=2*(c/2)+(c/2);
				b-=(c/2);
			}
			else
			{
				sol=b+2*b;
				b=0;
			}
			if(b>=2) {
				sol+=Math.min(3*(b/2), 3*n);
			}
			int i=sol;
//			sol=0;
//			if(c/2<=b) {
//				sol=2*(c/2)+(c/2);
//				b-=(c/2);
//			}
//			else
//			{
//				sol=b+2*b;
//			}
//			if(b>=2) {
//				sol+=Math.min(3*(b/2), 3*n);
//			}
			pw.println(sol);
		}
		pw.flush();
	}

	static long gcd(long a, long b) {
		if (b == 0)
			return a;
		return gcd(b, a % b);
	}

}
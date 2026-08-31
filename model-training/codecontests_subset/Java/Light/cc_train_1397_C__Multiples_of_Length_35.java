import java.util.Scanner;
import java.util.ArrayList;

public class C{
	static long x = 0;
	static long y = 1;
	public static long gcdEx(long a, long b){
		if(a == 0){
			return b;
		}
		long d = gcdEx(b%a,a);
		long x1 = x;
		long y1 = y;
		x = y1 - (b/a)*x1;
		y = x1;
		return d;
	}
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		StringBuilder res = new StringBuilder();
			int n = in.nextInt();
			long[] a = new long[n];
			for(int i = 0;i<n;++i)
				a[i] = in.nextLong();
			
			if(n == 1) res.append(1 + " " + 1 + "\n");
			else res.append("1 " + (n-1) + "\n");
			x = 0;
			y = 1;
			gcdEx(n-1, n);
			//System.out.println(x + " " + y);
			long temp = n*(n-1);
			for(int i = 0;i<n-1;++i){
				long temp2 = a[i]/(n-1);
				a[i] = a[i] - temp2*(n-1);
				res.append(-temp2*(n-1) - (n-1)*x*a[i] + " ");
				a[i] = a[i] - (n-1)*x*a[i];
			}
			if(n == 1) res.append(0);
			res.append("\n");
			
			res.append("1 " + n + "\n");
			for(int i = 0;i<n-1;++i){
				res.append(-a[i]+ " ");
			}
			res.append(-a[n-1]/n*n + "\n");
			a[n-1] = a[n-1] - a[n-1]/n*n;
			res.append(n+ " " + n + "\n");
			res.append(-a[n-1] + "\n");
		System.out.println(res.toString());
	}
}

			
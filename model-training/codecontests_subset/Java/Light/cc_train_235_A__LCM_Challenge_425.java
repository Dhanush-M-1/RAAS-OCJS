import java.io.*;
import java.util.*;
public class Solution {
	static Scanner sc=new Scanner(System.in);
	static PrintWriter out=new PrintWriter(System.out);
	//Main Method
	static long gcd(long a,long b) {
		return b==0?a:gcd(b,a%b);
	}
	static long lcm(long a,long b) {
		return a*b/gcd(a,b);
	}
	public static void main(String args[]) {
		int test=1;
		while(test-->0) {
			long n=sc.nextLong();
			if(n<4) {
				if(n==1) out.println(1);
				else if(n==2) out.println(2);
				else if(n==3)out.println(6);
				continue;
			}
			long ans=n;
			for(long i=4;i<=n;i++) {
				long x=lcm(i,lcm(i-1,i-2)),y=lcm(i,lcm(i-1,i-3));
				ans=Math.max(ans, Math.max(x, y));
			}
			out.println(ans);
		}
		out.flush();
		out.close();
	}
}

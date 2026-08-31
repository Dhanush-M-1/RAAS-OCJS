import java.io.*;
import java.util.*;
public class Solution {
	static Scanner sc=new Scanner(System.in);
	static PrintWriter out=new PrintWriter(System.out);
	//Main
	static int n;
	static double a[],eps=1e-11;;
	static double kadane(double arr[]) {
		double cur=0,res=0;
		for(int i=0;i<n;i++) {
			cur=Math.max(cur+arr[i], arr[i]);
			res=Math.max(res, cur);
		}
		return res;
	}
	static double check(double x) {
		double tmp[]=new double[n];
		for(int i=0;i<n;i++) tmp[i]=a[i]-x;
		double ans1=kadane(tmp);
		for(int i=0;i<n;i++) tmp[i]*=-1;
		double ans2=kadane(tmp);
		return Math.max(ans1, ans2);
	}
	public static void main(String args[]) {
		int test=1;
		//test=sc.nextInt();
		while(test-->0) {
			//Focus
			n=sc.nextInt();a=new double[n];
			double min=Double.MAX_VALUE,max=Double.MIN_VALUE;
			for(int i=0;i<n;i++) {
				a[i]=sc.nextDouble();
				min=Math.min(min, a[i]);
				max=Math.max(max, a[i]);
			}
			double l=min,r=max;
			while(r-l>eps) {
				double m1=l+(r-l)/3,m2=r-(r-l)/3;
				double f1=check(m1),f2=check(m2);
				if(f2<f1) l=m1;
				else r=m2;
			}
			double ans=Math.min(check(l), Math.min(check((l+r)/2), check(r)));
			out.printf("%.12f",ans);
		}
		out.flush();
		out.close();
	}
}

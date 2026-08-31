import java.util.*;
import java.io.*;
public class WeaknessPoorness {
	static int n;
	static double[] arr, sum;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		arr = new double[n];
		StringTokenizer st = new StringTokenizer(br.readLine());
		sum = new double[n];
		for(int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			sum[i] = (i == 0 ? 0 : sum[i-1]) + arr[i];
		}
		double a = -30000; double b = 30000; int iters = 0;
		for(; iters < 100; iters++){
			double c = (a+a+b)/3; double d = (a+b+b)/3;
			if(f(c) > f(d)) a = c;
			else b = d;
		}
		System.out.println(f(a));
	}
	static double f(double x){
		double res = Math.max(calc(x,-1), calc(x,1)); 
		return res;
	}
	static double calc(double x, int sign){
		double max = Long.MIN_VALUE;
		int c = -1;
		for(int i = 0; i < n; i++){
			if((sum[i]-(c<0?0:sum[c])-x*(i-c))*sign < 0) c = i;
			double curr = (sum[i]-(c<0?0:sum[c])-x*(i-c))*sign;
			max = Double.max(curr, max);
		}
		return max;
	}
}

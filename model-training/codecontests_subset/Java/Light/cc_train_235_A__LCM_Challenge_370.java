import java.util.*;
import java.io.*;

public class A {
	public static void main(String[] args) throws IOException {
		BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(rd.readLine());
		if(N<=50) brute_force(N);
		else{
			long ans;
			long n = N;
			if(N%2==1){
				ans = n*(n-1)*(n-2);
			}
			else{
				if(n%3!=0) ans = (n-1)*(n)*(n-3);
				else ans = (n-1)*(n-2)*(n-3);
			}
			System.out.println(ans);
		}
	}
	
	static void brute_force(int N){
		long best = 1;
		for(int a=1; a<=N; a++){
			for(int b=1; b<=N; b++){
				for(int c=1; c<=N; c++){
					best = Math.max(best, lcm(a, b, c));
				}
			}
		}
		System.out.println(best);
	}
	
	static long lcm(int a, int b, int c){
		return lcm(a, lcm(b, c));
	}
	
	static int lcm(int a, int b){
		return (a*b)/gcd(a,b);
	}
	
	static int gcd(int a, int b){
		if(a==0 || b==0) return a+b;
		if(a>b) return gcd(a%b, b);
		return gcd(a, b%a);
	}
	
}

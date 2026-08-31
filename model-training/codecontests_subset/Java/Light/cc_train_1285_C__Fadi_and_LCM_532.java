import java.util.Scanner;
public class Main {
	private static int[] ans=new int[1000001];
	public static void main(String[] args){
		Scanner cin=new Scanner(System.in);
		long x=cin.nextLong();
		long max=0;
		if(check(x)||x==1) {
			System.out.println(1+" "+x);
			return;
		}
		for(long i=1;i*i<=x;i++) {
			if(lcm(i,x/i)==x&&gcd(i,x/i)==1) {
				max=Math.max(max, i);
			}
		}
		System.out.println(max+" "+x/max);
	}
	public static long gcd(long m,long n) {
		return m%n==0?n:gcd(n,m%n);
	}
	public static long lcm(long m,long n) {
		return m*n/gcd(m,n);
	}
	public static boolean check(long n) {
		if(n<2) return false;
		for(int i=2;i<=Math.sqrt(n);i++) {
			if(n%i==0) return false;
		}
		return true;
	}
}
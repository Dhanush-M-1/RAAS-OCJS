import java.util.Scanner;

public class Solution {
	
	public static void main(String[] args) {
		Scanner scan=new Scanner(System.in);
		long t = scan.nextInt();
		long mod = 1000000007l;
		long fact=1l;
		for(long i=2;i<=t;i++) {
			fact=(fact*i) % mod;
		}
		System.out.println((fact+mod-modPow(2,t-1,mod))%mod);
	}
	
	 static long modPow(long a, long e, long mod)
	    {
	        a %= mod;
	        long res = 1;
	        while (e > 0) {
	            if ((e & 1) == 1)
	                res = (res * a) % mod;
	            a = (a * a) % mod;
	            e >>= 1;
	        }
	        return res;
	    }
}
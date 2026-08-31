import java.util.Scanner;

public class modinv {
	public static void main(String[] args) {
		Scanner scan=new Scanner(System.in);
		int n=scan.nextInt();
		
		fac=new long[n+1];
		fac[0]=1;

		for(int i=1;i<fac.length;i++) {
			fac[i]=mult(fac[i-1],i);
		}
		
		//xC0 + xC1 + ... xCx = all the subsets so it is just 2^x
		System.out.println((fac[n]-pow(2,n-1)+MOD)%MOD);
	}
	static long[] fac;
	static final int MOD=1_000_000_007;

	public static long pow(long b, long e) {
		if(e==0L) return 1L;
		if(e%2==0) {
			long temp=pow(b,e/2);
			return mult(temp,temp);
		}
		return mult(b,pow(b,e-1));
	}
	public static long mult(long a, long b) {
		return ((a%MOD)*(b%MOD))%MOD;
	}
}
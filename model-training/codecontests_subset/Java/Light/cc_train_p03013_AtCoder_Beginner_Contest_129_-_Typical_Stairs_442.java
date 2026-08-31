import java.util.Scanner;
public class Main {

	static long ln = 1000000007;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n=sc.nextInt();
		int m=sc.nextInt();
		long fibdp[] = new long[n+1];
		fibdp[0] = 1;
		fibdp[1] = 1;
		for(int i=2;i<=n;i++) {
			fibdp[i] = (fibdp[i-1] + fibdp[i-2])%ln;
		}
		int[] a = null;
		if(m!=0) {
			a = new int[m];
			for(int i=0;i<m;i++) {
				a[i] = sc.nextInt();
			}
		}
		long ans;
		if(m!=0)
			ans = fib(a[0] -1, fibdp)% ln;
		else
			ans = fib(n, fibdp)%ln;
		
		for(int i=1;i<m;i++) {
			if(a[i]-a[i-1] == 0) {
				ans = 0;
				break;
			}
			ans = (ans * (fib(a[i]-a[i-1]-2, fibdp)% ln)) %ln;
		}
		if(m!=0)
			ans = (ans * (fib(n - a[m-1] -1, fibdp)% ln)) %ln;
		
		System.out.print(ans);
	}
	
	public static long fib(int i, long[] fibdp) {
		if(i<0)
			return 0;
		else 
			return fibdp[i];
	}
}
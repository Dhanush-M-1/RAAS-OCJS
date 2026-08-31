import java.util.*;

public class Main {
	public static void main(String[] args) {
		int i;
		Scanner sc = new Scanner(System.in);
		int n = Integer.parseInt(sc.next());
		int m = Integer.parseInt(sc.next());
		int[] a = new int[m+2];
		a[0] = -1;
		for(i = 1; i <=m; i++) {
			a[i] = Integer.parseInt(sc.next());
		}
		sc.close();
		long[] fi = new long[100000+1];
		fi[0] = fi[1] = 1;
		for(i = 2; i < fi.length; i++) {
			fi[i] = fi[i-1] + fi[i-2];
			if(fi[i] >= 1000000007) fi[i] %= 1000000007;
		}
		a[m+1] = n+1;
		long cnt = 1;
		int dif = 0;
		for(i = 1; i <= m+1; i++) {
			dif = a[i] - a[i-1] -2;
//			System.out.println("dif:"+dif);
			if(dif == -1) {
				cnt = 0;
				break;
			}
//			System.out.println("fib("+dif+")");
			cnt *= fi[dif];
//			System.out.println("cnt:"+cnt);
			if(cnt >= 1000000007) {
				cnt %= 1000000007;
				if(cnt==0)break;
			}
		}
		System.out.println(cnt);
//		System.out.println(cnt%1000000007);
	}
	
	public static int fib(int n) {
		if(n == 0 || n == 1) return 1;
		return fib(n-1)+fib(n-2);
	}

}

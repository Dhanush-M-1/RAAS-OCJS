import java.util.Scanner;

public class Main{
	public static void main(String[] args){
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int m = scan.nextInt();

		long[] s = new long[100007];
		int len = s.length;
		long mod = 1000000007;

		s[0] = 1;
		s[1] = 1;

		int i;
		for(i = 2; i < len; i++)
			s[i] = (s[i - 1] + s[i - 2]) % mod;

		int[] a = new int[m];

		for(i = 0; i < m; i++) {
			a[i] = scan.nextInt();
			if(i != 0) {
				if(a[i] - a[i - 1] == 1) {
					System.out.println(0);
					return;
				}
			}
		}
		if(m == 0) {
			System.out.println(s[n]);
		}else {

			int start;
			int end;
			long ans = 1;
			for(i = 0; i < m; i++) {
				if(i == 0) {
					start = 0;
					end = a[i] - 1;
				}else {
					start = a[i - 1] + 1;
					end = a[i] - 1;
				}
				ans = (ans * s[end - start]) % mod;
			}
			ans = (ans * s[n - (a[m - 1] + 1)]) % mod;
			System.out.println(ans);
		}


	}
}

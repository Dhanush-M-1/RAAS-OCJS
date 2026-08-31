//package Codeforces;

import java.util.Scanner;

public class lcmChallenge {
	static long gcd(long a, long b) {
		return b==0?a:gcd(b, a%b);
	}
public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	int n = sc.nextInt();
	if(n==2||n==1)
		System.out.println(n);
	else if(n==3)
		System.out.println(6);
	else {
		long ans = 1;
		for (int i = 4; i <=n; i++) {

			long gcd = gcd(i, i-1);
			long lcm = i*1l*(i-1);
			long third =i-2;
			gcd = gcd(third, lcm);
			while(gcd!=1&&third>1) {
				ans= Math.max(ans, lcm*third/gcd);
//				System.out.println(lcm*third/gcd+" "+third);
				third--;
				gcd = gcd(third, lcm);
			}
			lcm*=(third);
			ans = Math.max(lcm, ans);

		}

		System.out.println(ans);
	}
}
}

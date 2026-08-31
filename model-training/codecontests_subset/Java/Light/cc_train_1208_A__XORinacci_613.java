

import java.util.Scanner;

public class XORNACCI {

	public static void main(String[] args) {
	Scanner nik = new Scanner(System.in);
		int t = nik.nextInt();
		while (t-- > 0) {
			long a = nik.nextLong();
			long b = nik.nextLong();
			long n = nik.nextLong();
			if (n == 0) {
				System.out.println(a);
			} else {
				n = n % 3;
				for (int i = 1; i <= n; i++) {
					long temp = b;
					long nprv = a ^ b;
					a = b;
					b = nprv;

				}
				System.out.println(a);
			}
		}
	}

}

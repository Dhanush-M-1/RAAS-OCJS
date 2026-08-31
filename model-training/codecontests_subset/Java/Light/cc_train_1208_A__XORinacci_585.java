import java.util.Scanner;

public class AXORinacci {
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int t = scn.nextInt();
		while (t-- > 0) {
			long a = scn.nextLong();
			long b = scn.nextLong();
			int n = scn.nextInt();
			int rem = n % 3;
			if (rem == 0) {
				System.out.println(a);
			} else if (rem == 1) {
				System.out.println(b);
			} else {
				System.out.println(a ^ b);
			}
		}
		scn.close();
	}
}
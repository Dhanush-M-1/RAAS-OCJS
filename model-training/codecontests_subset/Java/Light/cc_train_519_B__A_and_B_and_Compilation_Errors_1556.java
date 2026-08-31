import java.util.Scanner;


public class B {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		long n = scan.nextLong();
		long count = 0, count2 = 0;
		for (long i = 0; i < n; i++) {
			count += scan.nextLong();
		}
		for (long i = 0; i < n - 1; i++) {
			count2 += scan.nextLong();
		}
		System.out.println(count - count2);
		count = 0;
		for (long i = 0; i < n - 2; i++) {
			count += scan.nextLong();
		}
		System.out.println(count2 - count);
	}

}



public class Main {
	public static void main(String args[]) {
		java.util.Scanner sc = new java.util.Scanner(System.in);
		long A = sc.nextInt();
		long B = sc.nextInt();

		if (A > 9 || B > 9) {
			System.out.println("-1");
		} else {
			System.out.println(A*B);
		}

	}
}
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int A = in.nextInt();
		int B = in.nextInt();
		if (A < 10 && B < 10) {
			System.out.println(A * B);
		} else {
			System.out.println(-1);
		}
		in.close();
	}
}
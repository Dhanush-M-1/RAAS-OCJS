import java.util.Scanner;

public class A478 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int a = in.nextInt();
		int b = in.nextInt();
		int c = in.nextInt();
		int d = in.nextInt();
		int e = in.nextInt();
		int s = a + b + c + d + e;
		if (s == 0 || s % 5 != 0) {
			System.out.println(-1);
		} else {
			System.out.println(s / 5);
		}

	}
}

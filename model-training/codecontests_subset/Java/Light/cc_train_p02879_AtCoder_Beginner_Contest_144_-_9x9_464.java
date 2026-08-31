import java.util.Scanner;

class Main {
	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			boolean bl = a < 10 && b < 10;
			if (bl) {
				System.out.println(a * b);
			} else {
				System.out.println(-1);
			}
		}
	}
}